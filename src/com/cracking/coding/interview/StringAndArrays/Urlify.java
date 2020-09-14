package com.cracking.coding.interview.StringAndArrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Urlify {
    public static void main(String[] args) throws Exception {
        //code
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());

        while (testCases > 0) {
            String target = br.readLine();
            int length = Integer.parseInt(br.readLine());
            printURL(target);
            testCases--;
        }
    }

    private static void printURL(String target) {
        if (target == null || target.length() == 0) {
            return;
        }

        StringBuilder sb = new StringBuilder(target.length());

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(target.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}
