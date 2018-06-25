package mattparks.mods.space.europa.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mattparks.mods.space.core.SpaceCore;
import mattparks.mods.space.europa.EuropaCore;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.IIcon;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockEuropaIce extends BlockBreakable {
	private IIcon[] iceIcon = new IIcon[3];

	public BlockEuropaIce(String name) {
		super("", Material.ice, false);
		this.slipperiness = 0.98F;
		this.setTickRandomly(true);
		this.setHardness(0.5F);
		this.setBlockName(name);
		this.setStepSound(soundTypeGlass);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return SpaceCore.spaceBlocksTab;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return this.iceIcon[meta];
	}

	@Override
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < 3; ++i) {
			list.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		return super.shouldSideBeRendered(world, x, y, z, 1 - side);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta) {
		player.addStat(StatList.mineBlockStatArray[Block.getIdFromBlock(this)], 1);
		player.addExhaustion(0.025F);

		if (this.canSilkHarvest(world, player, x, y, z, meta) && EnchantmentHelper.getSilkTouchModifier(player)) {
			final ArrayList<ItemStack> items = new ArrayList<ItemStack>();
			final ItemStack itemstack = this.createStackedBlock(meta);

			if (itemstack != null) {
				items.add(itemstack);
			}

			ForgeEventFactory.fireBlockHarvesting(items, world, this, x, y, z, meta, 0, 1.0f, true, player);
			for (final ItemStack is : items) {
				this.dropBlockAsItem(world, x, y, z, is);
			}
		} else {
			if (world.provider.isHellWorld) {
				world.setBlockToAir(x, y, z);
				return;
			}

			final int i1 = EnchantmentHelper.getFortuneModifier(player);
			this.harvesters.set(player);
			this.dropBlockAsItem(world, x, y, z, meta, i1);
			this.harvesters.set(null);
			final Material material = world.getBlock(x, y - 1, z).getMaterial();

			if (material.blocksMovement() || material.isLiquid()) {
				world.setBlock(x, y, z, EuropaBlocks.europaWaterFluidBlock);
			}
		}
	}

	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (world.getSavedLightValue(EnumSkyBlock.Block, x, y, z) > 11 - this.getLightOpacity()) {
			if (world.provider.isHellWorld) {
				world.setBlockToAir(x, y, z);
				return;
			}
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlock(x, y, z, EuropaBlocks.europaWaterFluidBlock);
		}
	}

	@Override
	public int getMobilityFlag() {
		return 0;
	}

	public MapColor getMapColor(int meta) {
		switch (meta) {
		case 0:
			return MapColor.blueColor;
		default:
			return MapColor.blueColor;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iceIcon[0] = iconRegister.registerIcon(EuropaCore.TEXTURE_PREFIX + "europaIce");
		this.iceIcon[1] = iconRegister.registerIcon(EuropaCore.TEXTURE_PREFIX + "dirtyEuropaIce");
		this.iceIcon[2] = iconRegister.registerIcon(EuropaCore.TEXTURE_PREFIX + "denseEuropaIce");
	}
}
