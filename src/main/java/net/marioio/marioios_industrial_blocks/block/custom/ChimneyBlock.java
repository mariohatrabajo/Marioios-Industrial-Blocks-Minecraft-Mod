package net.marioio.marioios_industrial_blocks.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ChimneyBlock extends Block {
    public ChimneyBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);

        for(int i = 0; i < 4; i++) {
            pLevel.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                    pPos.getX() + 0.5, pPos.getY() + 1 + pRandom.nextDouble() * 0.2, pPos.getZ() + 0.5,
                    pRandom.nextDouble() * 0.03 + 0.02,
                    0.05,
                    pRandom.nextDouble() * 0.03 + 0.02);
        }
    }
}
