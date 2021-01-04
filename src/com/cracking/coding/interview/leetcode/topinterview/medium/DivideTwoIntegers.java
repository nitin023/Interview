package com.cracking.coding.interview.leetcode.topinterview.medium;

/**
 * 29. Divide Two Integers
 * Medium
 * https://leetcode.com/problems/divide-two-integers/
 * O(logN)
 * Binary Search
 * Special cases handled
 * Divide By zero case
 * Divide By 1 case
 * Sign case
 * Divide By divisor > dividend
 * Finding precision using numbers length for accuracy
 */
public class DivideTwoIntegers {

    public  int divide(double x, double y) {
        if (y == 0) {
            return Integer.MAX_VALUE; // return Infinity
        }

        int sign = 1;
        if (x * y < 0) {
            sign = -1;
        }

        x = Math.abs(x);
        y = Math.abs(y);

        if (y == 1) {
            return (int) (x * sign);
        }

        if (x == y) {
            return sign;
        }

        if (x < y) {
            return 0;
        }

        String xStr = String.valueOf((int)x);
        String yStr = String.valueOf((int)y);

        int diff = Math.abs(yStr.length() - xStr.length());

        double precision = Math.pow(10,-diff);
        double start = 0.0, end = Double.MAX_VALUE;

        double mid = 0.0;
        while (true) {
            mid = start + ((end - start) / 2);
            if (Math.abs(y * mid - x) <= precision) {
                return (int) mid * sign;
            } else if (y * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
    }
}
