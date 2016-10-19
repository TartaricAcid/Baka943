package com.tartaric_acid.baka943.item;

import java.util.List;

import com.tartaric_acid.baka943.CreativeTabsLoader;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InfiniteHoeInactive extends Item
{
    public InfiniteHoeInactive()
    {
        super();
        this.setUnlocalizedName("infiniteHoeInactive");
        this.setCreativeTab(CreativeTabsLoader.tabBaka943); 
        this.maxStackSize = 1;
    }
    
    @Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
		int meta = stack.getMetadata();	
		tooltip.add(I18n.format("baka943.tip.item.infinite_hoe_inactive", meta));
    }
}
