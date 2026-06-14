package net.marioio.marioios_industrial_blocks.block.custom;

import net.marioio.marioios_industrial_blocks.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BigRedButton extends ButtonBlock {
    private static final VoxelShape SHAPE_FLOOR = Block.box(4, 0, 4, 12, 3, 12);

    private static final VoxelShape SHAPE_CEILING = Block.box(4, 13, 4, 12, 16, 12);
    private static final VoxelShape NORTH_SHAPE = Block.box(4, 4, 13, 12, 12, 16);
    private static final VoxelShape SOUTH_SHAPE = Block.box(4, 4, 0, 12, 12, 3);
    private static final VoxelShape WEST_SHAPE  = Block.box(13, 4, 4, 16, 12, 12);
    private static final VoxelShape EAST_SHAPE  = Block.box(0, 4, 4, 3, 12, 12);
    public BigRedButton(Properties pProperties, BlockSetType pType, int pTicksToStayPressed, boolean pArrowsCanPress) {
        super(pProperties, pType, pTicksToStayPressed, pArrowsCanPress);
    }

    @Override
    public void press(BlockState pState, Level pLevel, BlockPos pPos) {
        pLevel.playSeededSound(null, pPos.getX(), pPos.getY(), pPos.getZ(),
                ModSounds.BIG_RED_BUTTON_USE.get(), SoundSource.BLOCKS, 1f, 1f, 1);
        super.press(pState, pLevel, pPos);
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
