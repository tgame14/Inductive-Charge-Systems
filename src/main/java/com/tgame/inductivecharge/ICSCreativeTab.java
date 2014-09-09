package com.tgame.inductivecharge;

import com.tgame.mods.libs.utility.Mods;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * @author tgame14
 * @since 29/04/14
 */
public class ICSCreativeTab extends CreativeTabs
{

	public static final ICSCreativeTab INSTANCE = new ICSCreativeTab();

	private ICSCreativeTab()
	{
		super(CreativeTabs.getNextID(), "AFT");
	}

    @Override
    public Item getTabIconItem ()
    {
        if (Loader.isModLoaded(Mods.TE3))
		{
			GameRegistry.findItemStack(Mods.TE3, "cellReinforced", 1);
		}
		return Items.quartz;
	}
}
