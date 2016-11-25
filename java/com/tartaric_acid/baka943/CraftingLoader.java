package com.tartaric_acid.baka943;

import java.util.ArrayList;
import java.util.List;

import com.tartaric_acid.baka943.block.BlockLoader;
import com.tartaric_acid.baka943.item.ItemLoader;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lib.LibOreDict;

public class CraftingLoader
{
    public static List<RecipeManaInfusion> woodRecipes;
    
    public CraftingLoader()
    {
        registerRecipe();
    }

    private static void registerRecipe()
    {      
        
        //Recipe For Guide Block
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.blockGuide), new Object[]
                {
                        "###", "#*#", "###",
                        '#', Items.IRON_INGOT,
                        '*', Blocks.WOOL
                });
        
        //Recipe For Invisible Light
        GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.invisibleLight), new Object[]
                {
                        "##",
                        '#', Blocks.TORCH
                });
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.TORCH, 2), BlockLoader.invisibleLight);
        
        
        //Recipe For Infinite Hoe Inactive        
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ItemLoader.infiniteHoeInactive), new Object[]
                {
                        "## ", " * ", " * ",
                        '#', "ingotTerrasteel",
                        '*', Items.STICK
                }));       
                
        
        woodRecipes = new ArrayList<RecipeManaInfusion>();
        woodRecipes.add(BotaniaAPI.registerManaAlchemyRecipe(new ItemStack(BlockLoader.invisibleLight, 1), new ItemStack(Blocks.TORCH, 1), 300));
        woodRecipes.add(BotaniaAPI.registerManaAlchemyRecipe(new ItemStack(ItemLoader.infiniteHoeActive, 1), new ItemStack(ItemLoader.infiniteHoeInactive, 1), 1000000));
    }
}

