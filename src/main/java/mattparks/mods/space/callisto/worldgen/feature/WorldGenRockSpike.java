package mattparks.mods.space.callisto.worldgen.feature;

import java.util.Random;

import mattparks.mods.space.callisto.blocks.CallistoBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenRockSpike extends WorldGenerator
{
	@Override
	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		while (world.isAirBlock(x, y, z) && y > 2)
		{
			y--;
		}
		if (world.getBlock(x, y, z) != CallistoBlocks.callistoBasicBlock && world.getBlockMetadata(x, y, z) == 0)
		{
			return false;
		}

		y += rand.nextInt(4);
		int i = rand.nextInt(4) + 7;
		int j = i / 4 + rand.nextInt(2);

		if (j > 1 && rand.nextInt(60) == 0)
		{
			y += 10 + rand.nextInt(30);
		}
		int n;
		int i1;

		for (int k = 0; k < i; k++)
		{
			float f1 = (1.0F - k / i) * j;
			n = MathHelper.ceiling_float_int(f1);

			for (i1 = -n; i1 <= n; i1++)
			{
				float f2 = MathHelper.abs_int(i1) - 0.25F;

				for (int i3 = -n; i3 <= n; i3++)
				{
					float f3 = MathHelper.abs_int(i3) - 0.25F;

					if (i1 == 0 && i3 == 0 || f2 * f2 + f3 * f3 <= f1 * f1)
					{
						if (i1 != -n && i1 != n && i3 != -n && i3 != n || rand.nextFloat() <= 0.75F)
						{
							Block localBlock2 = world.getBlock(x + i1, y + k, z + i3);

							if (localBlock2.getMaterial() == Material.air || localBlock2 == CallistoBlocks.callistoBasicBlock && world.getBlockMetadata(x + i1, y + k, z + i3) == 0)
							{
								this.func_150515_a(world, x + i1, y + k, z + i3, CallistoBlocks.callistoBasicBlock);
							}
							if (k != 0 && n > 1)
							{
								localBlock2 = world.getBlock(x + i1, y - k, z + i3);

								if (localBlock2.getMaterial() == Material.air || localBlock2 == CallistoBlocks.callistoBasicBlock && world.getBlockMetadata(x + i1, y + k, z + i3) == 0)
								{
									this.func_150515_a(world, x + i1, y - k, z + i3, CallistoBlocks.callistoBasicBlock);
								}
							}
						}
					}
				}
			}
		}
		int k = j - 1;

		if (k < 0)
		{
			k = 0;
		}
		else if (k > 1)
		{
			k = 1;
		}

		for (int m = -k; m <= k; m++)
		{
			for (n = -k; n <= k; n++)
			{
				i1 = y - 1;
				int i2 = 50;

				if (Math.abs(m) == 1 && Math.abs(n) == 1)
				{
					i2 = rand.nextInt(5);
				}
				while (i1 > 50)
				{
					Block localBlock1 = world.getBlock(x + m, i1, z + n);

					if (localBlock1.getMaterial() != Material.air && localBlock1 != CallistoBlocks.callistoBasicBlock && world.getBlockMetadata(x + m, i1, z + n) == 0)
					{
						break;
					}

					this.func_150515_a(world, x + m, i1, z + n, CallistoBlocks.callistoBasicBlock);
					i1--;
					i2--;

					if (i2 <= 0)
					{
						i1 -= rand.nextInt(5) + 1;
						i2 = rand.nextInt(5);
					}
				}
			}
		}
		return true;
	}
}