package com.puxinxiaolin.subject.baseSystemConvert;

import org.junit.jupiter.api.Test;

/**
 * @Description: 十进制转换任意进制
 * @Author: YccLin
 * @Date: 2024/10/31
 */
public class ConverterTest {

    private final Converter converter = new Converter();

    @Test
    void test1() {
        String result = converter.getResult(10, 2);
        System.out.println("test1: " + result);
    }

    @Test
    void getResultByTool() {
        String result = converter.getResultByTool(10, 2);
        System.out.println("getResultByTool: " + result);
    }

    @Test
    void convertOther2Num() {
        int num = converter.convertOther2Num("20", 5);
        System.out.println("convertOther2Num: " + num);
    }
}
