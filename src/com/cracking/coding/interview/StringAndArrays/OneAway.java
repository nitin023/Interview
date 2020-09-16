package com.cracking.coding.interview.StringAndArrays;

/**
 * One Away
 */
public class OneAway {

    public static void main(String[] args) {
        System.out.println(checkForOneEditAway("pale", "bale"));
        System.out.println(checkForOneEditAway("pale", "ple"));
        System.out.println(checkForOneEditAway("pale", "pales"));
        System.out.println(checkForOneEditAway("pale", "take"));
    }

    public static boolean checkForOneEditAway(String s1, String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if (lenS2 > lenS1) {
            String s3 = s1;
            s1 = s2;
            s2 = s3;
            lenS1 = s1.length();
            lenS2 = s2.length();
        }

        int diff = Math.abs(lenS1 - lenS2);
        if (diff > 1) {
            return false;
        }
        int degreeOfDiff = 0;
        int i, j;
        if (diff == 0) {
            for (i = 0; i < lenS1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    degreeOfDiff++;
                }
            }
        } else {

            for (i = 0, j = 0; i < lenS1; i++) {
                if (j < lenS2 && s1.charAt(i) != s2.charAt(j)) {
                    degreeOfDiff++;
                }
                else if(j >= lenS2)
                {
                    degreeOfDiff++;
                }
                else {
                    j++;
                }
            }
        }
        return degreeOfDiff == 1;
    }
}
