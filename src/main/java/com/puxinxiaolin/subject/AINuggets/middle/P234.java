package com.puxinxiaolin.subject.AINuggets.middle;

/**
 * @description: 加权平均分 = (各科目的分数 * 对应学分) 进行累加 / 总学分
 * @author: YCcLin
 * @date: 2024/12/12
 **/
public class P234 {
    public static boolean solution(int n, int targetScore, int[] credits, int[] scores) {
        for (int score : scores) {
            if (score < 60) {
                return false;
            }
        }

        int sum = 0;
        for (int credit : credits) {
            sum += credit;
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += credits[i] * scores[i];
        }

        return (double) res / sum >= targetScore;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 75, new int[]{4, 3, 2, 1}, new int[]{80, 70, 90, 60}));
        System.out.println(solution(3, 85, new int[]{3, 2, 5}, new int[]{90, 85, 88}));
        System.out.println(solution(5, 80, new int[]{2, 2, 3, 1, 4}, new int[]{78, 80, 79, 85, 88}));
        System.out.println(solution(6, 70, new int[]{4, 3, 2, 1, 2, 3}, new int[]{60, 72, 65, 90, 85, 95}));
        System.out.println(!solution(4, 90, new int[]{2, 2, 2, 2}, new int[]{89, 91, 92, 85}));
        System.out.println(!solution(16, 4, new int[]{58, 61, 87, 85, 53, 91, 62, 68, 51, 87, 85, 56, 94, 73, 75, 51}, new int[]{76, 73, 92, 77, 96, 64, 89, 81, 78, 97, 75, 55, 58, 91, 55, 57}));
    }
}
