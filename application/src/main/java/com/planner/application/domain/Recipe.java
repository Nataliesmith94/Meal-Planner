package com.planner.application.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@EntityScan
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "Recipes_Collection")
public class Recipe {

    @Id
    @Generated
    private String recipeId;
    private String mealName;
    private List ingredients;
    private List method;
    private double prepTime;
    private double cookingTime;
    private List categories;
    private String author;
}
