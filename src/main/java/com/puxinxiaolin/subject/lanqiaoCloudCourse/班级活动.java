package com.puxinxiaolin.subject.lanqiaoCloudCourse;

import java.util.Scanner;

public class 班级活动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] a = new int[100001];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            a[arr[i]]++;
        }

        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                cnt1++;
            }
            if (a[i] > 2) {
                cnt2 += a[i] - 2;
            }
        }
        System.out.println(cnt2 > cnt1 ? cnt2 : (cnt1 + cnt2) / 2);

        sc.close();
    }
}
