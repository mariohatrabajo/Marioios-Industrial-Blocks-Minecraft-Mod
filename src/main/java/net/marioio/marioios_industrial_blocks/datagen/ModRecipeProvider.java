package net.marioio.marioios_industrial_blocks.datagen;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.marioio.marioios_industrial_blocks.block.ModBlocks;
import net.marioio.marioios_industrial_blocks.item.ModItems;
import net.marioio.marioios_industrial_blocks.util.ModTags;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        nixieTubeRecipes(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DANGER_LINES_BLOCK.get(), 4)
                .pattern("by ")
                .pattern("yb ")
                .pattern("   ")
                .define('y', Blocks.YELLOW_CONCRETE)
                .define('b', Blocks.BLACK_CONCRETE)
                .unlockedBy(getHasName(Blocks.BLACK_CONCRETE_POWDER), has(Blocks.BLACK_CONCRETE_POWDER))
                .save(pWriter);
        steelRecipes(pWriter);
        steelPlateRecipes(pWriter);
        wireRecipes(pWriter);
        chimneyRecipes(pWriter);
        monitorRecipes(pWriter);
        redstoneRecipes(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_EXIT_DOOR.get(), 3)
                .pattern("ww ")
                .pattern("ii ")
                .pattern("ww ")
                .define('w', Items.WARPED_PLANKS)
                .define('i', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.WARPED_PLANKS), has(Items.WARPED_PLANKS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_EXIT_DOOR.get(), 3)
                .pattern("cc ")
                .pattern("gg ")
                .pattern("cc ")
                .define('c', Items.CRIMSON_PLANKS)
                .define('g', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.CRIMSON_PLANKS), has(Items.CRIMSON_PLANKS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALLET.get(), 5)
                .pattern("www")
                .pattern("w w")
                .pattern("   ")
                .define('w', ItemTags.WOODEN_SLABS)
                .unlockedBy(getHasName(Items.OAK_PLANKS), has(ItemTags.PLANKS))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CARDBOARD_BOX.get(), 1)
                .pattern("ppp")
                .pattern("p p")
                .pattern("ppp")
                .define('p', Items.PAPER)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(pWriter);
    }
    private static void nixieTubeRecipes(Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.REDSTONE_LIGHTBULB.get(), 4)
                .pattern(" g ")
                .pattern("grg")
                .pattern(" c ")
                .define('g', Items.GLASS)
                .define('r', Items.REDSTONE)
                .define('c', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.NIXIE_TUBE.get(), 4)
                .pattern(" g ")
                .pattern("grg")
                .pattern("gcg")
                .define('g', Items.GLASS)
                .define('r', Items.REDSTONE)
                .define('c', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHTBULB.get(), 4)
                .pattern(" g ")
                .pattern("gdg")
                .pattern(" c ")
                .define('g', Items.GLASS)
                .define('d', Items.GLOWSTONE_DUST)
                .define('c', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST))
                .save(pWriter);
    }

    private static void steelRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_BLOCK.get(), 1)
                .pattern("nin")
                .pattern("iii")
                .pattern("nin")
                .define('i', Items.IRON_INGOT)
                .define('n', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_STAIRS.get(), 4)
                .pattern("  s")
                .pattern(" ss")
                .pattern("sss")
                .define('s', ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("sss")
                .define('s', ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_WALL.get(), 6)
                .pattern("   ")
                .pattern("sss")
                .pattern("sss")
                .define('s', ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.STEEL_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" ss")
                .define('s', ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.STEEL_BUTTON.get(), 1)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_STEEL_BLOCK.get(), 1)
                .pattern("s  ")
                .pattern("s  ")
                .pattern("   ")
                .define('s', ModBlocks.STEEL_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PILLAR.get(), 2)
                .pattern("s  ")
                .pattern("s  ")
                .pattern("   ")
                .define('s', ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHAIN_WIRE_FENCE.get(), 4)
                .pattern("i i")
                .pattern(" i ")
                .pattern("i i")
                .define('i', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BARBED_WIRE.get(), 4)
                .pattern(" i ")
                .pattern("i i")
                .pattern(" i ")
                .define('i', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_FENCE.get(), 6)
                .pattern("   ")
                .pattern("sis")
                .pattern("sis")
                .define('i', Items.IRON_INGOT)
                .define('s', ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_DOOR.get(), 3)
                .pattern("id ")
                .pattern("id ")
                .pattern("id ")
                .define('i', Items.IRON_INGOT)
                .define('d', ModBlocks.DANGER_LINES_BLOCK.get())
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_TRAPDOOR.get(), 2)
                .pattern("   ")
                .pattern("ici")
                .pattern("iii")
                .define('i', Items.IRON_INGOT)
                .define('c', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VENTILATION_GRILLE.get(), 2)
                .pattern("   ")
                .pattern("iii")
                .pattern("iii")
                .define('i', Items.IRON_NUGGET)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        // Stonecutter
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_STAIRS.get(), ModBlocks.STEEL_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_SLAB.get(), ModBlocks.STEEL_BLOCK.get(),2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_WALL.get(), ModBlocks.STEEL_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_FENCE.get(), ModBlocks.STEEL_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_BLOCK.get(), ModBlocks.STEEL_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_STAIRS.get(), ModBlocks.STEEL_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_SLAB.get(), ModBlocks.STEEL_BLOCK.get(),2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_BUTTON.get(), ModBlocks.STEEL_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_WALL.get(), ModBlocks.STEEL_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_FENCE.get(), ModBlocks.STEEL_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_STEEL_BLOCK.get(), ModBlocks.STEEL_BLOCK.get());
    }

    private static void steelPlateRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_BLOCK.get(), 4)
                .pattern("ii ")
                .pattern("ii ")
                .pattern("   ")
                .define('i', ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_PLATE_STAIRS.get(), 4)
                .pattern("  s")
                .pattern(" ss")
                .pattern("sss")
                .define('s', ModBlocks.STEEL_PLATE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_SLAB.get(), 6)
                .pattern("   ")
                .pattern("   ")
                .pattern("sss")
                .define('s', ModBlocks.STEEL_PLATE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_WALL.get(), 6)
                .pattern("   ")
                .pattern("sss")
                .pattern("sss")
                .define('s', ModBlocks.STEEL_PLATE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.STEEL_PLATE_PRESSURE_PLATE.get())
                .pattern("   ")
                .pattern("   ")
                .pattern(" ss")
                .define('s', ModBlocks.STEEL_PLATE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.STEEL_PLATE_BUTTON.get(), 1)
                .requires(ModBlocks.STEEL_PLATE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_FENCE.get(), 6)
                .pattern("   ")
                .pattern("sis")
                .pattern("sis")
                .define('i', Items.IRON_INGOT)
                .define('s', ModBlocks.STEEL_PLATE_BLOCK.get())
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT));
        // Stonecutter
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_STAIRS.get(), ModBlocks.STEEL_PLATE_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_SLAB.get(), ModBlocks.STEEL_PLATE_BLOCK.get(),2);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_WALL.get(), ModBlocks.STEEL_PLATE_BLOCK.get());
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_PLATE_FENCE.get(), ModBlocks.STEEL_PLATE_BLOCK.get());
    }
    private static void wireRecipes(Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WIRE_BLOCK.get(), 6)
                .pattern("w w")
                .pattern("wcw")
                .pattern("w w")
                .define('w', ItemTags.WOOL)
                .define('c', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WIRE_BUNDLE.get(), 4)
                .pattern("ww ")
                .pattern("ww ")
                .pattern("   ")
                .define('w', ModBlocks.WIRE_BLOCK.get())
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WIRE_CARPET.get(), 3)
                .pattern("ww ")
                .pattern("   ")
                .pattern("   ")
                .define('w', ModTags.Items.WIRE_BLOCKS)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        stonecutterResultFromBase(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WIRE_BUNDLE.get(), ModBlocks.WIRE_BLOCK.get());
    }
    private static void chimneyRecipes(Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHIMNEY_BLOCK.get(), 1)
                .pattern("i i")
                .pattern("ici")
                .pattern("i i")
                .define('i', Items.IRON_INGOT)
                .define('c', Items.COAL)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
        /*ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHIMNEY_BLOCK.get(), 1)
                .requires(ModBlocks.CHIMNEY_WALL.get())
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter, "chimney_from_wall");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHIMNEY_WALL.get(), 1)
                .requires(ModBlocks.CHIMNEY_BLOCK.get())
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);*/
    }
    private static void monitorRecipes(Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK.get(), 1)
                .pattern("iii")
                .pattern("iwi")
                .pattern("igi")
                .define('w', ModTags.Items.WIRE_BLOCKS)
                .define('i', Items.IRON_INGOT)
                .define('g', Blocks.GLASS_PANE)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.WATER_BUCKET)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter, "base_monitor_from_water");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_EYE.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.ENDER_EYE)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_BLUESCREEN.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.LAPIS_BLOCK)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_NOSIGNAL.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Tags.Items.DYES)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_MOJANG.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.CREEPER_HEAD)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_COMMAND.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.REDSTONE)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_SOUND.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.SCULK_SENSOR)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_MATRIX.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.GRAVEL)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_DESKTOP.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.CRAFTING_TABLE)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MONITOR_BLOCK_TARGET.get(), 1)
                .requires(ModTags.Items.MONITOR_BLOCKS)
                .requires(Items.TARGET)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SERVER_RACK.get(), 4)
                .pattern("iii")
                .pattern("www")
                .pattern("iii")
                .define('w', ModTags.Items.WIRE_BLOCKS)
                .define('i', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);
    }
    private static void redstoneRecipes(Consumer<FinishedRecipe> pWriter){
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.BIG_RED_BUTTON.get(), 2)
                .pattern("r  ")
                .pattern("s  ")
                .pattern("   ")
                .define('r', Blocks.REDSTONE_BLOCK)
                .define('s', ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.BIG_DANGER_BUTTON.get(), 2)
                .pattern("r  ")
                .pattern("d  ")
                .pattern("   ")
                .define('r', Blocks.REDSTONE_BLOCK)
                .define('d', ModBlocks.DANGER_LINES_BLOCK.get())
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.INDUSTRIAL_LEVER.get(), 1)
                .pattern("c  ")
                .pattern("l  ")
                .pattern("   ")
                .define('c', Items.COPPER_INGOT)
                .define('l', Items.LEVER)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, MarioiosIndustrialBlocks.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
