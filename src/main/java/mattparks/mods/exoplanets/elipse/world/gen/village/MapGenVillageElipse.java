package mattparks.mods.exoplanets.elipse.world.gen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import mattparks.mods.exoplanets.elipse.world.gen.BiomeGenBaseElipse;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenVillageElipse extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenBaseElipse.elipse });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageElipse.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageElipse.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartElipse.class, "HoleVillage");
			MapGenStructureIO.func_143031_a(StructureComponentElipseVillageField.class, "HoleField1");
			MapGenStructureIO.func_143031_a(StructureComponentElipseVillageField2.class, "HoleField2");
			MapGenStructureIO.func_143031_a(StructureComponentElipseVillageHouse.class, "HoleHouse");
			MapGenStructureIO.func_143031_a(StructureComponentElipseVillageRoadPiece.class, "HoleRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentElipseVillagePathGen.class, "HolePath");
			MapGenStructureIO.func_143031_a(StructureComponentElipseVillageTorch.class, "HoleTorch");
			MapGenStructureIO.func_143031_a(StructureComponentElipseVillageStartPiece.class, "HoleWell");
			MapGenStructureIO.func_143031_a(StructureComponentElipseVillageWoodHut.class, "HoleWoodHut");
		}
		MapGenVillageElipse.initialized = true;
	}

	public MapGenVillageElipse() {
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
		return new StructureVillageStartElipse(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "HoleVillage";
	}
}
