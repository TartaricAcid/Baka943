package com.tartaric_acid.baka943;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTabsLoader
{
    public static CreativeTabs tabBaka943;

    public CreativeTabsLoader(FMLPreInitializationEvent event)
    {
        tabBaka943 = new CreativeTabsBaka943();
    }
}
