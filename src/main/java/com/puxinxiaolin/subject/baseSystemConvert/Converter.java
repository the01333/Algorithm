package com.puxinxiaolin.subject.baseSystemConvert;

/**
 * @Description: 进制转换
 * @Author: YccLin
 * @Date: 2024/10/31
 */
public class Converter {

    /**
     * 十进制转换任意进制
     *
     * @param num
     * @param target
     * @return
     */
    public String getResult(int num, int target) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % target);
            num /= target;
        }
        return sb.reverse().toString();
    }

    /**
     * 十进制转换任意进制（工具版）
     *
     * @param num
     * @param target
     * @return
     */
    public String getResultByTool(int num, int target) {
        return Integer.toString(num, target);
    }

    /**
     * 任意进制转换十进制
     *
     * @param num
     * @param target
     * @return
     */
    public int convertOther2Num(String num, int target) {
        return Integer.parseInt(num, target);
    }
}
