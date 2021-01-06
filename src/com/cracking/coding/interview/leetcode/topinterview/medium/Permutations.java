package com.cracking.coding.interview.leetcode.topinterview.medium;

import java.util.*;

/**
 * Medium
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 * O(N*N!)
 */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3,4};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList();
        }

        Set<List<Integer>> _responseList = new HashSet<>();

        List<Integer> numList = new ArrayList<>(nums.length);

        for (int a : nums) {
            numList.add(a);
        }

        generatePermutations(0, numList.size() - 1, numList, _responseList);

        return new ArrayList<>(_responseList);
    }


    private static void generatePermutations(int l, int r, List<Integer> numList, Set<List<Integer>> _responseList) {
        if (l == r) {
            _responseList.add(numList);
        } else {
            for (int i = l; i <= r; i++) {
                //fixing the letter
                Collections.swap(numList, l, i);
                //gen permutations for non-fixed letters
                generatePermutations(l + 1, r, new ArrayList<>(numList), _responseList);
                //resetting the swapping for back tracking
                Collections.swap(numList, l, i);
            }
        }
    }
}
