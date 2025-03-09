package com.puxinxiaolin.subject.AINuggets.middle;

/**
 * @Description: 股票市场交易策略优化
 * @url: https://www.marscode.cn/practice/qjpjrn339ee9r7?problem_id=7414004855076012076
 * @Author: YccLin
 * @Date: 2024/12/9
 */
public class P80 {
    public static int solution(int[] stocks) {
        int n = stocks.length;
        int[] hold = new int[n];
        int[] sell = new int[n];
        int[] freezing = new int[n];

        hold[0] = -stocks[0];
        sell[0] = 0;
        freezing[0] = 0;

        for (int i = 1; i < n; i++) {
            // 持有的最大利润 可以是前一天买的，或前一天冷冻期，今天买入
            hold[i] = Math.max(hold[i - 1], freezing[i - 1] - stocks[i]);
            // 卖出的最大利润 只能是前一天卖的，今天卖出
            sell[i] = hold[i - 1] + stocks[i];
            // 冷冻期的最大利润 可以是前一天卖的，或冷冻期的最大值
            freezing[i] = Math.max(sell[i - 1], freezing[i - 1]);
        }
        return Math.max(sell[n - 1], freezing[n - 1]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2}) == 1);
        System.out.println(solution(new int[]{2, 1}) == 0);
        System.out.println(solution(new int[]{1, 2, 3, 0, 2}) == 3);
        System.out.println(solution(new int[]{2, 3, 4, 5, 6, 7}) == 5);
        System.out.println(solution(new int[]{1, 6, 2, 7, 13, 2, 8}) == 12);
    }
}
