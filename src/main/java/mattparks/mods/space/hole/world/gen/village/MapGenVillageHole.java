package mattparks.mods.space.hole.world.gen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import mattparks.mods.space.hole.world.gen.BiomeGenBaseHole;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;
import cpw.mods.fml.common.FMLLog;

public class MapGenVillageHole extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenBaseHole.hole });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageHole.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageHole.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartHole.class, "HoleVillage");
			MapGenStructureIO.func_143031_a(StructureComponentHoleVillageField.class, "HoleField1");
			MapGenStructureIO.func_143031_a(StructureComponentHoleVillageField2.class, "HoleField2");
			MapGenStructureIO.func_143031_a(StructureComponentHoleVillageHouse.class, "HoleHouse");
			MapGenStructureIO.func_143031_a(StructureComponentHoleVillageRoadPiece.class, "HoleRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentHoleVillagePathGen.class, "HolePath");
			MapGenStructureIO.func_143031_a(StructureComponentHoleVillageTorch.class, "HoleTorch");
			MapGenStructureIO.func_143031_a(StructureComponentHoleVillageStartPiece.class, "HoleWell");
			MapGenStructureIO.func_143031_a(StructureComponentHoleVillageWoodHut.class, "HoleWoodHut");
		}
		MapGenVillageHole.initialized = true;
	}

	public MapGenVillageHole() {
		this.terrainType = 0;
	}

	@Override
	protected boolean canSpawnStructureAtCoords(int i, int j) {
		final byte numChunks = 32;
		final byte offsetChunks = 8;
		final int oldi = i;
		final int oldj = j;

		if (i < 0) {
			i -= numChunks - 1;
		}

		if (j < 0) {
			j -= numChunks - 1;
		}

		int randX = i / numChunks;
		int randZ = j / numChunks;
		final Random var7 = this.worldObj.setRandomSeed(i, j, 10387312);
		randX *= numChunks;
		randZ *= numChunks;
		randX += var7.nextInt(numChunks - offsetChunks);
		randZ += var7.nextInt(numChunks - offsetChunks);
		return oldi == randX && oldj == randZ;
	}

	@Override
	protected StructureStart getStructureStart(int par1, int par2) {
		return new StructureVillageStartHole(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "HoleVillage";
	}
}
