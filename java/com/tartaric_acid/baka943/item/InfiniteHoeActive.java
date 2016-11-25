package com.tartaric_acid.baka943.item;

import java.util.List;

import com.tartaric_acid.baka943.CreativeTabsLoader;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InfiniteHoeActive extends ItemHoe
{
    public static final ToolMaterial InfiniteToolMaterial = EnumHelper.addToolMaterial("INFINITE", 2, 0, 3.0F, 2.0F, 14);
    
    public InfiniteHoeActive()
    {
        super(InfiniteToolMaterial);
        this.setUnlocalizedName("infiniteHoeActive");
        this.setCreativeTab(CreativeTabsLoader.tabBaka943); 
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
        int meta = stack.getMetadata();    
        tooltip.add(I18n.format("baka943.tip.item.infinite_hoe_active", meta));
    }  
}
