package com.cracking.coding.interview.StringAndArrays;

/**
 * https://leetcode.com/problems/rotate-string/submissions/
 * 1.9 String Rotation
 * Easy
 */
public class StringRotation {
    public boolean rotateString(String A, String B) {

        if (A.length() != B.length()) {
            return false;
        }

        StringBuilder sb = new StringBuilder(A.length() * 2);
        sb.append(A).append(A);

        String resultant = sb.toString();
        return resultant.contains(B);
    }
}
