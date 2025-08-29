package net.phoenix492.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.phoenix492.questeleven.QuestEleven;

public class ModBlockstateProvider extends BlockStateProvider {

    public ModBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, QuestEleven.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {}

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("phoenixtestmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String suffix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("phoenixtestmod:block/" + deferredBlock.getId().getPath() + suffix));
    }
}
