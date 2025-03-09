package com.puxinxiaolin.subject.lanqiao.javaB2024;

import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while (n-- > 0) {
            String s = sc.nextLine();
            String[] str = s.split(" ");
            int a2 = Integer.parseInt(str[0]);
            int a3 = Integer.parseInt(str[1]);
            int a4 = Integer.parseInt(str[2]);
            int b4 = Integer.parseInt(str[3]);
            int b6 = Integer.parseInt(str[4]);

            int sum = 0;
            // 满座匹配4人寝坐4人桌
            while (b4 > 0 && a4 >= 1) {
                b4--;
                a4--;
                sum += 4;
            }
            // 满座匹配2x2人寝坐4人桌
            while (b4 > 0 && a2 >= 2) {
                b4--;
                a2 -= 2;
                sum += 4;
            }
            // 满座匹配2+4人寝坐6人桌
            while (b6 > 0 && a4 >= 1 && a2 >= 1) {
                b6--;
                a4--;
                a2--;
                sum += 6;
            }
            // 满座匹配2x3人寝坐6人桌
            while (b6 > 0 && a3 >= 2) {
                b6--;
                a3 -= 2;
                sum += 6;
            }
            // 满座匹配3x2人寝坐6人桌
            while (b6 > 0 && a2 >= 3) {
                b6--;
                a2 -= 3;
                sum += 6;
            }
            // 空1座匹配2+3人寝坐6人桌
            while (b6 > 0 && a2 >= 1 && a3 >= 1) {
                b6--;
                a2--;
                a3--;
                sum += 5;
            }
            // 空1座匹配3人寝坐4人桌
            while (b4 > 0 && a3 > 0) {
                b4--;
                a3--;
                sum += 3;
            }
            // 空2座匹配2x2人寝坐6人桌
            while (b6 > 0 && a2 >= 2) {
                b6--;
                a2 -= 2;
                sum += 4;
            }
            // 空2座匹配4人寝坐6人桌
            while (b6 > 0 && a4 > 0) {
                b6--;
                a4--;
                sum += 4;
            }
            // 空2座匹配2人寝坐4人桌
            while (b4 > 0 && a2 > 0) {
                b4--;
                a2--;
                sum += 2;
            }
            // 空3座匹配3人寝坐6人桌
            while (b6 > 0 && a3 > 0) {
                b6--;
                a3--;
                sum += 3;
            }
            // 空4座匹配2人寝坐6人桌
            while (b6 > 0 && a2 > 0) {
                b6--;
                a2--;
                sum += 2;
            }

            System.out.println(sum);
        }
        sc.close();
    }
}
