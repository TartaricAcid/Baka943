package com.tartaric_acid.baka943;

import org.apache.logging.log4j.Logger;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader {

    private static Configuration config;
    private static Logger logger;
    
    public static boolean useTileEntityToTickInvisibleLight;
    public static boolean showNonTEInvisibleLight;
    public static boolean youAreHentai;
    
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
        
        String useTEToTickInvisbleLightDes = I18n.format("baka943.config.useTEToTickInvisbleLightDes");
        String showNonTEInvisbleLightDes = I18n.format("baka943.config.showNonTEInvisbleLightDes");
        String areYouHentai = I18n.format("baka943.config.areYouHentai");
        
        useTileEntityToTickInvisibleLight = config.get(Configuration.CATEGORY_GENERAL, "useTileEntityToTickInvisibleLight", false, useTEToTickInvisbleLightDes).getBoolean();
        showNonTEInvisibleLight = config.get(Configuration.CATEGORY_GENERAL, "showAllInvisibleLight", false, showNonTEInvisbleLightDes).getBoolean();
        youAreHentai = config.get(Configuration.CATEGORY_GENERAL, "areYouHentai", true, areYouHentai).getBoolean();
        
        config.save();
        
        logger.info("Finished loading config.");
    }

    public static Logger logger()
    {
        return logger;
    }
}
