package net.marioio.marioios_industrial_blocks.util;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType PROHIBITION = WoodType.register(new WoodType(MarioiosIndustrialBlocks.MOD_ID+":prohibition", BlockSetType.OAK));
}
