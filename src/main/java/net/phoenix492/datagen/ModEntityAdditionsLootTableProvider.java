package net.phoenix492.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.CompositeLootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.phoenix492.questeleven.QuestEleven;
import net.phoenix492.questeleven.item.ModItems;
import org.jetbrains.annotations.NotNull;

import java.util.function.BiConsumer;



public class ModEntityAdditionsLootTableProvider implements LootTableSubProvider {
    HolderLookup.Provider lookupProvider;
    protected ModEntityAdditionsLootTableProvider(HolderLookup.Provider lookupProvider) {
        this.lookupProvider = lookupProvider;
    }

    @Override
    public void generate(@NotNull BiConsumer<ResourceKey<LootTable>, LootTable.Builder> consumer) {
        consumer.accept(
            ResourceKey.create(
                Registries.LOOT_TABLE,
                ResourceLocation.fromNamespaceAndPath(QuestEleven.MODID, "warden_addtional_loot")
            ),
            LootTable.lootTable().withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.SCULK_DISC_TEMPLATE.get()))
                    .setBonusRolls(ConstantValue.exactly(0f))
                    .setRolls(ConstantValue.exactly(1f))
            )
        );
    }
}
