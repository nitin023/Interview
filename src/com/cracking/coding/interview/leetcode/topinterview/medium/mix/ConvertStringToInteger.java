package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

/**
 * Medium
 * https://leetcode.com/problems/string-to-integer-atoi/
 * O(N)
 */
public class ConvertStringToInteger {

    public int myAtoi(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        s = s.trim();
        int length = s.length();

        if (length == 0 || !isFirstCharValid(s.charAt(0))) {
            return 0;
        }

        StringBuilder sb = new StringBuilder(length);

        sb.append(s.charAt(0));

        int i = 1;

        if(s.charAt(0)=='0') {
            while (i < length && s.charAt(i) == '0')
                i++;
        }

        while (i < length) {
            char currentChar = s.charAt(i);
            if (!Character.isDigit(currentChar)) {
                break;
            }
            sb.append(currentChar);
            i++;
        }

        String responseString = sb.toString();

        int responseStringLength = responseString.length();

        if (responseStringLength == 1 && !Character.isDigit(responseString.charAt(0))) {
            return 0;
        }

        try {
            return Integer.parseInt(responseString);
        } catch (NumberFormatException nx) {
            if (responseString.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    private boolean isFirstCharValid(char firstChar) {
        return (firstChar == '+' || firstChar == '-' || Character.isDigit(firstChar));
    }
}
