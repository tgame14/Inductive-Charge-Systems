package com.tgame.inductivecharge.blocks;

import com.tgame.mods.libs.registry.BlockData;
import com.tgame.mods.prefabs.blocks.TGBlockTile;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author tgame14
 * @since 11/09/2014
 */
@BlockData(tileClass = TileMagneticField.class)
public class BlockMagneticField extends TGBlockTile
{

	public BlockMagneticField ()
	{
		super (Material.iron);

		this.setStepSound(soundTypeMetal);
		this.setBlockName(this.getClass().getSimpleName());
		this.setHardness(5.5F);
		this.setResistance(7.5F);

	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileMagneticField();
	}
}
