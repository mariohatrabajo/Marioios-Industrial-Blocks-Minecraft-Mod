package net.marioio.marioios_industrial_blocks.sound;

import net.marioio.marioios_industrial_blocks.MarioiosIndustrialBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MarioiosIndustrialBlocks.MOD_ID);

    public static final RegistryObject<SoundEvent> BIG_RED_BUTTON_USE = registerSoundEvent("big_red_button_use");
    public static final RegistryObject<SoundEvent> MONITOR_ON = registerSoundEvent("monitor_on");
    public static final RegistryObject<SoundEvent> INDUSTRIAL_LEVER_USE = registerSoundEvent("industrial_lever_use");
    public static final RegistryObject<SoundEvent> CRANK_USE = registerSoundEvent("crank_use");
    public static final RegistryObject<SoundEvent> CARDBOARD_BOX_OPEN = registerSoundEvent("cardboard_box_open");
    public static final RegistryObject<SoundEvent> CARDBOARD_BOX_CLOSE = registerSoundEvent("cardboard_box_close");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(MarioiosIndustrialBlocks.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
