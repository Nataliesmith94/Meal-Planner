package com.planner.application.springboot;

import com.planner.application.domain.Recipe;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository <Recipe, String> {

    List<Recipe> findByMealName(String mealName);

    Recipe findByRecipeId(String recipeId);
}
