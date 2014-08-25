package com.tgame.inductivecharge.blocks;

import com.tgame.inductivecharge.ICSCreativeTab;
import com.tgame.mods.libs.registry.BlockData;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @since 10/05/14
 * @author tgame14
 */
@BlockData(tileClass = { TileCreativeGenerator.class} )
public class BlockCreativeGenerator extends BlockContainer
{
    public BlockCreativeGenerator ()
    {
        super(Material.sponge);
        this.setCreativeTab(ICSCreativeTab.INSTANCE);
        this.setBlockName("creativepowerGenerator");
    }

    @Override
    public TileEntity createNewTileEntity (World var1, int var2)
    {
        return new TileCreativeGenerator();
    }
}
