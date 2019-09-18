package com.company.QueryHandler.Parser;

import com.company.QueryHandler.Parser.output.SqlBaseListener;
import com.company.QueryHandler.Parser.output.SqlParser;

import java.util.List;

public class SQLOutput extends SqlBaseListener {
    public void enterParse(SqlParser.ParseContext context){
        System.out.println("Entering Parse: ");
        List<SqlParser.Result_columnContext> ctx = context.sql_stmt_list().get(0)
                .sql_stmt().get(0)
                .factored_select_stmt()
                .select_core().get(0)
                .result_column();
        for (SqlParser.Result_columnContext result_columnContext : ctx) {
            printAttr(0, result_columnContext.expr());
        }
    }

    private void printAttr(int i, SqlParser.ExprContext result_columnContext){
        int n = i;
        while (n>0){
            System.out.print("    ");
            n--;
        }
        if(result_columnContext.column_name() != null){
            System.out.println(result_columnContext.getText());
        }else if(result_columnContext.function_name() != null) {
            System.out.println(result_columnContext.function_name().getText());
            List<SqlParser.ExprContext> functionParameter = result_columnContext.expr();
            for (SqlParser.ExprContext exprContext : functionParameter) {
                printAttr(i+1, exprContext);
            }
        }
    }

    public void exitParse(SqlParser.ParseContext ctx ) {
        System.out.println( "Exiting Parse" );
    }
}
