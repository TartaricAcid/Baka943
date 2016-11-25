package com.tartaric_acid.baka943.block;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.tartaric_acid.baka943.Baka943;
import com.tartaric_acid.baka943.ConfigLoader;
import com.tartaric_acid.baka943.CreativeTabsLoader;
import com.tartaric_acid.baka943.tileentity.TileInvisibleLight;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class InvisibleLight extends Block {    
    
    private static final PropertyBool VISIBLE = PropertyBool.create("visible");
    
    public InvisibleLight() {
        super(Material.CLOTH);
        this.setUnlocalizedName("invisibleLight");
        this.setHardness(0.1F);
        this.setSoundType(SoundType.CLOTH);
        this.setResistance(20);
        this.setCreativeTab(CreativeTabsLoader.tabBaka943); 
        this.setLightLevel(1.0F);
    }    
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return state.getValue(VISIBLE)? EnumBlockRenderType.MODEL: EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }    
    
    @Override
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (!ConfigLoader.useTileEntityToTickInvisibleLight || ConfigLoader.showNonTEInvisibleLight)
            updateBlockState(stateIn, worldIn, pos);
    }        
    
    public void updateBlockState(IBlockState stateIn, World worldIn, BlockPos pos) {
        ItemStack mainhand = FMLClientHandler.instance().getClient().thePlayer.getHeldItemMainhand();

        if (mainhand != null) {
            Item item = mainhand.getItem();
            if (((item instanceof ItemBlock))&&(Block.getBlockFromItem(item) == BlockLoader.invisibleLight)) {
              worldIn.setBlockState(pos, stateIn.withProperty(VISIBLE, true)); 
              return;
            }
        }
                
        worldIn.setBlockState(pos, stateIn.withProperty(VISIBLE, false));
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return ConfigLoader.useTileEntityToTickInvisibleLight;
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return ConfigLoader.useTileEntityToTickInvisibleLight? new TileInvisibleLight(): super.createTileEntity(world, state);
    }
    
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, World worldIn, BlockPos pos) {
        return NULL_AABB;
    }
    
    @Override
    public boolean canCollideCheck(IBlockState state, boolean hitIfLiquid) {
        return state.getValue(VISIBLE);
    }
    
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return true;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
        int meta = stack.getMetadata();    
        tooltip.add(I18n.format("baka943.tip.block.invisible_light", meta));
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(VISIBLE, meta != 0);
    }
    
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(VISIBLE)? 1: 0;
    }
        
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, VISIBLE);
    }

}
