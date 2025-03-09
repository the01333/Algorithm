package com.puxinxiaolin.subject.lanqiao.NO11;

import java.math.BigInteger;

/**
 * @description: 已知今天是星期六，请问20的22次方天后是星期几?
 * 注意用数字 1 到 7 表示星期一到星期日。
 * @author: YCcLin
 * @date: 2025/2/1
 **/
public class P1 {
    public static void main(String[] args) {
        BigInteger days = BigInteger.valueOf(20).pow(22);
        int dayOfWeek = days.mod(BigInteger.valueOf(7)).intValue();
        dayOfWeek = (dayOfWeek + 6) % 7 + 1;
        System.out.println(dayOfWeek);
    }
}
