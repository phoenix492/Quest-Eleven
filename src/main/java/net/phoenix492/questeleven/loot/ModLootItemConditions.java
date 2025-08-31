package net.phoenix492.questeleven.loot;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenix492.questeleven.QuestEleven;

import java.util.function.Supplier;

public class ModLootItemConditions {
    public static final DeferredRegister<LootItemConditionType> LOOT_ITEM_CONDITION_TYPES = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, QuestEleven.MODID);

    public static final Supplier<LootItemConditionType> ONE_SHOT_CONDITION = LOOT_ITEM_CONDITION_TYPES.register("one_shot",
        () -> new LootItemConditionType(LootItemOneShotCondition.CODEC)
    );

    public static void register(IEventBus eventBus) {
        LOOT_ITEM_CONDITION_TYPES.register(eventBus);
    }
}
