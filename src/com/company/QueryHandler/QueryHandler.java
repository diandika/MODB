package com.company.QueryHandler;

import com.company.QueryHandler.Execute.QueryException;
import com.company.QueryHandler.Execute.QueryExecute;
import com.company.QueryHandler.Parser.QueryParser;
import com.company.QueryHandler.Show.DataCollect;

public class QueryHandler {
    public void process(String query){
        try {
            QueryParser queryParser = new QueryParser();
            queryParser.parse(query);
            QueryExecute queryExecute = new QueryExecute();
            int type = queryExecute.exeute(query);
            DataCollect dataCollect = new DataCollect();
            dataCollect.collect(type);
        }catch (QueryException e){
            System.out.println("Syntax Error");
        }
    }
}
