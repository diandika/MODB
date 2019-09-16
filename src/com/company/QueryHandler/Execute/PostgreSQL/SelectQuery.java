package com.company.QueryHandler.Execute.PostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;

public class SelectQuery {
    private String sqlQuery;

    public void queryExec(){
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "root");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("database opened");
    }
}
