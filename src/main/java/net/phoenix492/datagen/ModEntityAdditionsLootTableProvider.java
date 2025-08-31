package net.phoenix492.datagen;

import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.phoenix492.questeleven.QuestEleven;
import net.phoenix492.questeleven.item.ModItems;
import net.phoenix492.questeleven.loot.LootItemOneShotCondition;
import net.phoenix492.questeleven.loot.ModLootItemConditions;
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
                ResourceLocation.fromNamespaceAndPath(QuestEleven.MODID, "warden_additional_loot")
            ),
            LootTable.lootTable().withPool(LootPool.lootPool()
                    .add(LootItem.lootTableItem(ModItems.SCULK_DISC_TEMPLATE.get()))
                    .when( // Killed by player
                        LootItemKilledByPlayerCondition.killedByPlayer()
                    )
                    .when( // player holding mace
                        LootItemEntityPropertyCondition.hasProperties(
                            LootContext.EntityTarget.ATTACKING_PLAYER,
                            new EntityPredicate.Builder().equipment(new EntityEquipmentPredicate.Builder().mainhand(ItemPredicate.Builder.item().of(Items.MACE)))
                        )
                    )
                    .when( // entity killed in one hit
                        LootItemOneShotCondition.entityOneshot()
                    )
                    .setBonusRolls(ConstantValue.exactly(0f))
                    .setRolls(ConstantValue.exactly(1f))
            )
        );
    }
}
