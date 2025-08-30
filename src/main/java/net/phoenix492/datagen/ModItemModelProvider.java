package net.phoenix492.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.phoenix492.questeleven.QuestEleven;
import net.phoenix492.questeleven.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, QuestEleven.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.MUSIC_DISC_ELEVEN.get());
        basicItem(ModItems.SCULK_DISC_TEMPLATE.get());
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
            .texture(
                "texture",
                ResourceLocation.fromNamespaceAndPath(
                    QuestEleven.MODID,
                    "block/" + baseBlock.getId().getPath()
                )
            );
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
            .texture(
                "texture",
                ResourceLocation.fromNamespaceAndPath(
                    QuestEleven.MODID,
                    "block/" + baseBlock.getId().getPath()
                )
            );
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
            .texture(
                "wall",
                ResourceLocation.fromNamespaceAndPath(
                    QuestEleven.MODID,
                    "block/" + baseBlock.getId().getPath()
                )
            );
    }
}
