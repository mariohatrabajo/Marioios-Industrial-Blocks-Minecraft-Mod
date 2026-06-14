package net.marioio.marioios_industrial_blocks.block.custom;

import net.marioio.marioios_industrial_blocks.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CrankBlock extends LeverBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<AttachFace> FACE = BlockStateProperties.ATTACH_FACE;

    private static final VoxelShape SHAPE_FLOOR = Block.box(2, 0, 2, 14, 3, 14);
    private static final VoxelShape SHAPE_CEILING = Block.box(2, 13, 2, 14, 16, 14);
    private static final VoxelShape NORTH_SHAPE = Block.box(2, 2, 13, 14, 14, 16);
    private static final VoxelShape SOUTH_SHAPE = Block.box(2, 2, 0, 14, 14, 3);
    private static final VoxelShape WEST_SHAPE  = Block.box(13, 2, 2, 16, 14, 14);
    private static final VoxelShape EAST_SHAPE  = Block.box(0, 2, 2, 3, 14, 14);
    public static final BooleanProperty POWERED = BooleanProperty.create("powered");
    public CrankBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(POWERED, false)
                .setValue(FACE, AttachFace.WALL)
                .setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockState pull(BlockState pState, Level pLevel, BlockPos pPos) {
        pLevel.playSeededSound(null, pPos.getX(), pPos.getY(), pPos.getZ(),
                ModSounds.CRANK_USE.get(), SoundSource.BLOCKS, 1f, 1f, 1);
        return super.pull(pState, pLevel, pPos);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(POWERED, FACE, FACING);
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
