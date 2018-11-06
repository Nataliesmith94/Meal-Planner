package com.planner.application.springboot;

import com.planner.application.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@DataMongoTest
@AutoConfigureTestEntityManager
public class RecipeRepositoryTest {

    @Mock
    RecipeRepository recipeRepository;

    private Recipe recipe1, recipe2, recipe3;

    @Before
    public void setup() {
        List<String> ingrediants1 = Arrays.asList("Chicken", "Rice");
        List<String> method1 = Arrays.asList("1. Fry Chicken", "2. add in vegatables");
        List<String> cateogry1 = Arrays.asList("Indian", "Spicy");

        List<String> ingrediants2 = Arrays.asList("Sasuage", "Potateos", "Beans");
        List<String> method2 = Arrays.asList("1. Peal Potaeos", "2. add to pan");
        List<String> cateogry2 = Arrays.asList("British", "home cooked");

        recipe1 = createRecipe("uuid1", "Chicken Curry", ingrediants1, method1, 0.2, 1.0, cateogry1, "Blah");
        recipe2 = createRecipe("uuid2", "Sausage & Mash", ingrediants2, method2, 0.3, 0.5, cateogry2, "Blah 2");
    }


    @Test
    public void shouldReturnCorrectRecipeWhenSearchingById() {
        when(recipeRepository.findByMealName("string")).thenReturn(Arrays.asList(recipe1));

        Recipe result = recipeRepository.findByRecipeId("uuid23");
        assertEquals(recipe1, result);
    }

    @Test
    public void shouldNotReturnRecipesWhenIncorrectDataIsEntered() {
        Recipe result = recipeRepository.findByRecipeId("incorrectID");
        assertNotEquals(recipe1, result);
    }

    @Test
    public void shouldReturnCorrectRecipeWhenSearchingByMealName() {
        List results = recipeRepository.findByMealName("Chicken Curry");
        assertFalse(results.isEmpty());
        assertEquals(recipe1, results.get(0));
        assertEquals(1, results.size());
    }

    @Test
    public void shouldNotReturnRecipesWhenIncorrectMealNameIsEntered() {
        List results = recipeRepository.findByMealName("Incorrect Name");
        assertTrue(results.isEmpty());
    }

    interface Repo extends MongoRepository<String, String> {

    }


    private Recipe createRecipe(String recipeId, String mealName, List ingrediants, List method, double prepTime, double cookingTime, List categories, String author) {
        Recipe recipe = new Recipe(recipeId, mealName, ingrediants, method, prepTime, cookingTime, categories, author );
        return recipeRepository.save(recipe);
    }

}