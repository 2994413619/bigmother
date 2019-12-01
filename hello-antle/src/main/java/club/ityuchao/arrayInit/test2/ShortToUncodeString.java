package club.ityuchao.arrayInit.test2;

import club.ityuchao.arrayInit.ArrayInitBaseListener;
import club.ityuchao.arrayInit.ArrayInitParser;

/**
 * @author yuchao
 * @description
 * @date 2019/12/1
 */
public class ShortToUncodeString extends ArrayInitBaseListener {

    //把 { 翻译为 "
    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.println("\"");
    }

    //把 } 翻译为 "
    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.println("\"");
    }

    /*将每个整数翻译为四位十六进制，前面加*/
    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        //假设不存在嵌套
        int value = Integer.parseInt(ctx.Int().getText());
        System.out.printf("\\u%04x",value);
    }
}
