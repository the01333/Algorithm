package com.puxinxiaolin.subject.leetcode.hot100.slidingWindow;

import java.util.*;

/**
 * @Description: leetcode 438
 * @Author: YccLin
 * @Date: 2024/10/27
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for (int i = 0; i < pLen; i++) {
            ++sCnt[s.charAt(i) - 'a'];    // 字符 -> Ascll码，放入数组的对应位置
            ++pCnt[p.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCnt, pCnt)) {
            list.add(0);
        }

        // 每次循环：根据上面的窗口，最左和最右的位置各往右移一格
        for (int i = 0; i < sLen - pLen; i++) {
            --sCnt[s.charAt(i) - 'a'];
            ++sCnt[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCnt, pCnt)) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
