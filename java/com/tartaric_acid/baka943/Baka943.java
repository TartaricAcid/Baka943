package com.tartaric_acid.baka943;

import com.tartaric_acid.baka943.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Baka943.MODID, name = Baka943.NAME, version = Baka943.VERSION, acceptedMinecraftVersions = "[1.9,)")
public class Baka943
{
    public static final String MODID = "baka943";
    public static final String NAME = "Baka943";
    public static final String VERSION = "1.0.3";

    @Instance(Baka943.MODID)
    public static Baka943 instance;

    @SidedProxy(clientSide = "com.tartaric_acid.baka943.client.ClientProxy", serverSide = "com.tartaric_acid.baka943.common.CommonProxy")
    public static CommonProxy proxy;  
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
