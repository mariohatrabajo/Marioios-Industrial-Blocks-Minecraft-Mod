package net.marioio.marioios_industrial_blocks.datagen;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MarioiosIndustrialBlocks.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerModels() {
    }

    public ModelFile cubeWithSpecialFace(String name,
                                         ResourceLocation down, ResourceLocation up,
                                         ResourceLocation north, ResourceLocation south,
                                         ResourceLocation west, ResourceLocation east) {

        return getBuilder(name)
                .parent(new ModelFile.UncheckedModelFile("block/cube"))
                .texture("particle", north)
                .texture("down", down)
                .texture("up", up)
                .texture("north", north)
                .texture("south", south)
                .texture("west", west)
                .texture("east", east);
    }
}