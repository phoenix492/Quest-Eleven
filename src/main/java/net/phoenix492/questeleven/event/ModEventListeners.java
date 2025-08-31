package net.phoenix492.questeleven.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.phoenix492.questeleven.QuestEleven;
import net.phoenix492.questeleven.data_attachements.ModDataAttachments;

@EventBusSubscriber(modid = QuestEleven.MODID)
public class ModEventListeners {
    @SubscribeEvent
    private static void applyOneshot(LivingDamageEvent.Pre event) {
        if (!event.getEntity().level().isClientSide() && event.getNewDamage() >= event.getEntity().getMaxHealth()) {
            event.getEntity().setData(ModDataAttachments.ENTITY_ONESHOT.get(), true);
        }
    }

    @SubscribeEvent(receiveCanceled = true)
    private static void removeOneshot(LivingDeathEvent event) {
        if (event.isCanceled() && !event.getEntity().level().isClientSide() && event.getEntity().hasData(ModDataAttachments.ENTITY_ONESHOT.get())) {
            event.getEntity().removeData(ModDataAttachments.ENTITY_ONESHOT.get());
        }
    }
}
