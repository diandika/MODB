package com.company.QueryHandler.Parser;

import com.company.QueryHandler.Parser.output.SqlLexer;
import com.company.QueryHandler.Parser.output.SqlParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryParser {
    public void parse(String sql){
        System.out.println("input is: " + sql);

        SqlLexer sqlLexer = new SqlLexer(new ANTLRInputStream(sql));
        SqlParser sqlParser = new SqlParser(new CommonTokenStream(sqlLexer));
        ParseTree tree = sqlParser.parse();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new SQLOutput(), tree);
    }

    public void searchColumn(){
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/datamapping", "postgres", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM columnmapping");
            while (resultSet.next()){

            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
