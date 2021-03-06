package com.tgame.inductivecharge;

import com.tgame.inductivecharge.blocks.BlockChargePlatform;
import com.tgame.inductivecharge.blocks.BlockCreativeGenerator;
import com.tgame.mods.config.ConfigHandler;
import com.tgame.mods.libs.registry.IItemDefinition;
import com.tgame.mods.libs.registry.RegistryHandler;
import com.tgame.mods.libs.utility.Mods;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * @author tgame14
 * @since 29/04/14
 */
@Mod(modid = Settings.ID, name = Settings.NAME, version = Settings.VERSION, dependencies = "after:" + Mods.TE3 + ";required-after:tgamecore" /*+ ";required-after" + Mods.COFH*/)
@SuppressWarnings("unused")
public class InductiveChargeSystems
{
    @Mod.Instance(Settings.ID)
    public static InductiveChargeSystems instance;

    @SidedProxy(clientSide = "com.tgame.inductivecharge.ClientProxy", serverSide = "com.tgame.inductivecharge.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Metadata
    public static ModMetadata metadata;

    public static ItemStack wrench;
	public static ItemStack multimeter;

    public static IItemDefinition blockChargePlatform;

    private RegistryHandler registry;

    public InductiveChargeSystems()
    {
        this.registry = new RegistryHandler();
    }


    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event)
    {
        Settings.CONFIGURATION = new Configuration(event.getSuggestedConfigurationFile());

        blockChargePlatform = registry.registerBlock(new BlockChargePlatform(), BlockChargePlatform.class);
		registry.registerBlock(new BlockCreativeGenerator(), BlockCreativeGenerator.class);
        proxy.preInit();

    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event)
    {
        metadata.authorList.add("@AUTHOR@");
        metadata.credits = "@AUTHOR@, https://github.com/tgame14/Advanced-Fluxian-Tools/blob/master/CREDITS.md";
        metadata.description = "A Mod that adds Advanced tools and machinery";
        metadata.modId = Settings.ID;
        metadata.version = Settings.VERSION;
        metadata.name = Settings.NAME;

        metadata.autogenerated = false;

        proxy.init();
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event)
    {
        // RECIPES
        if (Loader.isModLoaded(Mods.TE3) && false)
        {
            wrench = GameRegistry.findItemStack(Mods.TE3, "wrench", 1);
			multimeter = GameRegistry.findItemStack(Mods.TE3, "multimeter", 1);

            ItemStack leadConduit = GameRegistry.findItemStack(Mods.TE3, "conduitEnergyBasic", 1);
            ItemStack leadEnergy = GameRegistry.findItemStack(Mods.TE3, "cellBasic", 1);

            ItemStack hardenedConduit = GameRegistry.findItemStack(Mods.TE3, "conduitEnergyHardened", 1);
            ItemStack hardenedEnergy = GameRegistry.findItemStack(Mods.TE3, "cellHardened", 1);

            ItemStack redsConduit = GameRegistry.findItemStack(Mods.TE3, "conduitEnergyReinforced", 1);
            ItemStack redsEnergy = GameRegistry.findItemStack(Mods.TE3, "cellReinforced", 1);

            ItemStack gearElectrum = GameRegistry.findItemStack(Mods.TE3, "gearElectrum", 1);
            ItemStack hardenedCapacitor = GameRegistry.findItemStack(Mods.TE3, "capacitorHardened", 1);

            ItemStack ppIron = new ItemStack(GameData.getBlockRegistry().getObject("light_weighted_pressure_plate"));

            GameRegistry.addRecipe(new ShapedOreRecipe(blockChargePlatform.getItemStack(1, 0), "CPC", "PEP", "CPC", 'C', leadConduit, 'P', ppIron, 'E', leadEnergy));
            GameRegistry.addRecipe(new ShapedOreRecipe(blockChargePlatform.getItemStack(1, 1), "CPC", "PEP", "CPC", 'C', hardenedConduit, 'P', ppIron, 'E', hardenedEnergy));
            GameRegistry.addRecipe(new ShapedOreRecipe(blockChargePlatform.getItemStack(1, 2), "CPC", "PEP", "CPC", 'C', redsConduit, 'P', ppIron, 'E', redsEnergy));

        }
        else
        {
			wrench = new ItemStack(Items.golden_hoe);
			multimeter = new ItemStack(Items.compass);

            ItemStack quartz = new ItemStack(Blocks.quartz_block);
            ItemStack redTorch = new ItemStack(Blocks.redstone_torch);
            ItemStack ppIron = new ItemStack(Blocks.heavy_weighted_pressure_plate);
            ItemStack ppGold = new ItemStack(Blocks.light_weighted_pressure_plate);
            ItemStack soulSand = new ItemStack(Blocks.soul_sand);
            ItemStack ironBlock = new ItemStack(Blocks.iron_block);
            ItemStack anvil = new ItemStack(Blocks.anvil);
            ItemStack enderEye = new ItemStack(Items.ender_eye);
            ItemStack emerald = new ItemStack(Items.emerald);

            GameRegistry.addRecipe(new ShapedOreRecipe(blockChargePlatform.getItemStack(1, 0), "CPC", "PEP", "CPC", 'C', redTorch, 'P', ppIron, 'E', soulSand));
            GameRegistry.addRecipe(new ShapedOreRecipe(blockChargePlatform.getItemStack(1, 1), "CPC", "PEP", "CPC", 'C', quartz, 'P', ppIron, 'E', soulSand));
            GameRegistry.addRecipe(new ShapedOreRecipe(blockChargePlatform.getItemStack(1, 2), "CPC", "PEP", "CPC", 'C', anvil, 'P', ppGold, 'E', enderEye));
        }

        ConfigHandler.configure(Settings.CONFIGURATION, Settings.DOMAIN);

        proxy.postInit();
    }

}
