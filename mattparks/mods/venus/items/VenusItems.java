package mattparks.mods.venus.items;

import mattparks.mods.venus.GCVenus;
import mattparks.mods.venus.GCVenusConfigManager;
import net.minecraft.block.Block;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class VenusItems
{
    public static Item venusItemBasic;
    public static Item vurnBerry;

    public static Item sulferPickaxe;
    public static Item sulferAxe;
    public static Item sulferHoe;
    public static Item sulferSpade;
    public static Item sulferSword;
    public static Item sulferHelmet;
    public static Item sulferChestplate;
    public static Item sulferLeggings;
    public static Item sulferBoots;
    
    public static Item jetpack;
    public static Item gemPickaxe;
    public static Item gemAxe;
    public static Item gemHoe;
    public static Item gemSpade;
    public static Item gemSword;
    public static Item gemHelmet;
    public static Item gemChestplate;
    public static Item gemLeggings;
    public static Item gemBoots;
    
    public static Item venusBattery;
    
    public static EnumArmorMaterial ARMORSULFER = EnumHelper.addArmorMaterial("SULFER", 42, new int[] { 4, 9, 7, 4 }, 12);
    public static EnumToolMaterial TOOLSULFER = EnumHelper.addToolMaterial("SULFER", 3, 1024, 5.0F, 2.5F, 8);
    
    public static EnumArmorMaterial ARMORGEM = EnumHelper.addArmorMaterial("GEM", 42, new int[] { 3, 3, 3, 3 }, 12);
    public static EnumToolMaterial TOOLGEM = EnumHelper.addToolMaterial("GEM", 3, 1024, 5.0F, 2.5F, 8);
    
    public static EnumArmorMaterial ARMORJETPACK = EnumHelper.addArmorMaterial("JETPACK", 42, new int[] { 4, 9, 7, 4 }, 12);
    
    public static void initItems()
    {
        VenusItems.venusItemBasic = new GCVenusItem(GCVenusConfigManager.idItemVenusBasic);
        VenusItems.vurnBerry = (new GCVenusVurnBerry(GCVenusConfigManager.idVurnBerry, 4, 0.6F, GCVenus.VurnBerryBush.blockID, Block.tilledField.blockID)).setUnlocalizedName("vurnBerry").setTextureName("galacticraftvenus:vurnBerry");
 
        VenusItems.sulferPickaxe = new GCVenusItemPickaxe(GCVenusConfigManager.idToolSulferPickaxe, VenusItems.TOOLSULFER).setUnlocalizedName("sulferPick");
        VenusItems.sulferAxe = new GCVenusItemAxe(GCVenusConfigManager.idToolSulferAxe, VenusItems.TOOLSULFER).setUnlocalizedName("sulferAxe");
        VenusItems.sulferHoe = new GCVenusItemHoe(GCVenusConfigManager.idToolSulferHoe, VenusItems.TOOLSULFER).setUnlocalizedName("sulferHoe");
        VenusItems.sulferSpade = new GCVenusItemSpade(GCVenusConfigManager.idToolSulferSpade, VenusItems.TOOLSULFER).setUnlocalizedName("sulferSpade");
        VenusItems.sulferSword = new GCVenusItemSword(GCVenusConfigManager.idToolSulferSword, VenusItems.TOOLSULFER).setUnlocalizedName("sulferSword");
        
        VenusItems.sulferHelmet = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferHelmet, VenusItems.ARMORSULFER, 7, 0, false).setUnlocalizedName("sulferHelmet");
        VenusItems.sulferChestplate = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferChestplate, VenusItems.ARMORSULFER, 7, 1, false).setUnlocalizedName("sulferChestplate");
        VenusItems.sulferLeggings = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferLeggings, VenusItems.ARMORSULFER, 7, 2, false).setUnlocalizedName("sulferLeggings");
        VenusItems.sulferBoots = new GCVenusItemSulferArmor(GCVenusConfigManager.idArmorSulferBoots, VenusItems.ARMORSULFER, 7, 3, false).setUnlocalizedName("sulferBoots");
    
        VenusItems.gemPickaxe = new GCVenusItemPickaxe(GCVenusConfigManager.idToolGemPickaxe, VenusItems.TOOLGEM).setUnlocalizedName("gemPick");
        VenusItems.gemAxe = new GCVenusItemAxe(GCVenusConfigManager.idToolGemAxe, VenusItems.TOOLGEM).setUnlocalizedName("gemAxe");
        VenusItems.gemHoe = new GCVenusItemHoe(GCVenusConfigManager.idToolGemHoe, VenusItems.TOOLGEM).setUnlocalizedName("gemHoe");
        VenusItems.gemSpade = new GCVenusItemSpade(GCVenusConfigManager.idToolGemSpade, VenusItems.TOOLGEM).setUnlocalizedName("gemSpade");
        VenusItems.gemSword = new GCVenusItemSword(GCVenusConfigManager.idToolGemSword, VenusItems.TOOLGEM).setUnlocalizedName("gemSword");

        VenusItems.gemHelmet = new GCVenusItemGemArmor(GCVenusConfigManager.idArmorGemHelmet, VenusItems.ARMORGEM, 7, 0, false).setUnlocalizedName("gemHelmet");
        VenusItems.gemChestplate = new GCVenusItemGemArmor(GCVenusConfigManager.idArmorGemChestplate, VenusItems.ARMORGEM, 7, 1, false).setUnlocalizedName("gemChestplate");
        VenusItems.gemLeggings = new GCVenusItemGemArmor(GCVenusConfigManager.idArmorGemLeggings, VenusItems.ARMORGEM, 7, 2, false).setUnlocalizedName("gemLeggings");
        VenusItems.gemBoots = new GCVenusItemGemArmor(GCVenusConfigManager.idArmorGemBoots, VenusItems.ARMORGEM, 7, 3, false).setUnlocalizedName("gemBoots");

        VenusItems.jetpack = new GCVenusItemJetpack(GCVenusConfigManager.idJetpack, VenusItems.ARMORJETPACK, 7, 1, false).setUnlocalizedName("jetpack");

        VenusItems.venusBattery = new GCVenusItemBattery(GCVenusConfigManager.idItemVenusBattery, "venusBattery");
    }
    
    public static void registerHarvestLevels()
    {

    }
}
