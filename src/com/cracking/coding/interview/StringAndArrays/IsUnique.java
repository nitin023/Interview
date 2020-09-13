package com.cracking.coding.interview.StringAndArrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/contains-duplicate/
 */
public class IsUnique {

    public static void main(String[] args) {
        containsDuplicate("bnghrb");
    }

    //OlogN
    public boolean containsDuplicateSortingApproach(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);
        for (int i = 0, j = i + 1; j < nums.length; i++, j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Best approach to solve the problem
     * @param nums
     * @return
     */
    //O(1) approximately
    public static boolean containsDuplicate(String nums) {
        if (nums == null || nums.length() == 0) {
            return false;
        }

        boolean[] ascii = new boolean[128];

        for (int i = 0; i < nums.length(); i++) {
            int asciiVal_item = nums.charAt(i);
            if (ascii[asciiVal_item]) {
                return true;
            }
            ascii[asciiVal_item] = true;
        }
        return false;
    }
}
