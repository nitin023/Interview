package com.cracking.coding.interview.leetcode.topinterview.medium;

/**
 * https://leetcode.com/problems/product-of-array-except-self
 * Medium
 * O(N)
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        if(nums == null || nums.length == 0){
            return nums ;
        }

        return getProductExceptSelf(nums);
    }

    private int[] getProductExceptSelf(int nums[]){

        int length = nums.length;
        int []left = new int[length];
        int []right = new int[length];
        left [0] = right[length-1] = 1;


        for(int i = 1 ; i < length ; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        for(int i = length - 2 ; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        int[] productExceptSelf = new int[length];

        for(int i = 0 ; i < length ; i++){
            productExceptSelf[i] = left[i] * right[i];
        }

        return productExceptSelf;
    }
}
