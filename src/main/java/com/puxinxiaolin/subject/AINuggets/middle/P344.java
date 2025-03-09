package com.puxinxiaolin.subject.AINuggets.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @subject: 344 农场采摘水果问题
 * @uri: https://www.marscode.cn/practice/qjpjrn339ee9r7?problem_id=7424436653370933292
 * @description: 小U正在探访一座农场，农场的果树排成一列，用整数数组 fruits 表示，每个元素 fruits[i] 是第 i 棵树上的水果种类。
 * 小U有两个篮子，每个篮子只能装一种类型的水果，而且每个篮子可以装无限量的水果。
 * 小U从任意一棵树开始，必须从每棵树上恰好采摘一个水果，并且只能装入符合篮子中水果类型的果实。
 * 如果某棵树上的水果类型不符合篮子中的水果类型，则必须停止采摘。
 * 请你帮助小U计算他最多可以采摘多少个水果。
 * 例如：当 fruits = [1,2,3,2,2] 时，小U最多可以采摘的树是从第2棵开始，采摘到最后的 4 棵树，结果为 [2,3,2,2]。
 * @author: YCcLin
 * @date: 2024/12/13
 **/
public class P344 {
    public static int solution(int[] fruits) {
        // 记录水果种类
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;

        // 滑动数组不断根据条件扩展
        while (right < fruits.length) {
            // 我们让右指针一直移动，左指针根据种类数量来移动，每次右指针不管其他先移动后马上加入 map
            int cur = fruits[right];
            map.put(cur, map.getOrDefault(cur, 0) + 1);

            // 检查 map，如果种类超过两种，把最左的种类移掉，移动左指针，直到种类只剩下两种
            while (map.size() > 2) {
                // 在减的过程中，如果减到数量为 0 ，直接去除
                int leftFruit = fruits[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                left++;
            }

            // 更新 ans
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1, 2}) == 4);
        System.out.println(solution(new int[]{2, 0, 1, 2, 2}) == 3);
        System.out.println(solution(new int[]{1, 2, 3, 2, 2, 4}) == 4);
    }
}
