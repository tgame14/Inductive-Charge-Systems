package com.tgame.inductivecharge;

import net.minecraft.creativetab.CreativeTabs;
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
        return InductiveChargeSystems.blockChargePlatform.getItem();
    }
}
