package mattparks.mods.exoplanets.elipse.world.gen.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureVillagePiecesElipse {
	public static ArrayList<StructureVillagePieceWeightElipse> getStructureVillageWeightedPieceList(Random par0Random, int par1) {
		final ArrayList<StructureVillagePieceWeightElipse> var2 = new ArrayList<StructureVillagePieceWeightElipse>();
		var2.add(new StructureVillagePieceWeightElipse(StructureComponentElipseVillageWoodHut.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 5 + par1 * 3)));
		var2.add(new StructureVillagePieceWeightElipse(StructureComponentElipseVillageField.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 3 + par1, 5 + par1)));
		var2.add(new StructureVillagePieceWeightElipse(StructureComponentElipseVillageHouse.class, 5, MathHelper.getRandomIntegerInRange(par0Random, 3 + par1, 4 + par1 * 2)));

		final Iterator<StructureVillagePieceWeightElipse> var3 = var2.iterator();

		while (var3.hasNext()) {
			if (var3.next().villagePiecesLimit == 0) {
				var3.remove();
			}
		}

		return var2;
	}

	private static int func_75079_a(List<StructureVillagePieceWeightElipse> par0List) {
		boolean var1 = false;
		int var2 = 0;
		StructureVillagePieceWeightElipse var4;

		for (final Iterator<StructureVillagePieceWeightElipse> var3 = par0List.iterator(); var3.hasNext(); var2 += var4.villagePieceWeight) {
			var4 = var3.next();

			if (var4.villagePiecesLimit > 0 && var4.villagePiecesSpawned < var4.villagePiecesLimit) {
				var1 = true;
			}
		}

		return var1 ? var2 : -1;
	}

	private static StructureComponentElipseVillage func_75083_a(StructureComponentElipseVillageStartPiece par0ComponentVillageStartPiece, StructureVillagePieceWeightElipse par1StructureVillagePieceWeight, List<StructureComponent> par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8) {
		final Class<?> var9 = par1StructureVillagePieceWeight.villagePieceClass;
		Object var10 = null;

		if (var9 == StructureComponentElipseVillageWoodHut.class) {
			var10 = StructureComponentElipseVillageWoodHut.func_74908_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
		} else if (var9 == StructureComponentElipseVillageField.class) {
			var10 = StructureComponentElipseVillageField.func_74900_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
		} else if (var9 == StructureComponentElipseVillageHouse.class) {
			var10 = StructureComponentElipseVillageHouse.func_74921_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
		}

		return (StructureComponentElipseVillage) var10;
	}

	private static StructureComponentElipseVillage getNextVillageComponent(StructureComponentElipseVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		final int var8 = StructureVillagePiecesElipse.func_75079_a(par0ComponentVillageStartPiece.structureVillageWeightedPieceList);

		if (var8 <= 0) {
			return null;
		} else {
			int var9 = 0;

			while (var9 < 5) {
				++var9;
				int var10 = par2Random.nextInt(var8);
				final Iterator<StructureVillagePieceWeightElipse> var11 = par0ComponentVillageStartPiece.structureVillageWeightedPieceList.iterator();

				while (var11.hasNext()) {
					final StructureVillagePieceWeightElipse var12 = var11.next();
					var10 -= var12.villagePieceWeight;

					if (var10 < 0) {
						if (!var12.canSpawnMoreVillagePiecesOfType(par7) || var12 == par0ComponentVillageStartPiece.structVillagePieceWeight && par0ComponentVillageStartPiece.structureVillageWeightedPieceList.size() > 1) {
							break;
						}

						final StructureComponentElipseVillage var13 = StructureVillagePiecesElipse.func_75083_a(par0ComponentVillageStartPiece, var12, par1List, par2Random, par3, par4, par5, par6, par7);

						if (var13 != null) {
							++var12.villagePiecesSpawned;
							par0ComponentVillageStartPiece.structVillagePieceWeight = var12;

							if (!var12.canSpawnMoreVillagePieces()) {
								par0ComponentVillageStartPiece.structureVillageWeightedPieceList.remove(var12);
							}

							return var13;
						}
					}
				}
			}

			final StructureBoundingBox var14 = StructureComponentElipseVillageTorch.func_74904_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

			if (var14 != null) {
				return new StructureComponentElipseVillageTorch(par0ComponentVillageStartPiece, par7, par2Random, var14, par6);
			} else {
				return null;
			}
		}
	}

	/**
	 * attempts to find a next Structure Component to be spawned, private
	 * Village function
	 */
	private static StructureComponent getNextVillageStructureComponent(StructureComponentElipseVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		if (par7 > 50) {
			return null;
		} else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112) {
			final StructureComponentElipseVillage var8 = StructureVillagePiecesElipse.getNextVillageComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

			if (var8 != null) {
				par1List.add(var8);
				par0ComponentVillageStartPiece.field_74932_i.add(var8);
				return var8;
			}

			return null;
		} else {
			return null;
		}
	}

	private static StructureComponent getNextComponentVillagePath(StructureComponentElipseVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		if (par7 > 3 + par0ComponentVillageStartPiece.terrainType) {
			return null;
		} else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112) {
			final StructureBoundingBox var8 = StructureComponentElipseVillagePathGen.func_74933_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

			if (var8 != null && var8.minY > 10) {
				final StructureComponentElipseVillagePathGen var9 = new StructureComponentElipseVillagePathGen(par0ComponentVillageStartPiece, par7, par2Random, var8, par6);

				par1List.add(var9);
				par0ComponentVillageStartPiece.field_74930_j.add(var9);
				return var9;
			}

			return null;
		} else {
			return null;
		}
	}

	/**
	 * attempts to find a next Structure Component to be spawned
	 */
	static StructureComponent getNextStructureComponent(StructureComponentElipseVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		return StructureVillagePiecesElipse.getNextVillageStructureComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
	}

	static StructureComponent getNextStructureComponentVillagePath(StructureComponentElipseVillageStartPiece par0ComponentVillageStartPiece, List<StructureComponent> par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7) {
		return StructureVillagePiecesElipse.getNextComponentVillagePath(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
	}
}
