package net.phoenix492.questeleven;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.phoenix492.questeleven.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static DeferredRegister<net.minecraft.world.item.CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, QuestEleven.MODID);

    public static final Supplier<CreativeModeTab> QUEST_ELEVEN_TAB = CREATIVE_MODE_TAB.register(
        "questeleven_items",
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.MUSIC_DISC_ELEVEN.get()))
            .title(Component.translatable("creativetab.questeleven.items"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.MUSIC_DISC_ELEVEN);
                output.accept(ModItems.SCULK_DISC_TEMPLATE);
            }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
