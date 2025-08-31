package net.phoenix492.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.phoenix492.questeleven.QuestEleven;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = QuestEleven.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Server/DataPack DataGen
        BlockTagsProvider blockTagsProvider = new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(
            event.includeServer(),
            new LootTableProvider(
                packOutput,
                Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModEntityAdditionsLootTableProvider::new, LootContextParamSets.ENTITY)),
                lookupProvider
            )
        );
        generator.addProvider(event.includeServer(), new ModGlobalLootModifierProvider(packOutput, lookupProvider));

        // Client/ResourcePack DataGen
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

    }
}
