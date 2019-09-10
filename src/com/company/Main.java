package com.company;

import com.company.QueryHandler.QueryHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String queryInput = input.nextLine();
        QueryHandler queryHandler = new QueryHandler();
        queryHandler.process(queryInput);
    }
}
