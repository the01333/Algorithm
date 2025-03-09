package com.puxinxiaolin.subject.lanqiaoCloudCourse;

public class 奇怪的捐赠 {
    public static void main(String[] args) {
        long[] arr = {1, 7, 49, 343, 2401, 16807, 117649, 823543};
        for (int a = 0; a <= 5; a++) {
            for (int b = 0; b <= 5; b++) {
                for (int c = 0; c <= 5; c++) {
                    for (int d = 0; d <= 5; d++) {
                        for (int e = 0; e <= 5; e++) {
                            for (int f = 0; f <= 5; f++) {
                                for (int g = 0; g <= 5; g++) {
                                    for (int h = 0; h <= 5; h++) {
                                        if (a * arr[0] + b * arr[1] + c * arr[2] + d * arr[3] + e * arr[4] + f * arr[5] + g * arr[6] + h * arr[7] == 1000000) {
                                            System.out.println(a + b + c + d + e + f + g + h);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
