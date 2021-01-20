package com.cracking.coding.interview.leetcode.topinterview.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Easy
 * https://leetcode.com/problems/fizz-buzz/
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        if (n <= 0) {
            return new ArrayList();
        }
        List<String> fizzList = new ArrayList(n);
        helper(fizzList, n);
        return fizzList;
    }


    private void helper(List<String> fizzList, int n) {
        HashMap<Integer, String> fizzBizDict = new LinkedHashMap<>();
        fizzBizDict.put(3, "Fizz");
        fizzBizDict.put(5, "Buzz");
        for (int num = 1; num <= n; num++) {
            StringBuilder numAnsStr = new StringBuilder();

            for (Integer key : fizzBizDict.keySet()) {
                if (num % key == 0) {
                    numAnsStr.append(fizzBizDict.get(key));
                }
            }

            if (numAnsStr.toString().equals("")) {
                numAnsStr.append(Integer.toString(num));
            }
            fizzList.add(numAnsStr.toString());
        }
    }
}
