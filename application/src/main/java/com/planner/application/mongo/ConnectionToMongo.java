package com.planner.application.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class ConnectionToMongo {

    public static MongoCollection<BasicDBObject> connection() //  DBCollection
    {
        //Connection to Mongodb
        MongoClient mongo = new MongoClient("localhost", 27017);

        //Database Connection
        MongoDatabase db = mongo.getDatabase("Recipes_Database");

        //Collection Connection
        MongoCollection<BasicDBObject> collection = db.getCollection("Recipes_Collection", BasicDBObject.class);

        return collection;
    }





    public void insertDocumentToMongo() {
        MongoCollection<BasicDBObject> collection = connection();  //returns collection

        BasicDBObject recipieDBObject = new BasicDBObject();

        recipieDBObject.put("MealName", "Salad");
        recipieDBObject.put("Ingredients", "lettuce and cumber");
        recipieDBObject.put("PrepTime", 1.5);
        recipieDBObject.put("CookingTime", 0.5);
        recipieDBObject.put("Categories", "chineese");
        recipieDBObject.put("Source", "BBC");
        recipieDBObject.put("Author", "Kayla Itsine");
        recipieDBObject.put("Image", "blah.jpg");

        collection.insertOne(recipieDBObject);

    }


//    List<String> ingredientsList = new ArrayList<>();
//
//        ingredientsList.add("lettuce");
//        ingredientsList.add("tomarto");
//        ingredientsList.add("Carrots");
//
//    List<String> categoryList = new ArrayList<>();
//
//        categoryList.add("Chineese");
//        categoryList.add("Low Calorie");
//
//        recipieDBObject.put("MealName", "Salad");
//        recipieDBObject.put("Ingredients", ingredientsList);
//        recipieDBObject.put("PrepTime", "1.5");
//        recipieDBObject.put("CookingTime", "0.5");
//        recipieDBObject.put("Categories", categoryList);
//        recipieDBObject.put("Source", "BBC");
//        recipieDBObject.put("Author", "Kayla Itsine");
//        recipieDBObject.put("Image", "blah.jpg");
//
//        collection.insertOne(recipieDBObject);
}
