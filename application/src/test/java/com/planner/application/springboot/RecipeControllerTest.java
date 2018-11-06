package com.planner.application.springboot;

import com.planner.application.domain.Recipe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = RecipeController.class)
public class RecipeControllerTest {

    @MockBean
    private RecipeService recipeService;

    @InjectMocks
    private RecipeController recipeController;

    @Autowired
    private MockMvc mockMvc;

   public Recipe recipe1, recipe2;

    @Before
    public void setUp() throws Exception {

        List<String> ingrediants1 = Arrays.asList("Chicken", "Rice");
        List<String> method1 = Arrays.asList("1. Fry Chicken", "2. add in vegatables");
        List<String> cateogory1 = Arrays.asList("Indian", "Spicy");

        Recipe recipe1 = new Recipe( "uuid1", "Chicken Curry", ingrediants1, method1, 0.2, 1.0, cateogory1, "Blah");
        Recipe recipe2 = new Recipe( "uuid2", "Mash Potateo", ingrediants1, method1, 0.4, 6.0, cateogory1, "Blah");

    }

    @Test
    public void postRecipeIntoMongoDB() throws Exception {
        mockMvc.perform(post("/plannerDB/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(" {\n" +
                        " \t\t\"recipeId\": \"002\",\n" +
                        "        \"mealName\": \"pork chops\",\n" +
                        "        \"ingredients\": [\"pork chops\", \"baked potaeo\", \"veg\"],\n" +
                        "        \"prepTime\": 0.25,\n" +
                        "        \"cookingTime\": 0.30,\n" +
                        "        \"categories\": [\"easy\", \"quick\"],\n" +
                        "        \"author\": \"author\",\n" +
                        "        \"image\": \"test.img\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldFindAllRecipesInTheDataBase() throws Exception {
        when(recipeService.findAllRecipes()).thenReturn(Arrays.asList(recipe1, recipe2));

        mockMvc.perform(get("/search/findAll")
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));
    }

    @Test
    public void shouldFindRecipeByID() throws Exception {
        List<String> ingrediants1 = Arrays.asList("Chicken", "Rice");
        List<String> method1 = Arrays.asList("1. Fry Chicken", "2. add in vegatables");
        List<String> cateogory1 = Arrays.asList("Indian", "Spicy");
        Recipe recipe2 = new Recipe( "uuid2", "Mash Potateo", ingrediants1, method1, 0.4, 6.0, cateogory1, "Blah");

        String IdToSearch = "uuid1";

        when(recipeService.findById(IdToSearch)).thenReturn(recipe2);

        mockMvc.perform(get("/search/findByID/{id}", IdToSearch)
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void shouldReturnErrorWhenSearchingForIncorrectRecipeID() throws Exception {
//        String IncorrectID = "WrongID";
//        when(recipeService.findById(IncorrectID)).thenReturn(null);
//
//        mockMvc.perform(get("/search/findByID/{id}", IncorrectID)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Recipe not found with that ID"));
    }

    @Test
    public void shouldFindRecipeByMealName() throws Exception {
        List<String> ingrediants2 = Arrays.asList("Sasuage", "Beans", "Potateos");
        List<String> method2 = Arrays.asList("1. Peal Potaeos", "2. add to pan");
        List<String> cateogory2 = Arrays.asList("British", "Home cooked");

        Recipe recipe3 = new Recipe( "uuid2", "Mash Potateo", ingrediants2, method2, 0.4, 6.0, cateogory2, "Blah");

        String searchedRecipeName = "Chicken Curry";
        when(recipeService.findRecipeByName(searchedRecipeName)).thenReturn(Arrays.asList(recipe3));

        mockMvc.perform(get("/search/findByMealName/{mealName}", searchedRecipeName )
        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].mealName").value("Mash Potateo"))
                .andExpect(status().isOk());

    }


    @Test
    public void shouldReturnErrorWhenSearchingForIncorrectMealName() throws Exception {
//        String IncorrectMealName = "WrongMealName";
//        when(recipeService.findRecipeByName(IncorrectMealName)).thenReturn(null);
//
//        mockMvc.perform(get("/search/findByMealName/{mealName}", IncorrectMealName)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound())
//                .andExpect(content().string("Recipe not found match that Meal Name"));
    }

}