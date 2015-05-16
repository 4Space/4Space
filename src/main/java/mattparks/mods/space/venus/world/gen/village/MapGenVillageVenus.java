package mattparks.mods.space.venus.world.gen.village;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import mattparks.mods.space.venus.world.gen.BiomeGenBaseVenus;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureStart;

public class MapGenVillageVenus extends MapGenStructure {
	public static List<BiomeGenBase> villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { BiomeGenBaseVenus.venus });
	private final int terrainType;
	private static boolean initialized;

	static {
		try {
			MapGenVillageVenus.initiateStructures();
		} catch (Throwable e) {
		}
	}

	public static void initiateStructures() throws Throwable {
		if (!MapGenVillageVenus.initialized) {
			MapGenStructureIO.registerStructure(StructureVillageStartVenus.class, "VenusVillage");
			MapGenStructureIO.func_143031_a(StructureComponentVenusVillageField.class, "VenusField1");
			MapGenStructureIO.func_143031_a(StructureComponentVenusVillageField2.class, "VenusField2");
			MapGenStructureIO.func_143031_a(StructureComponentVenusVillageHouse.class, "VenusHouse");
			MapGenStructureIO.func_143031_a(StructureComponentVenusVillageRoadPiece.class, "VenusRoadPiece");
			MapGenStructureIO.func_143031_a(StructureComponentVenusVillagePathGen.class, "VenusPath");
			MapGenStructureIO.func_143031_a(StructureComponentVenusVillageTorch.class, "VenusTorch");
			MapGenStructureIO.func_143031_a(StructureComponentVenusVillageStartPiece.class, "VenusWell");
			MapGenStructureIO.func_143031_a(StructureComponentVenusVillageWoodHut.class, "VenusWoodHut");
		}
		MapGenVillageVenus.initialized = true;
	}

	public MapGenVillageVenus() {
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
		return new StructureVillageStartVenus(this.worldObj, this.rand, par1, par2, this.terrainType);
	}

	@Override
	public String func_143025_a() {
		return "VenusVillage";
	}
}
