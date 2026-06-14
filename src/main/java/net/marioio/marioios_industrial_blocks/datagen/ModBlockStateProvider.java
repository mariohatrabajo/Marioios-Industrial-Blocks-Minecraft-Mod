package net.marioio.marioios_industrial_blocks.datagen;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.marioio.marioios_industrial_blocks.block.ModBlocks;
import net.marioio.marioios_industrial_blocks.block.custom.*;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.AttachFace;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MarioiosIndustrialBlocks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        nixieStates(ModBlocks.LIGHTBULB, "lightbulb");
        redstoneNixieStates(ModBlocks.REDSTONE_LIGHTBULB, "redstone_lightbulb");
        numberNixieStates(ModBlocks.NIXIE_TUBE, "nixie_tube");
        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.STEEL_PLATE_BLOCK);
        directionalBlock(ModBlocks.DANGER_LINES_BLOCK, "danger_lines_block");
        logBlockWithItem(ModBlocks.WIRE_BLOCK, "wire_block");
        woodBlockWithItem(ModBlocks.WIRE_BUNDLE, "wire_block");
        simpleBlock(ModBlocks.WIRE_CARPET.get(), models().carpet("wire_carpet", modLoc("block/wire_block")));
        invertedDirectionalBlock(ModBlocks.CHISELED_STEEL_BLOCK, "chiseled_steel_block");
        logBlockWithItem(ModBlocks.STEEL_PILLAR, "steel_pillar");
        paneBlockWithItem(ModBlocks.CHAIN_WIRE_FENCE, "chain_wire_fence");
        barbedWire(ModBlocks.BARBED_WIRE, "barbed_wire_item");
        blockWithItem(ModBlocks.CHIMNEY_BLOCK, models().cubeBottomTop(ModBlocks.CHIMNEY_BLOCK.getId().getPath(),
                        modLoc("block/chimney_block"),
                        modLoc("block/chimney_block_top"), modLoc("block/chimney_block_top")));
        //wallBlock((WallBlock) ModBlocks.CHIMNEY_WALL.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID,"block/chimney_block"));
        monitorBlock(ModBlocks.MONITOR_BLOCK, "monitor_block", "static");
        monitorBlock(ModBlocks.MONITOR_BLOCK_EYE, "monitor_block", "eye");
        monitorBlock(ModBlocks.MONITOR_BLOCK_BLUESCREEN, "monitor_block", "bluescreen");
        monitorBlock(ModBlocks.MONITOR_BLOCK_NOSIGNAL, "monitor_block", "nosignal");
        monitorBlock(ModBlocks.MONITOR_BLOCK_MOJANG, "monitor_block", "mojang");
        monitorBlock(ModBlocks.MONITOR_BLOCK_COMMAND, "monitor_block", "command");
        monitorBlock(ModBlocks.MONITOR_BLOCK_SOUND, "monitor_block", "sound");
        monitorBlock(ModBlocks.MONITOR_BLOCK_MATRIX, "monitor_block", "matrix");
        monitorBlock(ModBlocks.MONITOR_BLOCK_DESKTOP, "monitor_block", "desktop");
        monitorBlock(ModBlocks.MONITOR_BLOCK_TARGET, "monitor_block", "target");
        monitorBlock(ModBlocks.SERVER_RACK, "server_rack", "");
        crankBlock(ModBlocks.CRANK.get());
        boxBlockStates(ModBlocks.CARDBOARD_BOX, "cardboard_box");

        // Variants
        stairsBlock((StairBlock) ModBlocks.STEEL_STAIRS.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_block"));
        slabBlock((SlabBlock) ModBlocks.STEEL_SLAB.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_block"), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_block"));
        wallBlock((WallBlock) ModBlocks.STEEL_WALL.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID,"block/steel_block"));
        fenceBlock((FenceBlock) ModBlocks.STEEL_FENCE.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_block"));
        buttonBlock((ButtonBlock) ModBlocks.STEEL_BUTTON.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_block"));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.STEEL_PRESSURE_PLATE.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_block"));
        stairsBlock((StairBlock) ModBlocks.STEEL_PLATE_STAIRS.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_plate_block"));
        slabBlock((SlabBlock) ModBlocks.STEEL_PLATE_SLAB.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_plate_block"), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_plate_block"));
        wallBlock((WallBlock) ModBlocks.STEEL_PLATE_WALL.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID,"block/steel_plate_block"));
        fenceBlock((FenceBlock) ModBlocks.STEEL_PLATE_FENCE.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_plate_block"));
        buttonBlock((ButtonBlock) ModBlocks.STEEL_PLATE_BUTTON.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_plate_block"));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.STEEL_PLATE_PRESSURE_PLATE.get(), new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/steel_plate_block"));
        bigRedButton(ModBlocks.BIG_RED_BUTTON.get(), "big_red_button");
        bigRedButton(ModBlocks.BIG_DANGER_BUTTON.get(), "big_danger_button");
        industrialLever(ModBlocks.INDUSTRIAL_LEVER.get(), "industrial_lever");
        doorBlockWithRenderType(((DoorBlock) ModBlocks.STEEL_DOOR.get()), modLoc("block/steel_door_bottom"), modLoc("block/steel_door_top"), "cutout");
        doorBlockWithRenderType(((DoorBlock) ModBlocks.WARPED_EXIT_DOOR.get()), modLoc("block/warped_exit_door_bottom"), modLoc("block/warped_exit_door_top"), "cutout");
        doorBlockWithRenderType(((DoorBlock) ModBlocks.CRIMSON_EXIT_DOOR.get()), modLoc("block/crimson_exit_door_bottom"), modLoc("block/crimson_exit_door_top"), "cutout");
        slabWithTop(ModBlocks.PALLET,"pallet");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.STEEL_TRAPDOOR.get()), modLoc("block/steel_trapdoor"), true, "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.VENTILATION_GRILLE.get()), modLoc("block/ventilation_grille"), true, "cutout");
    }

    // Crea un bloque y su item
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject, ModelFile model){
        simpleBlockWithItem(blockRegistryObject.get(), model);
    }
    private void crossBlockWithItem(RegistryObject<Block> blockRegistryObject, String modelName, String textureName){
        simpleBlockWithItem(blockRegistryObject.get(),
                models().cross(modelName, new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/" + textureName)
                ).renderType("cutout"));
    }
    private void logBlockWithItem(RegistryObject<Block> block, String texture) {
        logBlock((RotatedPillarBlock) block.get());
        simpleBlockItem(block.get(), models().cubeColumn(
                block.getId().getPath() + "_item",
                modLoc("block/"+texture),
                modLoc("block/"+texture+"_top")
        ));
    }
    private void woodBlockWithItem(RegistryObject<Block> block, String texture) {
        axisBlock((RotatedPillarBlock) block.get(), blockTexture(ModBlocks.WIRE_BLOCK.get()), blockTexture(ModBlocks.WIRE_BLOCK.get()));
        simpleBlockItem(block.get(), models().cubeColumn(
                block.getId().getPath() + "_item",
                modLoc("block/"+texture),
                modLoc("block/"+texture)
        ));
    }
    private void paneBlockWithItem(RegistryObject<Block> block, String texture){
        paneBlock((IronBarsBlock) block.get(),
                modLoc("block/"+texture),
                modLoc("block/"+texture));
        simpleBlockItem(block.get(), models().withExistingParent(
                        block.getId().getPath(),
                        mcLoc("item/generated"))
                .texture("layer0", modLoc("block/" + texture))
        );
    }

    private void barbedWire(RegistryObject<Block> block, String itemTexture){
        horizontalBlock(ModBlocks.BARBED_WIRE.get(), new ModelFile.UncheckedModelFile(modLoc("block/barbed_wire")));
        simpleBlockItem(block.get(), models().withExistingParent(
                        block.getId().getPath()+"_item",
                        mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + itemTexture))
        );
    }

    private void directionalBlock(RegistryObject<Block> block, String texture){
        horizontalBlock(block.get(),
                models().cubeAll(texture,
                        modLoc("block/"+texture)));

        simpleBlockItem(block.get(), models().cubeAll(
                block.getId().getPath() + "_item",
                modLoc("block/"+texture)
        ));
    }
    private void boxBlockStates(RegistryObject<Block> block, String name){
        // Block Model
        ModelFile model_closed = models().withExistingParent(name, mcLoc("block/cube"))
                .texture("down", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_top"))
                .texture("up", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_top"))
                .texture("north", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_front"))
                .texture("south", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_front"))
                .texture("west", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_sides"))
                .texture("east", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_sides"))
                .texture("particle", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_front"));
        ModelFile model_open = models().withExistingParent(name+"_open", mcLoc("block/cube"))
                .texture("down", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_top"))
                .texture("up", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_top_open"))
                .texture("north", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_front"))
                .texture("south", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_front"))
                .texture("west", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_sides"))
                .texture("east", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_sides"))
                .texture("particle", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_front"));
        getVariantBuilder(block.get()).forAllStates(state -> {
            // Rotation
            Direction facing = state.getValue(BoxBlock.FACING);
            int yRot = switch (facing) {
                case SOUTH -> 180;
                case WEST -> 270;
                case EAST -> 90;
                default -> 0;
            };

            Boolean open = state.getValue(BoxBlock.OPEN);
            ModelFile model = (open)? model_open : model_closed;

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY(yRot).build();
        });
        // Item Model
        simpleBlockItem(block.get(), model_closed);
    }
    private void invertedDirectionalBlock(RegistryObject<Block> block, String texture){
        getVariantBuilder(block.get()).forAllStates(state -> {
            int yRot = ((int) state.getValue(HorizontalDirectionalBlock.FACING).toYRot()) % 360;

            return ConfiguredModel.builder()
                    .modelFile(models().cubeAll(texture, modLoc("block/" + texture)))
                    .rotationY(yRot)
                    .build();
        });

        simpleBlockItem(block.get(), models().cubeAll(
                block.getId().getPath() + "_item",
                modLoc("block/"+texture)
        ));
    }
    private void monitorBlock(RegistryObject<Block> block, String name, String variant){
        // Block Model
        getVariantBuilder(block.get()).forAllStates(state -> {
            boolean ON = state.getValue(MonitorBlock.ON);

            // Textures
            ModelFile model = models().withExistingParent(name+((ON)?"_on_"+variant:"_off"), mcLoc("block/cube"))
                    .texture("down", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_bottom"))
                    .texture("up", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_top"))
                    .texture("north", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_front"+((ON)?"_on_"+variant:"")))
                    .texture("south", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_back"))
                    .texture("west", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_west"))
                    .texture("east", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_east"))
                    .texture("particle", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_back"));

            // Rotation
            Direction facing = state.getValue(MonitorBlock.FACING);
            int yRot = switch (facing) {
                case SOUTH -> 180;
                case WEST -> 270;
                case EAST -> 90;
                default -> 0;
            };

            return ConfiguredModel.builder()
                    .modelFile(model)
                    .rotationY(yRot).build();
        });
        // Item Model
        ModelFile model = models().withExistingParent(name+variant, mcLoc("block/cube"))
                .texture("down", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_bottom"))
                .texture("up", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_top"))
                .texture("north", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_front_on_"+variant))
                .texture("south", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_back"))
                .texture("west", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_west"))
                .texture("east", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_east"))
                .texture("particle", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_back"));
        simpleBlockItem(block.get(), model);
    }

    private void nixieStates(RegistryObject<Block> block, String texture) {

        getVariantBuilder(block.get()).forAllStates(state -> {
            ModelFile floor = models().cross(texture + "_floor",
                    modLoc("block/" + texture)).renderType("cutout");
            ModelFile ceiling = models().cross(texture+"_ceiling",
                    modLoc("block/" + texture)).renderType("cutout");
            ModelFile wall = models().cross(texture+"_wall",
                    modLoc("block/" + texture)).renderType("cutout");
            return nixieTubeApplyModel(state, floor, ceiling, wall);
        });
    }

    private void redstoneNixieStates(RegistryObject<Block> block, String texture) {

        getVariantBuilder(block.get()).forAllStates(state -> {
            boolean LIT = state.getValue(RedstoneLightbulb.LIT);
            ModelFile floor, ceiling, wall;

            if (LIT) {
                floor = models().cross(texture + "_floor_on",
                        modLoc("block/" + texture+"_on")).renderType("cutout");
                ceiling = models().cross(texture+"_ceiling_on",
                        modLoc("block/" + texture+"_on")).renderType("cutout");
                wall = models().cross(texture+"_wall_on",
                        modLoc("block/" + texture+"_on")).renderType("cutout");
            } else {
                floor = models().cross(texture + "_floor",
                        modLoc("block/" + texture)).renderType("cutout");
                ceiling = models().cross(texture+"_ceiling",
                        modLoc("block/" + texture)).renderType("cutout");
                wall = models().cross(texture+"_wall",
                        modLoc("block/" + texture)).renderType("cutout");
            }
            return nixieTubeApplyModel(state, floor, ceiling, wall);
        });
    }

    private void numberNixieStates(RegistryObject<Block> block, String texture) {

        getVariantBuilder(block.get()).forAllStates(state -> {
            boolean LIT = state.getValue(NixieTube.LIT);
            int number = state.getValue(NixieTube.NUMBER);
            String textureName = texture + "_" + number;
            ModelFile floor, ceiling, wall;

            if (LIT) {
                floor = models().cross(textureName + "_floor_on",
                        modLoc("block/" + textureName+"_on")).renderType("cutout");
                ceiling = models().cross(textureName+"_ceiling_on",
                        modLoc("block/" + textureName+"_on")).renderType("cutout");
                wall = models().cross(textureName+"_wall_on",
                        modLoc("block/" + textureName+"_on")).renderType("cutout");
            } else {
                floor = models().cross(textureName + "_floor",
                        modLoc("block/" + textureName)).renderType("cutout");
                ceiling = models().cross(textureName+"_ceiling",
                        modLoc("block/" + textureName)).renderType("cutout");
                wall = models().cross(textureName+"_wall",
                        modLoc("block/" + textureName)).renderType("cutout");
            }
            return nixieTubeApplyModel(state, floor, ceiling, wall);
        });
    }

    public void bigRedButton(Block block, String name) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean powered = state.getValue(ButtonBlock.POWERED);
            ResourceLocation model = powered ? new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/big_red_button_parent_pressed"): new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/big_red_button_parent");

            int yRot = ((int) state.getValue(ButtonBlock.FACING).toYRot()) % 360;
            int xRot = switch (state.getValue(ButtonBlock.FACE)) {
                case FLOOR -> 0;
                case WALL -> -90;
                case CEILING -> 180;
            };
            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(name+((powered)? "pressed":""), model)
                            .texture("bottom", new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+name+"_bottom")))
                    .rotationX(xRot)
                    .rotationY(yRot)
                    .build();
        });
    }
    public void industrialLever(Block block, String name) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean powered = state.getValue(LeverBlock.POWERED);


            ResourceLocation model = powered ? new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/industrial_lever_parent_pressed"): new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/industrial_lever_parent");

            int yRot = ((int) state.getValue(LeverBlock.FACING).toYRot()) % 360;
            int xRot = switch (state.getValue(LeverBlock.FACE)) {
                case FLOOR -> 0;
                case WALL -> -90;
                case CEILING -> 180;
            };
            if (state.getValue(LeverBlock.FACE) != AttachFace.WALL) yRot = (yRot+180)%360;

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(name+((powered)? "pressed":""), model))
                    .rotationX(xRot)
                    .rotationY(yRot)
                    .build();
        });
    }
    public void crankBlock(Block block) {
        getVariantBuilder(block).forAllStates(state -> {
            boolean powered = state.getValue(CrankBlock.POWERED);

            int yRot = ((int) state.getValue(CrankBlock.FACING).toYRot()) % 360;
            int xRot = switch (state.getValue(CrankBlock.FACE)) {
                case FLOOR -> 0;
                case WALL -> -90;
                case CEILING -> 180;
            };

            String name = "crank"+((powered)?"_pressed":"");

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(name, new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/crank_parent"))
                            .texture("top", modLoc("block/"+name))
                            .renderType("cutout"))
                    .rotationX(xRot)
                    .rotationY(yRot)
                    .build();
        });
    }

    private static ConfiguredModel[] nixieTubeApplyModel(BlockState state, ModelFile floor, ModelFile ceiling, ModelFile wall){
        AttachFace face = state.getValue(NixieTube.FACE);
        Direction facing = state.getValue(NixieTube.FACING);
        int yRot = (int) facing.toYRot();
        // Piso
        if (face == AttachFace.FLOOR) {
            return ConfiguredModel.builder()
                    .modelFile(floor)
                    .rotationY(yRot)
                    .build();
        }
        // Techo
        if (face == AttachFace.CEILING) {
            return ConfiguredModel.builder()
                    .modelFile(ceiling)
                    .rotationX(180)
                    .rotationY(yRot)
                    .build();
        }
        // Pared
        return ConfiguredModel.builder()
                .modelFile(wall)
                .rotationX(-90)
                .rotationY(yRot)
                .build();
    }

    private void slabWithTop(RegistryObject<Block> block, String texture){
        slabBlock(
                (SlabBlock) block.get(),
                models().slab(texture,
                        modLoc("block/"+texture+"_side"),
                        modLoc("block/"+texture+"_top"),
                        modLoc("block/"+texture+"_top")
                ).renderType("cutout"),
                models().slabTop(texture+"_top",
                        modLoc("block/"+texture+"_side"),
                        modLoc("block/"+texture+"_top"),
                        modLoc("block/"+texture+"_top")
                ).renderType("cutout"),
                models().cubeBottomTop(texture+"_double",
                        modLoc("block/"+texture+"_side"),
                        modLoc("block/"+texture+"_top"),
                        modLoc("block/"+texture+"_top")
                ).renderType("cutout")
        );
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture){
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }
    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign){
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
}
