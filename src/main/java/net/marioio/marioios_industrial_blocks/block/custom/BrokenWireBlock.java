package net.marioio.marioios_industrial_blocks.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class BrokenWireBlock extends WireBlock{
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    public BrokenWireBlock(Properties props) {
        super(props);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(LIT, false));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(LIT);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (!level.isClientSide) {
            BlockState currentState = level.getBlockState(pos);
            if (currentState.getBlock() != this) return;
            boolean powered = level.hasNeighborSignal(pos);
            if (powered != currentState.getValue(LIT)) {
                level.setBlock(pos, currentState.setValue(LIT, powered), 3);
            }
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);

        if (pState.getValue(LIT) && pRandom.nextFloat() < 0.3F) {
            double x = pPos.getX() + pRandom.nextDouble();
            double y = pPos.getY();
            double z = pPos.getZ() + pRandom.nextDouble();

            for (int i = 0; i < 5; i++) {
                pLevel.addParticle(ParticleTypes.WAX_OFF,
                        x, y + pRandom.nextDouble() * -0.2, z,
                        pRandom.nextDouble() * 10 - 5,
                        -10 + pRandom.nextDouble() * 2,
                        pRandom.nextDouble() * 10 - 5);
            }
        }
    }
}
