package club.ityuchao.labeledExpr.test;

import club.ityuchao.labeledExpr.LabeledExprBaseVisitor;
import club.ityuchao.labeledExpr.LabeledExprParser;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuchao
 * @description
 * @date 2019/12/1
 */
public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {

    //计算器的“内存”，存放变量名和变量值的对应关系
    Map<String ,Integer> memory = new HashMap<String,Integer>();

    //ID '=' expr NEWLINE
    @Override
    public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
        String id = ctx.ID().getText();             //id在“=”右侧
        Integer value = visit(ctx.expr());          //计算右侧表达式的值
        memory.put(id, value);                      //将这个映射关系存入到内存中
        return value;
    }

    //expr NEWLINE
    @Override
    public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
        Integer value = visit(ctx.expr());          //计算expr子节点的值
        System.out.println(value);                  //输出计算的值
        return 0;                                   //返回假值
    }

    // INT
    @Override
    public Integer visitInt(LabeledExprParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }

    //ID
    @Override
    public Integer visitId(LabeledExprParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            return memory.get(id);
        }
        return 0;
    }

    //expr op=('*'|'/') expr
    @Override
    public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
        Integer left = visit(ctx.expr(0));                  //计算左侧表达式的值
        Integer right = visit(ctx.expr(1));                 //计算右侧表达式的值
        if(ctx.op.getType() == LabeledExprParser.MUL){
            return left * right;
        }
        return left / right;
    }

    //expr op=('+'|'-') expr
    @Override
    public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
        Integer left = visit(ctx.expr(0));              //计算左侧表达式的值
        Integer right = visit(ctx.expr(1));             //计算右侧表达式的值
        if(ctx.op.getType() == LabeledExprParser.ADD){
            return left + right;
        }
        return left - right;
    }

    @Override
    public Integer visitParents(LabeledExprParser.ParentsContext ctx) {
        return visit(ctx.expr());                       //返回子表达式的值
    }
}
