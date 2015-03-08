package mattparks.mods.space.io.blocks;

import java.util.Random;

import mattparks.mods.space.io.IoCore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockIoLavaFlowing extends BlockIoLiquid {
	private final boolean[] field_149814_b = new boolean[4];
	private final int[] field_149816_M = new int[4];
	int field_149815_a;
	private IIcon[] ioLavaIcon;
	private String stillTexture;
	private String flowingTexture;
	private boolean usingMinecraftDirectory;

	public BlockIoLavaFlowing(String name, String stillTexture, String flowingTexture) {
		super(Material.lava);
		this.setHardness(100.0F);
		this.setResistance(100.0F);
		this.setLightLevel(1.0F);
		this.stillTexture = stillTexture;
		this.flowingTexture = flowingTexture;
		this.setBlockName(name);
	}

	public BlockIoLavaFlowing(String name, String stillTexture, String flowingTexture, boolean usingMcTexture) {
		super(Material.lava);
		this.usingMinecraftDirectory = usingMcTexture;
		this.stillTexture = stillTexture;
		this.flowingTexture = flowingTexture;
		this.setHardness(100.0F);
		this.setResistance(100.0F);
		this.setLightLevel(1.0F);
		this.setBlockName(name);
	}

	@Override
	public void registerBlockIcons(IIconRegister icon) {
		if (!this.usingMinecraftDirectory) {
			this.ioLavaIcon = new IIcon[] { icon.registerIcon(IoCore.TEXTURE_PREFIX + this.stillTexture), icon.registerIcon(IoCore.TEXTURE_PREFIX + this.flowingTexture) };
		} else {
			this.ioLavaIcon = new IIcon[] { icon.registerIcon(this.stillTexture), icon.registerIcon(this.flowingTexture) };
		}
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		return side != 0 && side != 1 ? this.ioLavaIcon[1] : this.ioLavaIcon[0];
	}

	private void func_149811_n(World world, int x, int y, int z) {
		final int i = world.getBlockMetadata(x, y, z);
		world.setBlock(x, y, z, Block.getBlockById(Block.getIdFromBlock(this) + 1), i, 2);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		int i = this.func_149804_e(world, x, y, z);
		final int j = 2;
		final int k = 1;
		int m = this.tickRate(world);
		int i1;

		if (i > 0) {
			int n = -100;
			this.field_149815_a = 0;
			n = this.func_149810_a(world, x - 1, y, z, n);
			n = this.func_149810_a(world, x + 1, y, z, n);
			n = this.func_149810_a(world, x, y, z - 1, n);
			n = this.func_149810_a(world, x, y, z + 1, n);
			i1 = n + j;

			if (i1 >= 8 || n < 0) {
				i1 = -1;
			}
			if (this.func_149804_e(world, x, y + 1, z) >= 0) {
				final int i2 = this.func_149804_e(world, x, y + 1, z);

				if (i2 >= 8) {
					i1 = i2;
				} else {
					i1 = i2 + 8;
				}
			}
			if (this.blockMaterial == Material.lava && i < 8 && i1 < 8 && i1 > i && rand.nextInt(4) != 0) {
				m *= 4;
			}
			if (i1 == i) {
				if (k != 0) {
					this.func_149811_n(world, x, y, z);
				}
			} else {
				i = i1;

				if (i < 0) {
					world.setBlockToAir(x, y, z);
				} else {
					world.setBlockMetadataWithNotify(x, y, z, i, 2);
					world.scheduleBlockUpdate(x, y, z, this, m);
					world.notifyBlocksOfNeighborChange(x, y, z, this);
				}
			}
		} else {
			this.func_149811_n(world, x, y, z);
		}
		if (this.func_149809_q(world, x, y - 1, z)) {
			if (this.blockMaterial == Material.lava && world.getBlock(x, y - 1, z).getMaterial() == Material.water) {
				world.setBlock(x, y - 1, z, IoBlocks.ioBasicBlock, 2, 3);
				this.func_149799_m(world, x, y - 1, z);
				return;
			}
			if (i >= 8) {
				this.func_149813_h(world, x, y - 1, z, i);
			} else {
				this.func_149813_h(world, x, y - 1, z, i + 8);
			}
		} else if (i >= 0 && (i == 0 || this.func_149807_p(world, x, y - 1, z))) {
			final boolean[] arrayOfBoolean = this.func_149808_o(world, x, y, z);
			i1 = i + j;

			if (i >= 8) {
				i1 = 1;
			}
			if (i1 >= 8) {
				return;
			}
			if (arrayOfBoolean[0]) {
				this.func_149813_h(world, x - 1, y, z, i1);
			}
			if (arrayOfBoolean[1]) {
				this.func_149813_h(world, x + 1, y, z, i1);
			}
			if (arrayOfBoolean[2]) {
				this.func_149813_h(world, x, y, z - 1, i1);
			}
			if (arrayOfBoolean[3]) {
				this.func_149813_h(world, x, y, z + 1, i1);
			}
		}
	}

	private void func_149813_h(World world, int x, int y, int z, int meta) {
		if (this.func_149809_q(world, x, y, z)) {
			this.func_149799_m(world, x, y, z);
			world.setBlock(x, y, z, this, meta, 3);
		}
	}

	private int func_149812_c(World world, int x, int y, int z, int par5, int par6) {
		int i = 1000;

		for (int j = 0; j < 4; j++) {
			if ((j != 0 || par6 != 1) && (j != 1 || par6 != 0) && (j != 2 || par6 != 3) && (j != 3 || par6 != 2)) {
				int k = x;
				final int m = y;
				int n = z;

				if (j == 0) {
					k--;
				}
				if (j == 1) {
					k++;
				}
				if (j == 2) {
					n--;
				}
				if (j == 3) {
					n++;
				}
				if (!this.func_149807_p(world, k, m, n)) {
					if (world.getBlock(k, m, n).getMaterial() != this.blockMaterial || world.getBlockMetadata(k, m, n) != 0) {
						if (this.func_149807_p(world, k, m - 1, n)) {
							if (par5 < 4) {
								final int i1 = this.func_149812_c(world, k, m, n, par5 + 1, j);

								if (i1 < i) {
									i = i1;
								}
							}
						} else {
							return par5;
						}
					}
				}
			}
		}
		return i;
	}

	private boolean[] func_149808_o(World world, int x, int y, int z) {
		for (int i = 0; i < 4; i++) {
			this.field_149816_M[i] = 1000;
			int j = x;
			final int k = y;
			int m = z;

			if (i == 0) {
				j--;
			}
			if (i == 1) {
				j++;
			}
			if (i == 2) {
				m--;
			}
			if (i == 3) {
				m++;
			}
			if (!this.func_149807_p(world, j, k, m)) {
				if (world.getBlock(j, k, m).getMaterial() != this.blockMaterial || world.getBlockMetadata(j, k, m) != 0) {
					if (this.func_149807_p(world, j, k - 1, m)) {
						this.field_149816_M[i] = this.func_149812_c(world, j, k, m, 1, i);
					} else {
						this.field_149816_M[i] = 0;
					}
				}
			}
		}

		int i = this.field_149816_M[0];

		for (int j = 1; j < 4; j++) {
			if (this.field_149816_M[j] < i) {
				i = this.field_149816_M[j];
			}
		}
		for (int j = 0; j < 4; j++) {
			this.field_149814_b[j] = (this.field_149816_M[j] == i ? 1 : false) != null;
		}
		return this.field_149814_b;
	}

	private boolean func_149807_p(World world, int x, int y, int z) {
		final Block localBlock = world.getBlock(x, y, z);

		if (localBlock == Blocks.wooden_door || localBlock == Blocks.iron_door || localBlock == Blocks.standing_sign || localBlock == Blocks.ladder || localBlock == Blocks.reeds) {
			return true;
		}
		if (localBlock.getMaterial() == Material.portal) {
			return true;
		}
		return localBlock.getMaterial().blocksMovement();
	}

	protected int func_149810_a(World world, int x, int y, int z, int par5) {
		int i = this.func_149804_e(world, x, y, z);

		if (i < 0) {
			return par5;
		}
		if (i == 0) {
			this.field_149815_a += 1;
		}
		if (i >= 8) {
			i = 0;
		}
		return par5 < 0 || i < par5 ? i : par5;
	}

	private boolean func_149809_q(World world, int x, int y, int z) {
		final Material localMaterial = world.getBlock(x, y, z).getMaterial();

		if (localMaterial == this.blockMaterial) {
			return false;
		}
		if (localMaterial == Material.lava) {
			return false;
		}
		return !this.func_149807_p(world, x, y, z);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);

		if (world.getBlock(x, y, z) == this) {
			world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
		}
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.setFire(10);
	}

	@Override
	public boolean func_149698_L() {
		return true;
	}
}
