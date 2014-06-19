package mattparks.mods.space.mercury.entity;

import mattparks.mods.space.mercury.items.GCMercuryItems;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class GCMercuryEntityEvolvedSlime extends EntityLiving implements IMob, IEntityBreathable
{
    public float squishAmount;
    public float squishFactor;
    public float prevSquishFactor;

    private int evolvedSlimeJumpDelay;

    public GCMercuryEntityEvolvedSlime(World par1World)
    {
        super(par1World);
        int i = 1 << this.rand.nextInt(3);
        this.yOffset = 0.0F;
        this.evolvedSlimeJumpDelay = this.rand.nextInt(20) + 10;
        this.setEvolvedSlimeSize(i);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)1));
    }

    protected void setEvolvedSlimeSize(int par1)
    {
        this.dataWatcher.updateObject(16, new Byte((byte)par1));
        this.setSize(0.6F * (float)par1, 0.6F * (float)par1);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute((double)(par1 * par1));
        this.setHealth(this.getMaxHealth());
        this.experienceValue = par1;
    }

    public int getEvolvedSlimeSize()
    {
        return this.dataWatcher.getWatchableObjectByte(16);
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Size", this.getEvolvedSlimeSize() - 1);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setEvolvedSlimeSize(par1NBTTagCompound.getInteger("Size") + 1);
    }

    protected String getEvolvedSlimeParticle()
    {
        return "";
    }

    protected String getJumpSound()
    {
        return "mob.slime." + (this.getEvolvedSlimeSize() > 1 ? "big" : "small");
    }

    public void onUpdate()
    {
        if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0 && this.getEvolvedSlimeSize() > 0)
        {
            this.isDead = true;
        }

        this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
        this.prevSquishFactor = this.squishFactor;
        boolean flag = this.onGround;
        super.onUpdate();
        int i;

        if (this.onGround && !flag)
        {
            i = this.getEvolvedSlimeSize();

            for (int j = 0; j < i * 8; ++j)
            {
                float f = this.rand.nextFloat() * (float)Math.PI * 2.0F;
                float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
                float f2 = MathHelper.sin(f) * (float)i * 0.5F * f1;
                float f3 = MathHelper.cos(f) * (float)i * 0.5F * f1;
                this.worldObj.spawnParticle(this.getEvolvedSlimeParticle(), this.posX + (double)f2, this.boundingBox.minY, this.posZ + (double)f3, 0.0D, 0.0D, 0.0D);
            }

            if (this.makesSoundOnLand())
            {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
            }

            this.squishAmount = -0.5F;
        }
        else if (!this.onGround && flag)
        {
            this.squishAmount = 1.0F;
        }

        this.alterSquishAmount();

        if (this.worldObj.isRemote)
        {
            i = this.getEvolvedSlimeSize();
            this.setSize(0.6F * (float)i, 0.6F * (float)i);
        }
    }

    protected void updateEntityActionState()
    {
        this.despawnEntity();
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

        if (entityplayer != null)
        {
            this.faceEntity(entityplayer, 10.0F, 20.0F);
        }

        if (this.onGround && this.evolvedSlimeJumpDelay-- <= 0)
        {
            this.evolvedSlimeJumpDelay = this.getJumpDelay();

            if (entityplayer != null)
            {
                this.evolvedSlimeJumpDelay /= 3;
            }

            this.isJumping = true;

            if (this.makesSoundOnJump())
            {
                this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
            }

            this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
            this.moveForward = (float)(1 * this.getEvolvedSlimeSize());
        }
        else
        {
            this.isJumping = false;

            if (this.onGround)
            {
                this.moveStrafing = this.moveForward = 0.0F;
            }
        }
    }

    protected void alterSquishAmount()
    {
        this.squishAmount *= 0.9F;
    }

    protected int getJumpDelay()
    {
        return this.rand.nextInt(20) + 10;
    }

    protected GCMercuryEntityEvolvedSlime createInstance()
    {
        return new GCMercuryEntityEvolvedSlime(this.worldObj);
    }

    public void setDead()
    {
        int i = this.getEvolvedSlimeSize();

        if (!this.worldObj.isRemote && i > 1 && this.getHealth() <= 0.0F)
        {
            int j = 2 + this.rand.nextInt(3);

            for (int k = 0; k < j; ++k)
            {
                float f = ((float)(k % 2) - 0.5F) * (float)i / 4.0F;
                float f1 = ((float)(k / 2) - 0.5F) * (float)i / 4.0F;
                GCMercuryEntityEvolvedSlime entityEvolvedSlime = this.createInstance();
                entityEvolvedSlime.setEvolvedSlimeSize(i / 2);
                entityEvolvedSlime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
                this.worldObj.spawnEntityInWorld(entityEvolvedSlime);
            }
        }

        super.setDead();
    }

    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
        if (this.canDamagePlayer())
        {
            int i = this.getEvolvedSlimeSize();

            if (this.canEntityBeSeen(par1EntityPlayer) && this.getDistanceSqToEntity(par1EntityPlayer) < 0.6D * (double)i * 0.6D * (double)i && par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), (float)this.getAttackStrength()))
            {
                this.playSound("mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }
        }
    }

    protected boolean canDamagePlayer()
    {
        return this.getEvolvedSlimeSize() > 1;
    }

    protected int getAttackStrength()
    {
        return this.getEvolvedSlimeSize();
    }

    protected String getHurtSound()
    {
        return "mob.slime." + (this.getEvolvedSlimeSize() > 1 ? "big" : "small");
    }

    protected String getDeathSound()
    {
        return "mob.slime." + (this.getEvolvedSlimeSize() > 1 ? "big" : "small");
    }

    protected int getDropItemId()
    {
        return this.getEvolvedSlimeSize() == 1 ? GCMercuryItems.redSlimeball.itemID : 0;
    }

//    public boolean getCanSpawnHere()
//    {
//        Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
//
//        if (this.worldObj.getWorldInfo().getTerrainType().handleEvolvedSlimeSpawnReduction(rand, worldObj))
//        {
//            return false;
//        }
//        else
//        {
//            if (this.getEvolvedSlimeSize() == 1 || this.worldObj.difficultySetting > 0)
//            {
//                BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
//
//                if (biomegenbase == BiomeGenBase.swampland && this.posY > 50.0D && this.posY < 70.0D && this.rand.nextFloat() < 0.5F && this.rand.nextFloat() < this.worldObj.getCurrentMoonPhaseFactor() && this.worldObj.getBlockLightValue(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) <= this.rand.nextInt(8))
//                {
//                    return super.getCanSpawnHere();
//                }
//
//                if (this.rand.nextInt(10) == 0 && chunk.getRandomWithSeed(987234911L).nextInt(10) == 0 && this.posY < 40.0D)
//                {
//                    return super.getCanSpawnHere();
//                }
//            }
//
//            return false;
//        }
//    }

    protected float getSoundVolume()
    {
        return 0.4F * (float)this.getEvolvedSlimeSize();
    }

    public int getVerticalFaceSpeed()
    {
        return 0;
    }

    protected boolean makesSoundOnJump()
    {
        return this.getEvolvedSlimeSize() > 0;
    }

    protected boolean makesSoundOnLand()
    {
        return this.getEvolvedSlimeSize() > 2;
    }

	@Override
	public boolean canBreath() 
	{
		return true;
	}
}
