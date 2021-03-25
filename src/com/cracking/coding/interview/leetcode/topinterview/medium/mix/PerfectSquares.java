package com.cracking.coding.interview.leetcode.topinterview.medium.mix;

/*
279. Perfect Squares
https://leetcode.com/problems/perfect-squares/
Medium
Dynamic Programming + Mathmetical
*/
public class PerfectSquares {

    final int MAX = 10000;

    int[] lookup = new int[MAX];

    // dp lookup table solution  Complexity : N * sqrt (N)
    public int numSquares(int n) {
        lookup[0] = 0;
        for (int i = 1; i <= n; ++i) {
            lookup[i] = i;
            for (int j = 1; j * j <= i; ++j) {
                int sq = j * j;
                lookup[i] = Math.min(lookup[i], 1 + lookup[i - sq]);
            }
        }
        return lookup[n];
    }

    /**
     * Legendre's 3-square theorem
     * O(N) complexity
     *
     * @param n int
     * @return numSquares
     */
    public int getNumSquares(int n) {
        if (Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n)))
            return 1;
        while (n % 4 == 0)   //Remove 4^a term
            n /= 4;

        if (n % 8 == 7)      //check if the no now is in the form of (8b + 7)
            return 4;

        for (int i = 1; i * i <= n; ++i) {
            int base = (int) Math.sqrt(n - i * i);
            if (base * base == (n - i * i))
                return 2;
        }
        return 3;
    }
}
