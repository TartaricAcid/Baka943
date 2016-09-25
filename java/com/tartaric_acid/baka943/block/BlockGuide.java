package com.tartaric_acid.baka943.block;

import com.tartaric_acid.baka943.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockGuide extends Block {
	public BlockGuide()
	{
		super(Material.IRON);
        this.setUnlocalizedName("blockGuide");
        this.setHardness(2.0F);
        this.setHarvestLevel("pickaxe", 1);
        this.setSoundType(SoundType.METAL);
        this.setResistance(20);
        this.setCreativeTab(CreativeTabsLoader.tabBaka943);
	}
}