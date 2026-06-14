package net.marioio.marioios_industrial_blocks.block.custom;

import net.marioio.marioios_industrial_blocks.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class IndustrialLever extends LeverBlock {
    private static final VoxelShape SHAPE_FLOOR_NORTH = Block.box(4, 0, 3, 12, 4, 13);
    private static final VoxelShape SHAPE_FLOOR_WEST = Block.box(3, 0, 4, 13, 4, 12);
    private static final VoxelShape SHAPE_CEILING_NORTH = Block.box(4, 12, 3, 12, 16, 13);
    private static final VoxelShape SHAPE_CEILING_WEST = Block.box(3, 12, 4, 13, 16, 12);
    private static final VoxelShape NORTH_SHAPE = Block.box(4, 3, 12, 12, 13, 16);
    private static final VoxelShape SOUTH_SHAPE = Block.box(4, 3, 0, 12, 13, 4);
    private static final VoxelShape WEST_SHAPE  = Block.box(12, 3, 4, 16, 13, 12);
    private static final VoxelShape EAST_SHAPE  = Block.box(0, 3, 4, 4, 13, 12);
    public IndustrialLever(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public BlockState pull(BlockState pState, Level pLevel, BlockPos pPos) {
        pLevel.playSeededSound(null, pPos.getX(), pPos.getY(), pPos.getZ(),
                ModSounds.INDUSTRIAL_LEVER_USE.get(), SoundSource.BLOCKS, 1f, 1f, 1);
        return super.pull(pState, pLevel, pPos);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        AttachFace face = state.getValue(FACE);
        Direction dir = state.getValue(FACING);
        switch (face) {
            case FLOOR:
                if (dir == Direction.NORTH || dir == Direction.SOUTH) {
                    return SHAPE_FLOOR_NORTH;
                }
                return SHAPE_FLOOR_WEST;
            case CEILING:
                if (dir == Direction.NORTH || dir == Direction.SOUTH) {
                    return SHAPE_CEILING_NORTH;
                }
                return SHAPE_CEILING_WEST;

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
