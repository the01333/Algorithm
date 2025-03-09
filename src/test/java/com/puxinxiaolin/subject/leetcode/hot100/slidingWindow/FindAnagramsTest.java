package com.puxinxiaolin.subject.leetcode.hot100.slidingWindow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FindAnagramsTest {

    @Test
    void test1()
    {
        String s = "cbaebabacd";
        String p = "abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> list = findAnagrams.findAnagrams(s, p);
        System.out.println(list);
    }

    @Test
    void test2()
    {
        String s = "abab";
        String p = "ab";
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> list = findAnagrams.findAnagrams(s, p);
        System.out.println(list);
    }
}
