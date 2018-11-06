package com.planner.application.mongo;

public class MongoRunner {

    public static void main(String[] args) {
        ConnectionToMongo connectionToMongo = new ConnectionToMongo();
        connectionToMongo.insertDocumentToMongo();
    }

}
