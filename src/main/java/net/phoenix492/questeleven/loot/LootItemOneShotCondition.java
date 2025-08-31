package net.phoenix492.questeleven.loot;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.phoenix492.questeleven.QuestEleven;
import net.phoenix492.questeleven.data_attachements.ModDataAttachments;

import java.util.Set;

public record LootItemOneShotCondition() implements LootItemCondition {

    private static final LootItemOneShotCondition INSTANCE = new LootItemOneShotCondition();
    public static final MapCodec<LootItemOneShotCondition> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public LootItemConditionType getType() {
        return ModLootItemConditions.ONE_SHOT_CONDITION.get();
    }

    @Override
    public Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(LootContextParams.THIS_ENTITY);
    }

    @Override
    public boolean test(LootContext context) {
        QuestEleven.LOGGER.info("Testing LootItemOneShotCondition");
        Entity killedEntity = context.getParamOrNull(LootContextParams.THIS_ENTITY);
        QuestEleven.LOGGER.info("killedEntity hasData ModDataAttachments.ENTITY_ONESHOT: " + killedEntity.hasData(ModDataAttachments.ENTITY_ONESHOT.get()));
        return killedEntity.hasData(ModDataAttachments.ENTITY_ONESHOT.get()) && killedEntity.getData(ModDataAttachments.ENTITY_ONESHOT.get());
    }

    public static LootItemCondition.Builder entityOneshot() {
        return LootItemOneShotCondition::new;
    }
}
