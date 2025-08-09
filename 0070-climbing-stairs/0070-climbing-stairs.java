class Solution {
    public int climbStairs(int n) {
        // dp같은데 흠...
        int[] dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        dp[5] = 8;
        for(int i = 6; i <= 45; i++) {
            dp[i] = Math.max(dp[i - 1] + 1, dp[i - 1] + dp[i - 2]);
        }
        return dp[n];
    }
}
/**
1 1 1 1 1
1 2 1 1
2 1 1 1
2 2 1
1 1 2 1
1 1 1 2
1 2 2
2 1 2
 */