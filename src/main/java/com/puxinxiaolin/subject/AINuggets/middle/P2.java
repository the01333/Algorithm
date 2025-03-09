package com.puxinxiaolin.subject.AINuggets.middle;

public class P2 {
    public static int solution(int n, int k, int[] data) {
        int totalCost = 0, currentFoodCount = 0;

        for (int i = 0; i < n; i++) {
            // 每天消耗一份食物
            if (currentFoodCount > 0) {
                currentFoodCount--;
            } else {
                // 没有食物时必须购买当天的食物
                totalCost += data[i];
            }

            // 计算当前需要补充的食物数量
            int maxFoodToBuy = Math.min(k - currentFoodCount, n - i - 1);
            int foodToBuy = 0;

            for (int j = 1; j <= maxFoodToBuy; j++) {
                if (i + j < n && data[i + j] < data[i]) {
                    // 如果未来更便宜且能覆盖剩余需求，则停止购买
                    break;
                }
                // 否则购买当前天的食物
                foodToBuy++;
            }

            // 更新总花费和当前持有的食物数量
            totalCost += foodToBuy * data[i];
            currentFoodCount += foodToBuy;
        }
        return totalCost;
    }

    public static void main(String[] args) {
        System.out.println(solution(5, 2, new int[]{1, 2, 3, 3, 2}) == 9);
        System.out.println(solution(6, 3, new int[]{4, 1, 5, 2, 1, 3}) == 9);
        System.out.println(solution(4, 1, new int[]{3, 2, 4, 1}) == 10);
    }
}
