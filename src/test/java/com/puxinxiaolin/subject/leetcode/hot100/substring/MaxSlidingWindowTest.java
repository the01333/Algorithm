package com.puxinxiaolin.subject.leetcode.hot100.substring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class MaxSlidingWindowTest {

    @Test
    void test() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        MaxSlidingWindow msw = new MaxSlidingWindow();
        int[] result = msw.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }
}
