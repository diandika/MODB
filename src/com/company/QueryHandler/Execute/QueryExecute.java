package com.company.QueryHandler.Execute;

import java.sql.Connection;
import java.sql.DriverManager;

public class QueryExecute {
    public int exeute(String sql) throws QueryException {
        if (sql.contains("select")){
            return 0;
        }
        if (sql.contains("update")){
            return 1;
        }
        if (sql.contains("delete")){
            return 2;
        }
        throw new QueryException(404);
    }
}
