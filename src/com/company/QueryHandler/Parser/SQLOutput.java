package com.company.QueryHandler.Parser;

import com.company.QueryHandler.Parser.output.SqlBaseListener;
import com.company.QueryHandler.Parser.output.SqlParser;

public class SQLOutput extends SqlBaseListener {
    public void enterParse(SqlParser.ParseContext context){
        System.out.println("Entering Parse: "
                + context.sql_stmt_list().get(0)
                .sql_stmt().get(0)
                .factored_select_stmt()
                .select_core().get(0)
                .result_column().get(2)
                .getText()
        );
    }

    public void exitParse(SqlParser.ParseContext ctx ) {
        System.out.println( "Exiting Parse" );
    }
}
