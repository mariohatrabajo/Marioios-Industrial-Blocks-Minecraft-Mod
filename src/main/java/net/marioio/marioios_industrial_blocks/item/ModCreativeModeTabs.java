package net.marioio.marioios_industrial_blocks.item;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.marioio.marioios_industrial_blocks.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MarioiosIndustrialBlocks.MOD_ID);

    // ADD CREATIVE TABS
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("marioios_industrial_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.MONITOR_BLOCK_NOSIGNAL.get()))
                    .title(Component.translatable("creativetab.marioios_industrial_blocks_tab"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        // ADD ITEMS TO THE TAB
                        // Steel
                        output.accept(ModBlocks.STEEL_BLOCK.get());
                        output.accept(ModBlocks.STEEL_STAIRS.get());
                        output.accept(ModBlocks.STEEL_SLAB.get());
                        output.accept(ModBlocks.STEEL_WALL.get());
                        output.accept(ModBlocks.STEEL_FENCE.get());
                        output.accept(ModBlocks.STEEL_BUTTON.get());
                        output.accept(ModBlocks.STEEL_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.STEEL_PLATE_BLOCK.get());
                        output.accept(ModBlocks.STEEL_PLATE_STAIRS.get());
                        output.accept(ModBlocks.STEEL_PLATE_SLAB.get());
                        output.accept(ModBlocks.STEEL_PLATE_WALL.get());
                        output.accept(ModBlocks.STEEL_PLATE_FENCE.get());
                        output.accept(ModBlocks.STEEL_PLATE_BUTTON.get());
                        output.accept(ModBlocks.STEEL_PLATE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.CHISELED_STEEL_BLOCK.get());
                        output.accept(ModBlocks.STEEL_PILLAR.get());
                        output.accept(ModBlocks.STEEL_DOOR.get());
                        output.accept(ModBlocks.STEEL_TRAPDOOR.get());
                        output.accept(ModBlocks.VENTILATION_GRILLE.get());
                        output.accept(ModBlocks.CHIMNEY_BLOCK.get());
                        //output.accept(ModBlocks.CHIMNEY_WALL.get());
                        output.accept(ModBlocks.CHAIN_WIRE_FENCE.get());
                        output.accept(ModBlocks.BARBED_WIRE.get());
                        // Informatica
                        output.accept(ModBlocks.WIRE_BLOCK.get());
                        output.accept(ModBlocks.WIRE_BUNDLE.get());
                        output.accept(ModBlocks.WIRE_CARPET.get());
                        output.accept(ModBlocks.MONITOR_BLOCK.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_EYE.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_BLUESCREEN.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_NOSIGNAL.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_MOJANG.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_COMMAND.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_SOUND.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_MATRIX.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_DESKTOP.get());
                        output.accept(ModBlocks.MONITOR_BLOCK_TARGET.get());
                        output.accept(ModBlocks.SERVER_RACK.get());
                        // Redstone
                        output.accept(ModBlocks.BIG_RED_BUTTON.get());
                        output.accept(ModBlocks.BIG_DANGER_BUTTON.get());
                        output.accept(ModBlocks.INDUSTRIAL_LEVER.get());
                        output.accept(ModBlocks.CRANK.get());
                        output.accept(ModBlocks.LIGHTBULB.get());
                        output.accept(ModBlocks.REDSTONE_LIGHTBULB.get());
                        output.accept(ModBlocks.NIXIE_TUBE.get());

                        output.accept(ModBlocks.DANGER_LINES_BLOCK.get());
                        output.accept(ModBlocks.WARPED_EXIT_DOOR.get());
                        output.accept(ModBlocks.CRIMSON_EXIT_DOOR.get());
                        output.accept(ModBlocks.PALLET.get());
                        output.accept(ModBlocks.CARDBOARD_BOX.get());
                    }))
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
