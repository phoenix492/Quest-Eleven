package net.phoenix492.datagen.builders;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;

public class PerformantSmithingTransformRecipeBuilder extends SmithingTransformRecipeBuilder {
    private final Ingredient subTemplate;
    private final Ingredient subBase;
    private final Ingredient subAddition;
    private final Item subResult;

    public PerformantSmithingTransformRecipeBuilder(Ingredient template, Ingredient base, Ingredient addition, RecipeCategory category, Item result) {
        super(template, base, addition, category, result);
        this.subTemplate = template;
        this.subBase = base;
        this.subAddition = addition;
        this.subResult = result;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation recipeId) {
        SmithingTransformRecipe smithingtransformrecipe = new SmithingTransformRecipe(this.subTemplate, this.subBase, this.subAddition, new ItemStack(this.subResult));
        recipeOutput.accept(recipeId, smithingtransformrecipe, null);
    }

    public static PerformantSmithingTransformRecipeBuilder smithing(Ingredient template, Ingredient base, Ingredient addition, RecipeCategory category, Item result) {
        return new PerformantSmithingTransformRecipeBuilder(template, base, addition, category, result);
    }
}
