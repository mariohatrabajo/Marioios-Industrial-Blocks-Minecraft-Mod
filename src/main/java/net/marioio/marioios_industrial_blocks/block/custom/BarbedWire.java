package net.marioio.marioios_industrial_blocks.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BarbedWire extends DirectionalBlock{
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 13, 14);
    public BarbedWire(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!(entity instanceof LivingEntity)) return;

        // Slow Down
        entity.makeStuckInBlock(state, new Vec3(0.5D, 0.75D, 0.5D));

        if (entity instanceof Player player && player.getAbilities().instabuild) return;

        if (!level.isClientSide) {
            boolean isMoving = entity.xOld != entity.getX() || entity.zOld != entity.getZ();
            if (isMoving && entity.tickCount % 10 == 0) {
                entity.hurt(level.damageSources().cactus(), 4.0F);

                level.playSound(
                        null,
                        pos,
                        SoundEvents.PLAYER_HURT_SWEET_BERRY_BUSH,
                        SoundSource.BLOCKS,
                        1.0F,
                        1.0F
                );
            }
        }
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        if (player.getMainHandItem().getItem() instanceof ShearsItem) {
            return 4.0F;
        }
        return super.getDestroyProgress(state, player, level, pos);
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }
}
