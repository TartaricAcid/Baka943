package com.tartaric_acid.baka943.common;

import com.tartaric_acid.baka943.ConfigLoader;
import com.tartaric_acid.baka943.CraftingLoader;
import com.tartaric_acid.baka943.CreativeTabsLoader;
import com.tartaric_acid.baka943.block.BlockLoader;
import com.tartaric_acid.baka943.item.ItemLoader;
import com.tartaric_acid.baka943.tileentity.TileEntityLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        new ConfigLoader(event);
        new CreativeTabsLoader(event);        
        new BlockLoader(event);
        new ItemLoader(event);
        new TileEntityLoader();
    }

    public void init(FMLInitializationEvent event)
    {
        new CraftingLoader();
        new EventLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    }    
    
}
