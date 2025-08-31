package net.phoenix492.questeleven.data_attachements;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.phoenix492.questeleven.QuestEleven;

import java.util.function.Supplier;

public class ModDataAttachments {
    public static DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, QuestEleven.MODID);

    public static final Supplier<AttachmentType<Boolean>> ENTITY_ONESHOT = ATTACHMENT_TYPES.register(
        "entity_oneshot",
        () -> AttachmentType.builder(() -> false).build()
    );

    public static void register(IEventBus bus) {
        ATTACHMENT_TYPES.register(bus);
    }
}
