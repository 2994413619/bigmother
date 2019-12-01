package club.ityuchao.labeledExpr.test;

import club.ityuchao.labeledExpr.LabeledExprLexer;
import club.ityuchao.labeledExpr.LabeledExprParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * @author yuchao
 * @description 使用antlr4模拟计算器，计算机的入口
 * @date 2019/12/1
 */
public class Calc {
    public static void main(String[] args) throws IOException {
        //新建一个CharStream，从标准输入读取数据
        ANTLRInputStream inputStream = new ANTLRInputStream(System.in);

        //新建一个词法分析器，处理输入的CharStram
        LabeledExprLexer lexer = new LabeledExprLexer(inputStream);

        //新建一个词法分析的缓冲区，用于存储词法分析将要生成的词法符号
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //新建一个语法分析器，处理词法符号缓冲区的内容
        LabeledExprParser parser = new LabeledExprParser(tokens);

        //针对init规则，开始语法分析
        ParseTree tree = parser.prog();

        EvalVisitor eval = new EvalVisitor();
        eval.visit(tree);

    }
}
/**
 * 输入格式如下：
 * 193
 * a=5
 * b=6
 * a+b*2
 * (1+2)*3
 * 换行符表示一个表达式结束
 */