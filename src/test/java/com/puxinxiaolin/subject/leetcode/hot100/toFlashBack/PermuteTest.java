package com.puxinxiaolin.subject.leetcode.hot100.toFlashBack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PermuteTest {

    @Test
    void permute() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = Permute.permute(nums);

        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1, 3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );

        assertEquals(expected, actual);
    }
}