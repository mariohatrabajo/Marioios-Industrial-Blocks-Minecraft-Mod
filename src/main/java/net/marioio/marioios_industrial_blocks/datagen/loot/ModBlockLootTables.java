package net.marioio.marioios_industrial_blocks.datagen.loot;

import net.marioio.marioios_industrial_blocks.block.ModBlocks;
import net.marioio.marioios_industrial_blocks.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.LIGHTBULB.get());
        this.dropSelf(ModBlocks.REDSTONE_LIGHTBULB.get());
        this.dropSelf(ModBlocks.NIXIE_TUBE.get());
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_PLATE_BLOCK.get());
        this.dropSelf(ModBlocks.DANGER_LINES_BLOCK.get());
        this.dropSelf(ModBlocks.WIRE_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_STAIRS.get());
        this.add(ModBlocks.STEEL_SLAB.get(), block -> createSlabItemTable(ModBlocks.STEEL_SLAB.get()));
        this.dropSelf(ModBlocks.STEEL_WALL.get());
        this.dropSelf(ModBlocks.STEEL_FENCE.get());
        this.dropSelf(ModBlocks.STEEL_BUTTON.get());
        this.dropSelf(ModBlocks.STEEL_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.STEEL_PLATE_STAIRS.get());
        this.add(ModBlocks.STEEL_PLATE_SLAB.get(), block -> createSlabItemTable(ModBlocks.STEEL_PLATE_SLAB.get()));
        this.dropSelf(ModBlocks.STEEL_PLATE_WALL.get());
        this.dropSelf(ModBlocks.STEEL_PLATE_FENCE.get());
        this.dropSelf(ModBlocks.STEEL_PLATE_BUTTON.get());
        this.dropSelf(ModBlocks.STEEL_PLATE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CHISELED_STEEL_BLOCK.get());
        this.dropSelf(ModBlocks.STEEL_PILLAR.get());
        this.dropSelf(ModBlocks.WIRE_BUNDLE.get());
        this.dropSelf(ModBlocks.CHAIN_WIRE_FENCE.get());
        this.dropSelf(ModBlocks.BARBED_WIRE.get());
        this.dropSelf(ModBlocks.CHIMNEY_BLOCK.get());
        //this.dropSelf(ModBlocks.CHIMNEY_WALL.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_EYE.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_BLUESCREEN.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_NOSIGNAL.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_MOJANG.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_COMMAND.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_SOUND.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_MATRIX.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_DESKTOP.get());
        this.dropSelf(ModBlocks.MONITOR_BLOCK_TARGET.get());
        this.dropSelf(ModBlocks.BIG_RED_BUTTON.get());
        this.dropSelf(ModBlocks.BIG_DANGER_BUTTON.get());
        this.dropSelf(ModBlocks.INDUSTRIAL_LEVER.get());
        this.dropSelf(ModBlocks.WIRE_CARPET.get());
        this.dropSelf(ModBlocks.CRANK.get());
        this.add(ModBlocks.STEEL_DOOR.get(), block -> createDoorTable(ModBlocks.STEEL_DOOR.get()));
        this.add(ModBlocks.WARPED_EXIT_DOOR.get(), block -> createDoorTable(ModBlocks.WARPED_EXIT_DOOR.get()));
        this.add(ModBlocks.CRIMSON_EXIT_DOOR.get(), block -> createDoorTable(ModBlocks.CRIMSON_EXIT_DOOR.get()));
        this.add(ModBlocks.PALLET.get(), block -> createSlabItemTable(ModBlocks.PALLET.get()));
        this.dropSelf(ModBlocks.STEEL_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CARDBOARD_BOX.get());
        this.dropSelf(ModBlocks.VENTILATION_GRILLE.get());
        this.dropSelf(ModBlocks.SERVER_RACK.get());
    }

    // Custom function para que suelte entre 2 y 5 items, en este caso
    // click central en createOreDrop para ver todas las funciones vanilla
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                (LootPoolEntryContainer.Builder)this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }


    // Todos los bloques de ModBlocks.BLOCKS que no tengan .noLootTable() tendrán loot table
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
