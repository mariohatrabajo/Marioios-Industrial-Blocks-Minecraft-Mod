package net.marioio.marioios_industrial_blocks.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WireBlock extends RotatedPillarBlock {

    public WireBlock(Properties props) {
        super(props);
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        if (player.getMainHandItem().getItem() instanceof ShearsItem) {
            return 5.0F;
        }
        return super.getDestroyProgress(state, player, level, pos);
    }
}
