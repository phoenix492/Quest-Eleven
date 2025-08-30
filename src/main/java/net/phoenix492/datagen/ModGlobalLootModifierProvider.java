package net.phoenix492.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;
import net.phoenix492.questeleven.QuestEleven;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, QuestEleven.MODID);
    }

    @Override
    protected void start() {
        this.add(
          "warden_oneshot_drop",
          new AddTableLootModifier(
              new LootItemCondition[] {},
              ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(QuestEleven.MODID, "warden_aditional_loot"))
          )
        );
    }
}
