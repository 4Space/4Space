package mattparks.mods.exoplanets.elipse.entites;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityElipsianVillager extends EntityAgeable implements IEntityBreathable {
	private int randomTickDivider;
	private Village villageObj;

	public EntityElipsianVillager(World par1World) {
		super(par1World);
		this.randomTickDivider = 0;
		this.villageObj = null;
		this.setSize(0.6F, 1.8F);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMoveIndoors(this));
		this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.3F));
		this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 15.0F, 1.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityVillager.class, 15.0F, 0.05F));
		this.tasks.addTask(9, new EntityAIWander(this, 0.3F));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 15.0F));
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}

	@Override
	public boolean canBreath() {
		return true;
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable par1EntityAgeable) {
		return this.func_90012_b(par1EntityAgeable);
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, Integer.valueOf(0));
	}

	public EntityElipsianVillager func_90012_b(EntityAgeable par1EntityAgeable) {
		final EntityElipsianVillager entityvillager = new EntityElipsianVillager(this.worldObj);
		return entityvillager;
	}

	@SideOnly(Side.CLIENT)
	private void generateRandomParticles(String par1Str) {
		for (int i = 0; i < 5; ++i) {
			final double d0 = this.rand.nextGaussian() * 0.02D;
			final double d1 = this.rand.nextGaussian() * 0.02D;
			final double d2 = this.rand.nextGaussian() * 0.02D;
			this.worldObj.spawnParticle(par1Str, this.posX + this.rand.nextFloat() * this.width * 2.0F - this.width, this.posY + 1.0D + this.rand.nextFloat() * this.height, this.posZ + this.rand.nextFloat() * this.width * 2.0F - this.width, d0, d1, d2);
		}
	}

	@Override
	protected String getLivingSound() {
		return "mob.villager.idle";
	}

	@Override
	protected String getHurtSound() {
		return "mob.villager.hit";
	}

	@Override
	protected String getDeathSound() {
		return "mob.villager.death";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void handleHealthUpdate(byte par1) {
		if (par1 == 12) {
			this.generateRandomParticles("heart");
		} else if (par1 == 13) {
			this.generateRandomParticles("angryVillager");
		} else if (par1 == 14) {
			this.generateRandomParticles("happyVillager");
		} else {
			super.handleHealthUpdate(par1);
		}
	}

	@Override
	public boolean isAIEnabled() {
		return true;
	}

	@Override
	public void onDeath(DamageSource par1DamageSource) {
		if (this.villageObj != null) {
			final Entity entity = par1DamageSource.getEntity();

			if (entity != null) {
				if (entity instanceof EntityPlayer) {
					this.villageObj.setReputationForPlayer(((EntityPlayer) entity).getCommandSenderName(), -2);
				} else if (entity instanceof IMob) {
					this.villageObj.endMatingSeason();
				}
			} else if (entity == null) {
				final EntityPlayer entityplayer = this.worldObj.getClosestPlayerToEntity(this, 16.0D);

				if (entityplayer != null) {
					this.villageObj.endMatingSeason();
				}
			}
		}
		super.onDeath(par1DamageSource);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
	}

	@Override
	public void setRevengeTarget(EntityLivingBase par1EntityLiving) {
		super.setRevengeTarget(par1EntityLiving);

		if (this.villageObj != null && par1EntityLiving != null) {
			this.villageObj.addOrRenewAgressor(par1EntityLiving);

			if (par1EntityLiving instanceof EntityPlayer) {
				byte b0 = -1;

				if (this.isChild()) {
					b0 = -3;
				}

				this.villageObj.setReputationForPlayer(((EntityPlayer) par1EntityLiving).getCommandSenderName(), b0);

				if (this.isEntityAlive()) {
					this.worldObj.setEntityState(this, (byte) 13);
				}
			}
		}
	}

	@Override
	protected void updateAITick() {
		if (--this.randomTickDivider <= 0) {
			this.worldObj.villageCollectionObj.addVillagerPosition(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
			this.randomTickDivider = 70 + this.rand.nextInt(50);
			this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);

			if (this.villageObj == null) {
				this.detachHome();
			} else {
				final ChunkCoordinates chunkcoordinates = this.villageObj.getCenter();
				this.setHomeArea(chunkcoordinates.posX, chunkcoordinates.posY, chunkcoordinates.posZ, (int) (this.villageObj.getVillageRadius() * 0.6F));
			}
		}
		super.updateAITick();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
	}
}
