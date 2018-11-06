package com.planner.application.springboot;

import com.planner.application.domain.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;


    public String AddNewRecipeToMongoDb(Recipe recipe) {
        recipeRepository.save(recipe);
        String confirmation = "Thanks you meal " + recipe.getMealName() + " has been saved";
        System.out.println("Saved Meal");
        return confirmation;
    }

    public List<Recipe> findRecipeByName(String mealName) {
        return recipeRepository.findByMealName(mealName);
    }

    public List<Recipe> findAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe findById(String id) throws IOException {
        return recipeRepository.findByRecipeId(id);
    }
}
