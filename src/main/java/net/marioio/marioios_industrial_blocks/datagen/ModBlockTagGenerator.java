package net.marioio.marioios_industrial_blocks.datagen;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.marioio.marioios_industrial_blocks.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MarioiosIndustrialBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //this.tag(ModTags.Blocks.EXAMPLE)
        //        .add(ModBlocks.EXAMPLE_BLOCK.get(), otro bloque).addTag(Tags.Blocks.ORES);
        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.STEEL_PLATE_BLOCK.get())
                .add(ModBlocks.STEEL_STAIRS.get())
                .add(ModBlocks.STEEL_SLAB.get())
                .add(ModBlocks.STEEL_WALL.get())
                .add(ModBlocks.STEEL_FENCE.get())
                .add(ModBlocks.STEEL_BUTTON.get())
                .add(ModBlocks.STEEL_PRESSURE_PLATE.get())
                .add(ModBlocks.STEEL_PLATE_STAIRS.get())
                .add(ModBlocks.STEEL_PLATE_SLAB.get())
                .add(ModBlocks.STEEL_PLATE_WALL.get())
                .add(ModBlocks.STEEL_PLATE_FENCE.get())
                .add(ModBlocks.STEEL_PLATE_BUTTON.get())
                .add(ModBlocks.STEEL_PLATE_PRESSURE_PLATE.get())
                .add(ModBlocks.CHISELED_STEEL_BLOCK.get())
                .add(ModBlocks.STEEL_PILLAR.get())
                .add(ModBlocks.CHAIN_WIRE_FENCE.get())
                .add(ModBlocks.BARBED_WIRE.get())
                .add(ModBlocks.CHIMNEY_BLOCK.get())
                //.add(ModBlocks.CHIMNEY_WALL.get())
                .add(ModBlocks.STEEL_DOOR.get())
                .add(ModBlocks.STEEL_TRAPDOOR.get())
                .add(ModBlocks.VENTILATION_GRILLE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL);

        /*this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.EXAMPLE_BLOCK.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.EXAMPLE_BLOCK.get());*/

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LIGHTBULB.get())
                .add(ModBlocks.REDSTONE_LIGHTBULB.get())
                .add(ModBlocks.NIXIE_TUBE.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.STEEL_PLATE_BLOCK.get())
                .add(ModBlocks.DANGER_LINES_BLOCK.get())
                .add(ModBlocks.STEEL_STAIRS.get())
                .add(ModBlocks.STEEL_SLAB.get())
                .add(ModBlocks.STEEL_WALL.get())
                .add(ModBlocks.STEEL_FENCE.get())
                .add(ModBlocks.STEEL_BUTTON.get())
                .add(ModBlocks.STEEL_PRESSURE_PLATE.get())
                .add(ModBlocks.STEEL_PLATE_STAIRS.get())
                .add(ModBlocks.STEEL_PLATE_SLAB.get())
                .add(ModBlocks.STEEL_PLATE_WALL.get())
                .add(ModBlocks.STEEL_PLATE_FENCE.get())
                .add(ModBlocks.STEEL_PLATE_BUTTON.get())
                .add(ModBlocks.STEEL_PLATE_PRESSURE_PLATE.get())
                .add(ModBlocks.CHISELED_STEEL_BLOCK.get())
                .add(ModBlocks.STEEL_PILLAR.get())
                .add(ModBlocks.CHAIN_WIRE_FENCE.get())
                .add(ModBlocks.BARBED_WIRE.get())
                .add(ModBlocks.CHIMNEY_BLOCK.get())
                //.add(ModBlocks.CHIMNEY_WALL.get())
                .add(ModBlocks.MONITOR_BLOCK.get())
                .add(ModBlocks.MONITOR_BLOCK_EYE.get())
                .add(ModBlocks.MONITOR_BLOCK_BLUESCREEN.get())
                .add(ModBlocks.MONITOR_BLOCK_NOSIGNAL.get())
                .add(ModBlocks.MONITOR_BLOCK_MOJANG.get())
                .add(ModBlocks.MONITOR_BLOCK_COMMAND.get())
                .add(ModBlocks.MONITOR_BLOCK_SOUND.get())
                .add(ModBlocks.MONITOR_BLOCK_MATRIX.get())
                .add(ModBlocks.MONITOR_BLOCK_DESKTOP.get())
                .add(ModBlocks.MONITOR_BLOCK_TARGET.get())
                .add(ModBlocks.SERVER_RACK.get())
                .add(ModBlocks.CRANK.get())
                .add(ModBlocks.STEEL_DOOR.get())
                .add(ModBlocks.STEEL_TRAPDOOR.get())
                .add(ModBlocks.VENTILATION_GRILLE.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.WIRE_BLOCK.get())
                .add(ModBlocks.WIRE_BUNDLE.get())
                .add(ModBlocks.WIRE_CARPET.get())
                .add(ModBlocks.CARDBOARD_BOX.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.WARPED_EXIT_DOOR.get())
                .add(ModBlocks.CRIMSON_EXIT_DOOR.get())
                .add(ModBlocks.PALLET.get());

        // Para que se conecten
        this.tag(BlockTags.FENCES)
                .add(ModBlocks.STEEL_FENCE.get())
                .add(ModBlocks.STEEL_PLATE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES);
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.STEEL_WALL.get())
                .add(ModBlocks.STEEL_PLATE_WALL.get());
                //.add(ModBlocks.CHIMNEY_WALL.get());
    }
}
