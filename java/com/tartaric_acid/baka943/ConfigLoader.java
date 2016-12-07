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
    public static boolean areYouHentai;
    public static double dropOrangeJuiceChance;
    
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
        String areYouHentaiDes = I18n.format("baka943.config.areYouHentai");
        String dropOrangeJuiceChanceDes = I18n.format("baka943.config.dropOrangeJuiceChance");
        
        useTileEntityToTickInvisibleLight = config.get(Configuration.CATEGORY_GENERAL, "useTileEntityToTickInvisibleLight", false, useTEToTickInvisbleLightDes).getBoolean();
        showNonTEInvisibleLight = config.get(Configuration.CATEGORY_GENERAL, "showAllInvisibleLight", false, showNonTEInvisbleLightDes).getBoolean();
        areYouHentai = config.get(Configuration.CATEGORY_GENERAL, "areYouHentai", true, areYouHentaiDes).getBoolean();
        dropOrangeJuiceChance = config.get(Configuration.CATEGORY_GENERAL, "dropOrangeJuiceChance", 0.1).getDouble();
        
        config.save();
        
        logger.info("Finished loading config.");
    }

    public static Logger logger()
    {
        return logger;
    }
}
