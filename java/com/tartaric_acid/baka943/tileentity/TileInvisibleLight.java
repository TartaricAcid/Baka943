package com.tartaric_acid.baka943.tileentity;

import com.tartaric_acid.baka943.block.InvisibleLight;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileInvisibleLight extends TileEntity implements ITickable {

	@Override
	public void update() {
		if (worldObj.isRemote) {
			IBlockState state = worldObj.getBlockState(pos);
			InvisibleLight invisibleLight = (InvisibleLight) state.getBlock();
			invisibleLight.updateBlockState(state, worldObj, pos);
		}
	}

}
