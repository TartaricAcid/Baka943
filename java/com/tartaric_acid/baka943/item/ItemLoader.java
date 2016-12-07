package com.tartaric_acid.baka943.item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLoader
{
    public static Item infiniteHoeInactive = new InfiniteHoeInactive();
    public static Item infiniteHoeActive = new InfiniteHoeActive();
    public static Item itemHuaJi = new ItemHuaJi();

    public ItemLoader(FMLPreInitializationEvent event)
    {
        register(infiniteHoeInactive, "infinite_hoe_inactive");
        register(infiniteHoeActive, "infinite_hoe_active");
        register(itemHuaJi, "item_hua_ji");
    }

    private static void register(Item item, String name)
    {
        GameRegistry.registerItem(item, name);
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(infiniteHoeInactive);
        registerRender(infiniteHoeActive);
        registerRender(itemHuaJi);
    }    

    @SideOnly(Side.CLIENT)
    private static void registerRender(Item item)
    {
        String name = GameData.getItemRegistry().getNameForObject(item).toString();
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(name, "inventory"));
    }
}

