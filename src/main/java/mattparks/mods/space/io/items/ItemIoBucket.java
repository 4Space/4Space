package mattparks.mods.space.io.items;

import java.util.List;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.core.proxy.ClientProxy;
import mattparks.mods.space.io.IoCore;
import mattparks.mods.space.io.blocks.IoBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class ItemIoBucket extends Item
{
	private Block isFull;

	private static final String[] bucketTypes = new String[] {
			"titaniumBucket",
			"ioLavaBucket",
			"liquidRedSulfurBucket",
			"liquidYellowSulfurBucket",
			"liquidOrangeSulfurBucket"
	};

	private IIcon[] textures;

	public ItemIoBucket(String name)
	{
		super();
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		this.setUnlocalizedName(name);
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack)
	{
		return ClientProxy.spaceItem;
	}

	@Override
	public CreativeTabs getCreativeTab()
	{
		return SpaceCore.spaceItemsTab;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		this.isFull = ItemIoBucket.getLiquidFromMeta(itemstack.getItemDamage());
		final boolean flag = this.isFull == Blocks.air;

		if (itemstack.getItem() == this && itemstack.getItemDamage() == 0)
		{
			final MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(world, player, true);

			if (pos == null)
			{
				return itemstack;
			}
			else
			{
				final Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);
				final int meta = world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ);

				if (block == IoBlocks.ioLavaFlowing && meta == 0 || block == IoBlocks.ioLavaStill && meta == 0)
				{
					if (player.capabilities.isCreativeMode)
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						return itemstack;
					}
					if (--itemstack.stackSize <= 0)
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						return new ItemStack(this, 1, 1);
					}
					if (!player.inventory.addItemStackToInventory(new ItemStack(this, 1, 1)))
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						player.entityDropItem(new ItemStack(this, 1, 1), 1.0F);
					}
					return itemstack;
				}
				else if (block == IoBlocks.liquidRedSulfurFlowing && meta == 0 || block == IoBlocks.liquidRedSulfurStill && meta == 0)
				{
					if (player.capabilities.isCreativeMode)
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						return itemstack;
					}
					if (--itemstack.stackSize <= 0)
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						return new ItemStack(this, 1, 2);
					}
					if (!player.inventory.addItemStackToInventory(new ItemStack(this, 1, 2)))
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						player.entityDropItem(new ItemStack(this, 1, 2), 1.0F);
					}
					return itemstack;
				}
				else if (block == IoBlocks.liquidYellowSulfurFlowing && meta == 0 || block == IoBlocks.liquidYellowSulfurStill && meta == 0)
				{
					if (player.capabilities.isCreativeMode)
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						return itemstack;
					}
					if (--itemstack.stackSize <= 0)
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						return new ItemStack(this, 1, 3);
					}
					if (!player.inventory.addItemStackToInventory(new ItemStack(this, 1, 3)))
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						player.entityDropItem(new ItemStack(this, 1, 3), 1.0F);
					}
					return itemstack;
				}
				else if (block == IoBlocks.liquidOrangeSulfurFlowing && meta == 0 || block == IoBlocks.liquidOrangeSulfurStill && meta == 0)
				{
					if (player.capabilities.isCreativeMode)
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						return itemstack;
					}
					if (--itemstack.stackSize <= 0)
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						return new ItemStack(this, 1, 4);
					}
					if (!player.inventory.addItemStackToInventory(new ItemStack(this, 1, 4)))
					{
						world.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
						player.entityDropItem(new ItemStack(this, 1, 4), 1.0F);
					}
					return itemstack;
				}
				else
				{
					return itemstack;
				}
			}
		}
		else
		{
			final MovingObjectPosition pos = this.getMovingObjectPositionFromPlayer(world, player, flag);

			if (pos == null)
			{
				return itemstack;
			}
			else if (pos.typeOfHit == MovingObjectType.BLOCK)
			{
				int i = pos.blockX;
				int j = pos.blockY;
				int k = pos.blockZ;

				if (!world.canMineBlock(player, i, j, k))
				{
					return itemstack;
				}
				if (this.isFull == Blocks.air)
				{
					return new ItemStack(this, 1, 0);
				}
				if (pos.sideHit == 0)
				{
					--j;
				}
				if (pos.sideHit == 1)
				{
					++j;
				}
				if (pos.sideHit == 2)
				{
					--k;
				}
				if (pos.sideHit == 3)
				{
					++k;
				}
				if (pos.sideHit == 4)
				{
					--i;
				}
				if (pos.sideHit == 5)
				{
					++i;
				}
				if (!player.canPlayerEdit(i, j, k, pos.sideHit, itemstack))
				{
					return itemstack;
				}
				if (this.tryPlaceContainedLiquid(world, i, j, k, itemstack) && !player.capabilities.isCreativeMode)
				{
					return new ItemStack(this, 1, 0);
				}
			}
		}
		return itemstack;
	}

	public boolean tryPlaceContainedLiquid(World par1World, int x, int y, int z, ItemStack itemstack)
	{
		Material material = par1World.getBlock(x, y, z).getMaterial();
		boolean flag = !material.isSolid();

		if (this.isFull == Blocks.air)
		{
			return false;
		}
		else if (!par1World.isAirBlock(x, y, z) && par1World.getBlock(x, y, z).getMaterial().isSolid())
		{
			return false;
		}
		if (par1World.provider.isHellWorld && this.isFull != Blocks.air)
		{
			par1World.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, "random.fizz", 0.5F, 2.6F + (par1World.rand.nextFloat() - par1World.rand.nextFloat()) * 0.8F);

			for (int l = 0; l < 8; l++)
			{
				par1World.spawnParticle("largesmoke", x + Math.random(), y + Math.random(), z + Math.random(), 0.0D, 0.0D, 0.0D);
			}
		}
		else
		{
			if (!par1World.isRemote && flag && !material.isLiquid())
			{
				par1World.func_147480_a(x, y, z, true);
			}
			par1World.setBlock(x, y, z, this.isFull, 0, 3);
		}
		return true;
	}

	private static Block getLiquidFromMeta(int meta)
	{
		switch (meta)
		{
			case 1:
			default:
				return IoBlocks.ioLavaFlowing;
			case 2:
				return IoBlocks.liquidRedSulfurFlowing;
			case 3:
				return IoBlocks.liquidYellowSulfurFlowing;
			case 4:
				return IoBlocks.liquidOrangeSulfurFlowing;
		}
	}

	@Override
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int i = 0; i < ItemIoBucket.bucketTypes.length; ++i)
		{
			par3List.add(new ItemStack(par1, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int meta = itemStack.getItemDamage();

		if (meta < 0 || meta >= ItemIoBucket.bucketTypes.length)
		{
			meta = 0;
		}
		return super.getUnlocalizedName() + "." + ItemIoBucket.bucketTypes[meta];
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.textures = new IIcon[5];
		this.textures[0] = iconRegister.registerIcon(IoCore.TEXTURE_PREFIX + "titaniumBucket");
		this.textures[1] = iconRegister.registerIcon(IoCore.TEXTURE_PREFIX + "ioLavaBucket");
		this.textures[2] = iconRegister.registerIcon(IoCore.TEXTURE_PREFIX + "liquidRedSulfurBucket");
		this.textures[3] = iconRegister.registerIcon(IoCore.TEXTURE_PREFIX + "liquidYellowSulfurBucket");
		this.textures[4] = iconRegister.registerIcon(IoCore.TEXTURE_PREFIX + "liquidOrangeSulfurBucket");
	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		return this.textures[meta];
	}
}
