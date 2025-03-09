package com.puxinxiaolin.subject.AINuggets.middle;

public class P60 {
    public static int solution(String rgb) {
        String s = rgb.replace("rgb", "")
                .replace("(", "").replace(")", "")
                .replace(", ", ",");
        String[] str = s.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            String hex = Integer.toHexString(Integer.parseInt(str[i]));
            // 补0
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            sb.append(hex);
        }
        return Integer.parseInt(sb.toString(), 16);
    }

    public static void main(String[] args) {
        System.out.println(solution("rgb(192, 192, 192)") == 12632256);
        System.out.println(solution("rgb(100, 0, 252)") == 6553852);
        System.out.println(solution("rgb(33, 44, 55)") == 2174007);
    }
}
