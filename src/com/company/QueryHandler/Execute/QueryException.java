package com.company.QueryHandler.Execute;

public class QueryException extends Throwable {
    private int code;
    QueryException(){
        code = -1;
    }
    QueryException(int e){
        code = e;
    }
}
