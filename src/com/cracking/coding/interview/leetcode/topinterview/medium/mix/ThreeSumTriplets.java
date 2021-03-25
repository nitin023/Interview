package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

import java.util.*;

/**
 * Medium
 * https://leetcode.com/problems/3sum/
 * O(N*N)
 */
public class ThreeSumTriplets {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        return threeSumTripletCalculator(nums);
    }

    private List<List<Integer>> threeSumTripletCalculator(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        if (nums.length >= 10000) {
            Arrays.parallelSort(nums);
        } else {
            Arrays.sort(nums);
        }
        for (int i = 0; i  < nums.length - 2 ; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
