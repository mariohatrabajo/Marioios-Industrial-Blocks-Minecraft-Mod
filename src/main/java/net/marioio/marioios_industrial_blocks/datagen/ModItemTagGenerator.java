package net.marioio.marioios_industrial_blocks.datagen;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.marioio.marioios_industrial_blocks.block.ModBlocks;
import net.marioio.marioios_industrial_blocks.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, MarioiosIndustrialBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Items.WIRE_BLOCKS)
                .add(Item.byBlock(ModBlocks.WIRE_BLOCK.get()))
                .add(Item.byBlock(ModBlocks.WIRE_BUNDLE.get()));
        this.tag(ModTags.Items.MONITOR_BLOCKS)
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_EYE.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_BLUESCREEN.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_NOSIGNAL.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_MOJANG.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_COMMAND.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_SOUND.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_MATRIX.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_DESKTOP.get()))
                .add(Item.byBlock(ModBlocks.MONITOR_BLOCK_TARGET.get()));
    }
}
