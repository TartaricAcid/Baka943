package com.tartaric_acid.baka943;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader {

    private static Configuration config;
    private static Logger logger;
    
    public static boolean useTileEntityToTickInvisibleLight;
    public static boolean showNonTEInvisibleLight;
    
    public ConfigLoader(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        load();
    }

    public static void load()
    {
        logger.info("Started loading config.");
        String useTEToTickInvisbleLightDes = "Whether using a TileEntity to help tick the invisible light. Set to true will enhance the performance of Invisible Light, but might cause a potential lag.";
        String showNonTEInvisbleLightDes = "Set to true will show the invisible light which doesn't have a TileEntity when the useTileEntityToTickInvisibleLight mode is on.";
        useTileEntityToTickInvisibleLight = config.get(Configuration.CATEGORY_GENERAL, "useTileEntityToTickInvisibleLight", true, useTEToTickInvisbleLightDes).getBoolean();
        showNonTEInvisibleLight = config.get(Configuration.CATEGORY_GENERAL, "showAllInvisibleLight", true, showNonTEInvisbleLightDes).getBoolean();
        config.save();
        logger.info("Finished loading config.");
    }

    public static Logger logger()
    {
        return logger;
    }
}
