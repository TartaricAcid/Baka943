package com.tartaric_acid.baka943.common;

import com.pam.harvestcraft.item.ItemRegistry;
import com.tartaric_acid.baka943.ConfigLoader;

import net.blacklab.lmr.entity.EntityLittleMaid;
import net.blacklab.lmr.util.EnumSound;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteract;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventLoader {
	
    public EventLoader()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
        
    @SubscribeEvent
    public void interact(EntityInteract event) {
    	if (!(event.getTarget() instanceof EntityLittleMaid)) {
            return;
        }
    	
        EntityPlayer player = event.getEntityPlayer();   
        EntityLittleMaid maid = (EntityLittleMaid) event.getTarget();
        ItemStack itemstack = player.inventory.getCurrentItem();
                        
        if (itemstack != null && player.isSneaking() && !event.getWorld().isRemote ) {        	
            Item item = itemstack.getItem();            
            if (ConfigLoader.youAreHentai == true && item == ItemRegistry.juicerItem && maid.isContract() && (Math.random()<0.1) ) { 
                maid.dropItem(ItemRegistry.orangejuiceItem, 1);
                maid.playLittleMaidSound(EnumSound.laughter, false);
            }
        }
    }        
}
