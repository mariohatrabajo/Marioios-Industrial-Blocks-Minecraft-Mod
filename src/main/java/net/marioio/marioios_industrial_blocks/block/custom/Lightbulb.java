package net.marioio.marioios_industrial_blocks.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Lightbulb extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<AttachFace> FACE = BlockStateProperties.ATTACH_FACE;

    private static final VoxelShape SHAPE_FLOOR = Block.box(4, 0, 4, 12, 13, 12);

    private static final VoxelShape SHAPE_CEILING = Block.box(4, 3, 4, 12, 16, 12);
    private static final VoxelShape NORTH_SHAPE = Block.box(4, 4, 3, 12, 12, 16);
    private static final VoxelShape SOUTH_SHAPE = Block.box(4, 4, 0, 12, 12, 13);
    private static final VoxelShape WEST_SHAPE  = Block.box(3, 4, 4, 16, 12, 12);
    private static final VoxelShape EAST_SHAPE  = Block.box(0, 4, 4, 13, 12, 12);


    public Lightbulb(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACE, AttachFace.WALL)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction face = ctx.getClickedFace();

        BlockState state;
        if (face == Direction.DOWN)
            state = defaultBlockState().setValue(FACE, AttachFace.CEILING).setValue(FACING, ctx.getHorizontalDirection());
        else if (face == Direction.UP)
            state = defaultBlockState().setValue(FACE, AttachFace.FLOOR).setValue(FACING, ctx.getHorizontalDirection().getOpposite());
        else
            state = defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, face);

        return state;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACE, FACING);
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {

        AttachFace face = state.getValue(FACE);
        Direction dir = state.getValue(FACING);

        switch (face) {
            case FLOOR:
                return SHAPE_FLOOR;

            case CEILING:
                return SHAPE_CEILING;

            case WALL:
            default:
                switch (dir) {
                    case NORTH:
                        return NORTH_SHAPE;
                    case SOUTH:
                        return SOUTH_SHAPE;
                    case WEST:
                        return WEST_SHAPE;
                    case EAST:
                    default:
                        return EAST_SHAPE;
                }
        }
    }

}
