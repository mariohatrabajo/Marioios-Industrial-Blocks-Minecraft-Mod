package net.marioio.marioios_industrial_blocks.block;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.marioio.marioios_industrial_blocks.block.custom.*;
import net.marioio.marioios_industrial_blocks.block.custom.DirectionalBlock;
import net.marioio.marioios_industrial_blocks.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MarioiosIndustrialBlocks.MOD_ID);

    // ADD BLOCKS
    public static final RegistryObject<Block> REDSTONE_LIGHTBULB = registerBlock("redstone_lightbulb",
            () -> new RedstoneLightbulb(BlockBehaviour.Properties.copy(Blocks.TORCH).noCollission().noOcclusion().sound(SoundType.LANTERN)
                    .lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 15 : 0)));
    public static final RegistryObject<Block> NIXIE_TUBE = registerBlock("nixie_tube",
            () -> new NixieTube(BlockBehaviour.Properties.copy(Blocks.TORCH).noCollission().noOcclusion().sound(SoundType.LANTERN)
                    .lightLevel(state -> state.getValue(BlockStateProperties.LIT) ? 15 : 0)));
    public static final RegistryObject<Block> LIGHTBULB = registerBlock("lightbulb",
            () -> new Lightbulb(BlockBehaviour.Properties.copy(Blocks.TORCH).noCollission().noOcclusion().sound(SoundType.LANTERN)));
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_STAIRS = registerBlock("steel_stairs",
            () -> new StairBlock(() -> ModBlocks.STEEL_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_SLAB = registerBlock("steel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_WALL = registerBlock("steel_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_FENCE = registerBlock("steel_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_BUTTON = registerBlock("steel_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 2, false));
    public static final RegistryObject<Block> STEEL_PRESSURE_PLATE = registerBlock("steel_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> STEEL_PLATE_BLOCK = registerBlock("steel_plate_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_PLATE_STAIRS = registerBlock("steel_plate_stairs",
            () -> new StairBlock(() -> ModBlocks.STEEL_PLATE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_PLATE_SLAB = registerBlock("steel_plate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_PLATE_WALL = registerBlock("steel_plate_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_PLATE_FENCE = registerBlock("steel_plate_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_PLATE_BUTTON = registerBlock("steel_plate_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 2, false));
    public static final RegistryObject<Block> STEEL_PLATE_PRESSURE_PLATE = registerBlock("steel_plate_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> CHISELED_STEEL_BLOCK = registerBlock("chiseled_steel_block",
            () -> new DirectionalBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> STEEL_PILLAR = registerBlock("steel_pillar",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> DANGER_LINES_BLOCK = registerBlock("danger_lines_block",
            () -> new DirectionalBlock(BlockBehaviour.Properties.copy(Blocks.YELLOW_GLAZED_TERRACOTTA)));
    public static final RegistryObject<Block> WIRE_BLOCK = registerBlock("wire_block",
            () -> new WireBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL)));
    public static final RegistryObject<Block> WIRE_BUNDLE = registerBlock("wire_bundle",
            () -> new WireBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_WOOL)));
    public static final RegistryObject<Block> WIRE_CARPET = registerBlock("wire_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.copy(Blocks.BLACK_CARPET)));
    public static final RegistryObject<Block> CHAIN_WIRE_FENCE = registerBlock("chain_wire_fence",
            () -> new IronBarsBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BARS).sound(SoundType.CHAIN)));
    public static final RegistryObject<Block> BARBED_WIRE = registerBlock("barbed_wire",
            () -> new BarbedWire(BlockBehaviour.Properties.copy(Blocks.CHAIN).noOcclusion().noCollission()));
    public static final RegistryObject<Block> CHIMNEY_BLOCK = registerBlock("chimney_block",
            () -> new ChimneyBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    //public static final RegistryObject<Block> CHIMNEY_WALL = registerBlock("chimney_wall",
    //        () -> new ChimneyWall(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> MONITOR_BLOCK = registerBlock("monitor_block",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_EYE = registerBlock("monitor_block_eye",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_BLUESCREEN = registerBlock("monitor_block_bluescreen",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_NOSIGNAL = registerBlock("monitor_block_nosignal",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_MOJANG = registerBlock("monitor_block_mojang",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_COMMAND = registerBlock("monitor_block_command",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_SOUND = registerBlock("monitor_block_sound",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_MATRIX = registerBlock("monitor_block_matrix",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_DESKTOP = registerBlock("monitor_block_desktop",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> MONITOR_BLOCK_TARGET = registerBlock("monitor_block_target",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .lightLevel(state -> state.getValue(MonitorBlock.ON) ? 10 : 0).noOcclusion()));
    public static final RegistryObject<Block> BIG_RED_BUTTON = registerBlock("big_red_button",
            () -> new BigRedButton(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 40, false));
    public static final RegistryObject<Block> BIG_DANGER_BUTTON = registerBlock("big_danger_button",
            () -> new BigRedButton(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
                    BlockSetType.IRON, 40, false));
    public static final RegistryObject<Block> INDUSTRIAL_LEVER = registerBlock("industrial_lever",
            () -> new IndustrialLever(BlockBehaviour.Properties.copy(Blocks.LEVER)));
    public static final RegistryObject<Block> CRANK = registerBlock("crank",
            () -> new CrankBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion().noCollission()));
    public static final RegistryObject<Block> STEEL_DOOR = registerBlock("steel_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> STEEL_TRAPDOOR = registerBlock("steel_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> WARPED_EXIT_DOOR = registerBlock("warped_exit_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> CRIMSON_EXIT_DOOR = registerBlock("crimson_exit_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> PALLET = registerBlock("pallet",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).noOcclusion()));
    public static final RegistryObject<Block> CARDBOARD_BOX = registerBlock("cardboard_box",
            () -> new BoxBlock(BlockBehaviour.Properties.copy(Blocks.ORANGE_WOOL).noOcclusion()));
    public static final RegistryObject<Block> VENTILATION_GRILLE = registerBlock("ventilation_grille",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> SERVER_RACK = registerBlock("server_rack",
            () -> new MonitorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    // Registra el bloque
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Registra el item del bloque
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
