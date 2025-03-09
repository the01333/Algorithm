package com.puxinxiaolin.subject.AINuggets.easy;

public class P3 {
    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
        System.out.println(solution("1985747.2605881577").equals("1,985,747.2605881577"));
    }

    public static String solution(String s) {
        if (s.contains(".")) {
            return dealWithDot(s);
        } else {
            return dealNormal(s);
        }
    }

    /**
     * 处理不带小数点的情况
     *
     * @param s 要转换的数
     * @return 转为千分位样式的结果
     */
    private static String dealNormal(String s) {
        s = s.replaceFirst("^0*", "");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (count == 3) {
                sb.append(',');
                count = 0;
            }
            sb.append(s.charAt(i));
            count++;
        }

        return sb.reverse().toString();
    }

    /**
     * 处理带小数点的情况
     *
     * @param s 要转换的数
     * @return 转为千分位样式的结果
     */
    private static String dealWithDot(String s) {
        String[] strArr = s.split("\\.");
        String positive = strArr[0];
        String negative = strArr[1];
        String ans1 = dealNormal(positive);
        String ans2 = negative.replaceAll("0*$", "");
        return ans1 + "." + ans2;
    }
}
