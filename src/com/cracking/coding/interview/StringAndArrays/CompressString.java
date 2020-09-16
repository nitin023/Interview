package com.cracking.coding.interview.StringAndArrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CompressString {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCases = Integer.parseInt(st.nextToken());
        while (testCases > 0) {
            String target = br.readLine();
            System.out.println(getCompressedString(target));
            testCases--;
        }
    }

    private static String getCompressedString(String unCompressedString) {
        if (unCompressedString == null || unCompressedString.length() == 0) {
            return unCompressedString;
        }
        StringBuilder sb = new StringBuilder();
        int unCompressedLen = unCompressedString.length();
        for (int i = 0; i < unCompressedLen; ) {
            char item = unCompressedString.charAt(i);
            int j = i, freq = 0;
            while (j < unCompressedLen && unCompressedString.charAt(j) == item) {
                j++;
                freq++;
            }
            sb.append(item);
            sb.append(freq);
            i = j;
        }
        return sb.toString();
    }
}
