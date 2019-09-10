package com.company.QueryHandler.Show;

public class DataCollect {
    public void collect(int type) {
        System.out.print("query type: ");
        if (type == 0){
            System.out.println("SELECT");
        } else if (type == 1){
            System.out.println("UPDATE");
        } else if (type == 2){
            System.out.println("DELETE");
        }
    }
}
