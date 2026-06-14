package net.marioio.marioios_industrial_blocks.datagen;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.marioio.marioios_industrial_blocks.block.ModBlocks;
import net.marioio.marioios_industrial_blocks.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MarioiosIndustrialBlocks.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleBlockItem(ModBlocks.LIGHTBULB);
        simpleBlockItem(ModBlocks.REDSTONE_LIGHTBULB);
        simpleBlockItem(ModBlocks.NIXIE_TUBE);
        evenSimplerBlockItem(ModBlocks.STEEL_STAIRS);
        evenSimplerBlockItem(ModBlocks.STEEL_SLAB);
        wallItem(ModBlocks.STEEL_WALL, ModBlocks.STEEL_BLOCK);
        fenceItem(ModBlocks.STEEL_FENCE, ModBlocks.STEEL_BLOCK);
        buttonItem(ModBlocks.STEEL_BUTTON, ModBlocks.STEEL_BLOCK);
        evenSimplerBlockItem(ModBlocks.STEEL_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.STEEL_PLATE_STAIRS);
        evenSimplerBlockItem(ModBlocks.STEEL_PLATE_SLAB);
        wallItem(ModBlocks.STEEL_PLATE_WALL, ModBlocks.STEEL_PLATE_BLOCK);
        fenceItem(ModBlocks.STEEL_PLATE_FENCE, ModBlocks.STEEL_PLATE_BLOCK);
        buttonItem(ModBlocks.STEEL_PLATE_BUTTON, ModBlocks.STEEL_PLATE_BLOCK);
        evenSimplerBlockItem(ModBlocks.STEEL_PLATE_PRESSURE_PLATE);
        //wallItem(ModBlocks.CHIMNEY_WALL, ModBlocks.CHIMNEY_BLOCK);
        customBlockModel(ModBlocks.BIG_RED_BUTTON, "big_red_button");
        customBlockModel(ModBlocks.BIG_DANGER_BUTTON, "big_danger_button");
        customBlockModel(ModBlocks.INDUSTRIAL_LEVER, "industrial_lever");
        withExistingParent("wire_carpet", modLoc("block/wire_carpet"));
        simpleBlockItem(ModBlocks.STEEL_DOOR);
        simpleBlockItem(ModBlocks.WARPED_EXIT_DOOR);
        simpleBlockItem(ModBlocks.CRIMSON_EXIT_DOOR);
        evenSimplerBlockItem(ModBlocks.PALLET);
        trapdoorItem(ModBlocks.STEEL_TRAPDOOR);
        simpleBlockItem(ModBlocks.CRANK);
        trapdoorItem(ModBlocks.VENTILATION_GRILLE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(), // Nombre del json
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "item/" + item.getId().getPath())); // Ruta a la textura
    }
    private ItemModelBuilder customBlockModel(RegistryObject<Block> block, String model){
        return withExistingParent(block.getId().getPath(),
                new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/"+model))
                .transforms()

                .transform(ItemDisplayContext.GUI)
                .rotation(30, 315, 0)
                .translation(0, 3, 0)
                //.scale(0.625f, 0.625f, 0.625f)
                .end()

                .transform(ItemDisplayContext.GROUND)
                .translation(0, 5, 0)
                .scale(0.5f, 0.5f, 0.5f)
                .end()

                .transform(ItemDisplayContext.FIXED)
                .rotation(-90, 180, 0)
                .translation(0, 0, -7)
                //.scale(0.5f, 0.5f, 0.5f)
                .end()

                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(75, 45, 0)
                .translation(-3, 8f, -3)
                .scale(0.5f, 0.5f, 0.5f)
                .end()

                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0, 45, 0)
                .translation(0, 6, 0)
                .scale(0.75f, 0.75f, 0.75f)
                .end()

                .end();
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(MarioiosIndustrialBlocks.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID,"item/" + item.getId().getPath()));
    }
}
