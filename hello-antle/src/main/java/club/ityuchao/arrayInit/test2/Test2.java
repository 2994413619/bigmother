package club.ityuchao.arrayInit.test2;

import club.ityuchao.arrayInit.ArrayInitLexer;
import club.ityuchao.arrayInit.ArrayInitParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * @author yuchao
 * @description
 * @date 2019/12/1
 */
public class Test2 {
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

        //新建一个通用的、能够触发回调函数的语法分析树遍历器
        ParseTreeWalker walker = new ParseTreeWalker();

        //遍历语法分析过程生成的语法分析树，触发回调
        walker.walk(new ShortToUncodeString(), tree);

        System.out.println();
    }
}
