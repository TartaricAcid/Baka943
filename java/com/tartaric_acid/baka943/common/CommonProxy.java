package com.tartaric_acid.baka943.common;

import com.tartaric_acid.baka943.CraftingLoader;
import com.tartaric_acid.baka943.CreativeTabsLoader;
import com.tartaric_acid.baka943.block.BlockLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
    	new CreativeTabsLoader(event);    	
        new BlockLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
    	new CraftingLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
    }    
    
}
