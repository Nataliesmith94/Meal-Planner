package com.planner.application.springboot;

import com.planner.application.domain.NotFoundException;
import com.planner.application.domain.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    //Post Requests
    @RequestMapping(value = "/plannerDB/add", method = RequestMethod.POST)
    public String AddNewRecipe(@RequestBody Recipe recipe) {
        return recipeService.AddNewRecipeToMongoDb(recipe);
    }


    //Get Requests
    @RequestMapping("/search/findAll")
    public List<Recipe> findAll() {
        return recipeService.findAllRecipes();
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "Welcome Natalie";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/search/findByMealName/{mealName}")
    public List<Recipe> findRecipeByMealName(@PathVariable("mealName") String mealName, HttpServletResponse response) {
        List<Recipe> matchedRecipes = recipeService.findRecipeByName(mealName);
        Optional.ofNullable(matchedRecipes)
                .orElseThrow(()-> new NotFoundException("Recipe not found matching that Meal Name"));
        return matchedRecipes;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/findByMealName")
    public List<Recipe> findRecipeByMealName(@RequestParam String mealName) {
        List<Recipe> matchedRecipes = recipeService.findRecipeByName(mealName);
        Optional.ofNullable(matchedRecipes)
                .orElseThrow(()-> new NotFoundException("Recipe not found matching that Meal Name"));
        return matchedRecipes;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/search/findByID/{id}")
    public Recipe findByID(@PathVariable("id") String id) throws IOException {
        Recipe matchedRecipe = recipeService.findById(id);
        Optional.ofNullable(matchedRecipe)
                .orElseThrow(() -> new NotFoundException("Recipe not found with that ID"));
        return matchedRecipe;
    }

}