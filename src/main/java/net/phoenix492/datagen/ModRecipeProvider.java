package net.phoenix492.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.phoenix492.datagen.builders.PerformantSmithingTransformRecipeBuilder;
import net.phoenix492.questeleven.QuestEleven;
import net.phoenix492.questeleven.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        PerformantSmithingTransformRecipeBuilder.smithing(
            Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
            Ingredient.of(Items.MUSIC_DISC_11),
            Ingredient.of(Items.ECHO_SHARD),
            RecipeCategory.MISC, // Doesn't do anything
            ModItems.MUSIC_DISC_ELEVEN.get()
        )
        .save(recipeOutput, ResourceLocation.parse("questeleven:disc_eleven_smithing"));

        super.buildRecipes(recipeOutput);
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
        RecipeOutput recipeOutput,
        RecipeSerializer<T> serializer,
        AbstractCookingRecipe.Factory<T> recipeFactory,
        List<ItemLike> ingredients,
        RecipeCategory category,
        ItemLike result,
        float experience,
        int cookingTime,
        String group,
        String suffix
    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory)
                .group(group)
                .unlockedBy(getHasName(itemlike), has(itemlike))
                .save(recipeOutput, QuestEleven.MODID + getItemName(result) + suffix + "_" + getItemName(itemlike));
        }
    }

    protected static void oreSmelting(
        RecipeOutput recipeOutput,
        List<ItemLike> ingredients,
        RecipeCategory category,
        ItemLike result,
        float experience,
        int cookingTime,
        String group
    ) {
        oreCooking(
            recipeOutput,
            RecipeSerializer.SMELTING_RECIPE,
            SmeltingRecipe::new,
            ingredients,
            category,
            result,
            experience,
            cookingTime,
            group,
            "_from_smelting"
        );
    }

    protected static void oreBlasting(
        RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        oreCooking(
            recipeOutput,
            RecipeSerializer.BLASTING_RECIPE,
            BlastingRecipe::new,
            ingredients,
            category,
            result,
            experience,
            cookingTime,
            group,
            "_from_blasting"
        );
    }
}
