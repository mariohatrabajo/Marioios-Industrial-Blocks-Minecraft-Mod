package net.marioio.marioios_industrial_blocks.util;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks{
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> WIRE_BLOCKS = tag("wire_blocks");
        public static final TagKey<Item> MONITOR_BLOCKS = tag("monitor_blocks");
        public static final TagKey<Item> DYES = tag("dyes");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, name));
        }
    }
}
