package com.puxinxiaolin.subject.AINuggets.easy;

public class P7 {
    public static String solution(int n, String template_, String[] titles) {
        String regexPattern = template_.replaceAll("\\{[^}]*}", ".*");

        StringBuilder sb = new StringBuilder();
        for (String title : titles) {
            if (title.matches(regexPattern)) {
                sb.append("True,");
            } else {
                sb.append("False,");
            }
        }

        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] testTitles1 = {"adcdcefdfeffe", "adcdcefdfeff", "dcdcefdfeffe", "adcdcfe"};
        String[] testTitles2 = {"CLSomGhcQNvFuzENTAMLCqxBdj", "CLSomNvFuXTASzENTAMLCqxBdj", "CLSomFuXTASzExBdj", "CLSoQNvFuMLCqxBdj", "SovFuXTASzENTAMLCq", "mGhcQNvFuXTASzENTAMLCqx"};
        String[] testTitles3 = {"abcdefg", "abefg", "efg"};

        System.out.println(solution(4, "ad{xyz}cdc{y}f{x}e", testTitles1).equals("True,False,False,True"));
        System.out.println(solution(6, "{xxx}h{cQ}N{vF}u{XTA}S{NTA}MLCq{yyy}", testTitles2).equals("False,False,False,False,False,True"));
        System.out.println(solution(3, "a{bdc}efg", testTitles3).equals("True,True,False"));
    }
}
