package net.phoenix492.questeleven.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenix492.questeleven.QuestEleven;

public class ModItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(QuestEleven.MODID);

    public static final DeferredItem<Item> MUSIC_DISC_ELEVEN = ITEMS.register(
        "music_disc_eleven",
        () -> new Item(new Item.Properties()
            .jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(QuestEleven.MODID, "eleven")))
            .stacksTo(1)
            .rarity(Rarity.EPIC)
        )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
