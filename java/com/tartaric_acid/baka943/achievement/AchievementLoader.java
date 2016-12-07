package com.tartaric_acid.baka943.achievement;

import com.tartaric_acid.baka943.Baka943;
import com.tartaric_acid.baka943.item.ItemLoader;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class AchievementLoader
{
    public static Achievement kingOfHentai = new Achievement("baka943.achievement.kingOfHentai",
            "baka943.kingOfHentai", 0, 0, ItemLoader.itemHuaJi, null);
    
    public static AchievementPage pageBaka943 = new AchievementPage(Baka943.NAME, kingOfHentai);

    public AchievementLoader()
    {        
        kingOfHentai.initIndependentStat().setSpecial().registerStat();
        AchievementPage.registerAchievementPage(pageBaka943);
    }
}
