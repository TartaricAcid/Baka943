package com.tartaric_acid.baka943.tileentity;

import com.tartaric_acid.baka943.Baka943;
import com.tartaric_acid.baka943.ConfigLoader;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityLoader {

    public TileEntityLoader()
    {
    	if (ConfigLoader.useTileEntityToTickInvisibleLight)
    		registerTileEntity(TileInvisibleLight.class, "invisible_light");
    }

    public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id)
    {
        GameRegistry.registerTileEntity(tileEntityClass, Baka943.MODID + ":" + id);
    }
    
}
