package club.ityuchao.arrayInit.test;

import club.ityuchao.arrayInit.ArrayInitLexer;
import club.ityuchao.arrayInit.ArrayInitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * @author yuchao
 * @description
 * @date 2019/12/1
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //新建一个CharStream，从标准输入读取数据
        ANTLRInputStream inputStream = new ANTLRInputStream(System.in);

        //新建一个词法分析器，处理输入的CharStram
        ArrayInitLexer lexer = new ArrayInitLexer(inputStream);

        //新建一个词法分析的缓冲区，用于存储词法分析将要生成的词法符号
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        //新建一个语法分析器，处理词法符号缓冲区的内容
        ArrayInitParser parser = new ArrayInitParser(tokens);

        //针对init规则，开始语法分析
        ParseTree tree = parser.init();

        //用LISP风格打印生成的树
        System.out.println(tree.toStringTree(parser));
    }
}
