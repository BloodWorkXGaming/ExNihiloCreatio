package exnihilocreatio.blocks;

import exnihilocreatio.ExNihiloCreatio;
import exnihilocreatio.tiles.TileStoneAxle;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockStoneAxle extends BlockBase implements ITileEntityProvider {
    public static final IProperty<Boolean> IS_AXLE = PropertyBool.create("is_axle");
    private static final AxisAlignedBB hitboxEW = new AxisAlignedBB(0,0,0, 1, .5, .5).offset(0, 0.25, 0.25);
    private static final AxisAlignedBB hitboxSN = new AxisAlignedBB(0,0,0, .5, .5, 1).offset(0.25, 0.25, 0);


    public BlockStoneAxle() {
        super(Material.WOOD, "block_axle_stone");
        setCreativeTab(ExNihiloCreatio.tabExNihilo);

        setDefaultState(blockState.getBaseState().withProperty(IS_AXLE, false));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileStoneAxle();
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(IS_AXLE, false);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, IS_AXLE);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    private TileStoneAxle getTe(IBlockAccess world, BlockPos pos){
        return (TileStoneAxle) world.getTileEntity(pos);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        TileStoneAxle te = getTe(worldIn, pos);
        te.facing = placer.getHorizontalFacing();
    }

    @Override
    public boolean isFullBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isNormalCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
        TileEntity te = worldIn.getTileEntity(pos);
        if (te != null && te instanceof TileStoneAxle) {
            switch (((TileStoneAxle) te).facing){

                case DOWN:
                case UP:
                case NORTH:
                case SOUTH:
                    return hitboxSN;
                case WEST:
                case EAST:
                    return hitboxEW;
            }
        }
        return FULL_BLOCK_AABB;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        TileEntity te = source.getTileEntity(pos);
        if (te != null && te instanceof TileStoneAxle) {
            switch (((TileStoneAxle) te).facing){

                case DOWN:
                case UP:
                case NORTH:
                case SOUTH:
                    return hitboxSN;
                case WEST:
                case EAST:
                    return hitboxEW;
            }
        }
        return FULL_BLOCK_AABB;
    }
}
