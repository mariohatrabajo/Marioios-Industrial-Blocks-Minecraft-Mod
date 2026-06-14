package net.marioio.marioios_industrial_blocks;

import com.mojang.logging.LogUtils;
import net.marioio.marioios_industrial_blocks.block.ModBlocks;
import net.marioio.marioios_industrial_blocks.block.entity.ModBlockEntities;
import net.marioio.marioios_industrial_blocks.fluid.ModFluidTypes;
import net.marioio.marioios_industrial_blocks.fluid.ModFluids;
import net.marioio.marioios_industrial_blocks.item.ModCreativeModeTabs;
import net.marioio.marioios_industrial_blocks.item.ModItems;
import net.marioio.marioios_industrial_blocks.loot.ModLootModifiers;
import net.marioio.marioios_industrial_blocks.particle.ModParticles;
import net.marioio.marioios_industrial_blocks.screen.BoxScreen;
import net.marioio.marioios_industrial_blocks.screen.ModMenuTypes;
import net.marioio.marioios_industrial_blocks.sound.ModSounds;
import net.marioio.marioios_industrial_blocks.util.ModWoodTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MarioiosIndustrialBlocks.MOD_ID)
public class MarioiosIndustrialBlocks
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "marioios_industrial_blocks";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public MarioiosIndustrialBlocks()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);
        ModParticles.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModSounds.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        // Add items to a vanilla creative tab
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(ModWoodTypes.PROHIBITION);

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHAIN_WIRE_FENCE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BARBED_WIRE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_BLOCK_MATRIX.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_BLOCK_COMMAND.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_BLOCK_MOJANG.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_BLOCK_NOSIGNAL.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_BLOCK_BLUESCREEN.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_BLOCK_EYE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.MONITOR_BLOCK_SOUND.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.BOX_MENU.get(), BoxScreen::new);
        }

        @SubscribeEvent
        public static void registerParticleProvider(RegisterParticleProvidersEvent event) {
        }
    }
}
