package com.tartaric_acid.baka943.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.tartaric_acid.baka943.Baka943;
import com.tartaric_acid.baka943.CreativeTabsLoader;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InvisibleLight extends Block {	
	
	private boolean isVisible = false;
	
	public InvisibleLight()
	{
		super(Material.GLASS);
        this.setUnlocalizedName("invisibleLight");
        this.setHardness(0.1F);
        this.setSoundType(SoundType.GLASS);
        this.setResistance(20);
        this.setCreativeTab(CreativeTabsLoader.tabBaka943); 
        this.setLightLevel(1.0F);
        this.translucent = true;
    }
	
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }
	
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public float getAmbientOcclusionLightValue(IBlockState state)
    {
        return 1.0F;
    }
	
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
	public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
	
	public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid)
    {		
		ItemStack mainhand = FMLClientHandler.instance().getClient().thePlayer.getHeldItemMainhand();
		this.isVisible = false;
		
		if (mainhand != null) {
	        Item item = mainhand.getItem();
	        if (((item instanceof ItemBlock))&&(Block.getBlockFromItem(item) == BlockLoader.invisibleLight)) {
	          this.isVisible = true;
	        }
		}
	        
	    if (this.isVisible) {	            
	    	return true;
	    } else {
	        return false;
	    }		
    }
 
		
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {
		int meta = stack.getMetadata();	
		tooltip.add(I18n.format("baka943.tip.block.invisible_light", meta));
    }
		
}
