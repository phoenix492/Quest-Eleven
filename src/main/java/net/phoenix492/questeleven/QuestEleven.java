package net.phoenix492.questeleven;

import net.phoenix492.questeleven.data_attachements.ModDataAttachments;
import net.phoenix492.questeleven.item.ModItems;
import net.phoenix492.questeleven.loot.ModLootItemConditions;
import net.phoenix492.questeleven.sound.ModSounds;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(QuestEleven.MODID)
public class QuestEleven {
    // This NEVER changes.
    public static final String MODID = "questeleven";

    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public QuestEleven(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register Items
        ModItems.register(modEventBus);

        // Register Creative Mode Tab
        ModCreativeModeTab.register(modEventBus);

        // Register Sounds
        ModSounds.register(modEventBus);

        // Register Data Attachments
        ModDataAttachments.register(modEventBus);

        // Register loot conditions
        ModLootItemConditions.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, QuestElevenConfig.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
