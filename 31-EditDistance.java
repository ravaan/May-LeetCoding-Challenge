class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;

        int[][] dp = new int[len1][len2];

        if (word1.charAt(len1 - 1) != word2.charAt(len2 - 1))
            dp[len1 - 1][len2 - 1] = 1;

        boolean consumed = false;
        for (int i = len1 - 2; i >= 0; i--) {
            dp[i][len2 - 1] = dp[i + 1][len2 - 1] + 1;
            if (word1.charAt(i) == word2.charAt(len2 - 1) && !consumed) {
                dp[i][len2 - 1]--;
                consumed = true;
            }
        }

        consumed = false;
        for (int i = len2 - 2; i >= 0; i--) {
            dp[len1 - 1][i] = dp[len1 - 1][i + 1] + 1;
            if (word1.charAt(len1 - 1) == word2.charAt(i) && !consumed) {
                dp[len1 - 1][i]--;
                consumed = true;
            }
        }

        for (int i = len1 - 2; i >= 0; i--) {
            for (int j = len2 - 2; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    int temp = Math.min(dp[i + 1][j], dp[i][j + 1]);
                    dp[i][j] = Math.min(temp, dp[i + 1][j + 1]) + 1;
                }
            }
        }

        // for(int a[]: dp) System.out.println(Arrays.toString(a));
        return dp[0][0];
    }
}


