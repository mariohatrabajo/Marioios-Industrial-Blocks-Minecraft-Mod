package net.marioio.marioios_industrial_blocks.block.entity;

import net.marioio.marioios_industrial_blocks.block.custom.BoxBlock;
import net.marioio.marioios_industrial_blocks.screen.BoxMenu;
import net.marioio.marioios_industrial_blocks.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;

public class BoxBlockEntity extends RandomizableContainerBlockEntity implements MenuProvider {
    private NonNullList<ItemStack> items;
    private final ContainerOpenersCounter openersCounter;
    public BoxBlockEntity(BlockPos pPos, BlockState pState) {
        super(ModBlockEntities.BOX_BE.get(), pPos, pState);
        this.items = NonNullList.withSize(18, ItemStack.EMPTY);
        this.openersCounter = new ContainerOpenersCounter() {

            @Override
            protected void onOpen(Level level, BlockPos pos, BlockState state) {
                level.playSound(null, pos,
                        ModSounds.CARDBOARD_BOX_OPEN.get(),
                        SoundSource.BLOCKS, 1f, 1f);

                BoxBlockEntity.this.updateBlockState(true);
            }

            @Override
            protected void onClose(Level level, BlockPos pos, BlockState state) {
                level.playSound(null, pos,
                        ModSounds.CARDBOARD_BOX_CLOSE.get(),
                        SoundSource.BLOCKS, 1f, 1f);

                BoxBlockEntity.this.updateBlockState(false);
            }

            @Override
            protected void openerCountChanged(Level level, BlockPos pos, BlockState state, int oldCount, int newCount) {
                BoxBlockEntity.this.recheckOpen();
            }

            @Override
            protected boolean isOwnContainer(Player player) {
                return player.containerMenu instanceof BoxMenu menu
                        && menu.blockEntity == BoxBlockEntity.this;
            }
        };
    }

    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        if (!this.trySaveLootTable(pTag)) {
            ContainerHelper.saveAllItems(pTag, this.items);
        }
    }

    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.loadAllItems(pTag, this.items);
        }

    }

    public int getContainerSize() {
        return 18;
    }

    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    protected void setItems(NonNullList<ItemStack> pItems) {
        this.items = pItems;
    }

    protected Component getDefaultName() {
        return Component.translatable("container.marioios_industrial_blocks.cardboard_box");
    }

    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new BoxMenu(pContainerId, pPlayerInventory, this);
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return createMenu(i, inventory, inventory.player);
    }

    public void startOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.incrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    public void stopOpen(Player pPlayer) {
        if (!this.remove && !pPlayer.isSpectator()) {
            this.openersCounter.decrementOpeners(pPlayer, this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    public void recheckOpen() {
        if (!this.remove) {
            this.openersCounter.recheckOpeners(this.getLevel(), this.getBlockPos(), this.getBlockState());
        }

    }

    void updateBlockState(boolean open) {
        if (this.level == null) return;

        BlockState state = this.level.getBlockState(this.worldPosition);

        this.level.setBlock(this.worldPosition,
                state.setValue(BoxBlock.OPEN, open),
                3);
    }


    public void drops() {
        SimpleContainer inventory = new SimpleContainer(items.size());
        for(int i = 0; i < items.size(); i++) {
            inventory.setItem(i, items.get(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }
}
