package com.company;

import com.company.QueryHandler.QueryHandler;
import com.mongodb.*;

import java.util.Scanner;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        DB db = mongoClient.getDB("tdrive");
        DBCollection collection = db.getCollection("taxilog");
        DBObject object = collection.find().one();

        assert object != null;
        System.out.println(object.get("lon").toString());

        String queryInput = input.nextLine();
        QueryHandler queryHandler = new QueryHandler();
        queryHandler.process(queryInput);
    }
}
