package com.tartaric_acid.baka943;

import com.tartaric_acid.baka943.block.BlockLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsBaka943 extends CreativeTabs
{
    public CreativeTabsBaka943()
    {
        super("baka943");
    }

    @Override
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(BlockLoader.invisibleLight);
    }
}
