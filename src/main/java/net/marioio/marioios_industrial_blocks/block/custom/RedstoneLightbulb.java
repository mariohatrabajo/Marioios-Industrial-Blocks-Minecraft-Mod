package net.marioio.marioios_industrial_blocks.block.custom;

import net.marioio.marioios_industrial_blocks.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RedstoneLightbulb extends Lightbulb {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;


    public RedstoneLightbulb(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACE, AttachFace.WALL)
                .setValue(FACING, Direction.NORTH)
                .setValue(LIT, false));
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            boolean powered = level.hasNeighborSignal(pos);
            if (powered != state.getValue(LIT)) {
                level.setBlock(pos, state.setValue(LIT, powered), 3);
            }
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        boolean powered = ctx.getLevel().hasNeighborSignal(ctx.getClickedPos());
        Direction face = ctx.getClickedFace();

        BlockState state;
        if (face == Direction.DOWN)
            state = defaultBlockState().setValue(FACE, AttachFace.CEILING).setValue(FACING, ctx.getHorizontalDirection());
        else if (face == Direction.UP)
            state = defaultBlockState().setValue(FACE, AttachFace.FLOOR).setValue(FACING, ctx.getHorizontalDirection().getOpposite());
        else
            state = defaultBlockState().setValue(FACE, AttachFace.WALL).setValue(FACING, face);

        return state.setValue(LIT, powered);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACE, FACING, LIT);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {}
}
