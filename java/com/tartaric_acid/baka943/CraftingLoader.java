package com.tartaric_acid.baka943;

import com.tartaric_acid.baka943.block.BlockLoader;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class CraftingLoader
{
    public CraftingLoader()
    {
        registerRecipe();
    }

    private static void registerRecipe()
    {      	    	    	
    	//Recipe For Guide Block
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blockGuide), new Object[]
    	        {
    	                "###", "#*#", "###", '#', Items.IRON_INGOT, '*', Blocks.WOOL
    	        });
    	//Recipe For Invisible Light
    	GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.invisibleLight), new Object[]
    	        {
    	                "##", '#', Blocks.TORCH
    	        });
    	GameRegistry.addShapelessRecipe(new ItemStack(Blocks.TORCH, 2), BlockLoader.invisibleLight);
    }
}
        
