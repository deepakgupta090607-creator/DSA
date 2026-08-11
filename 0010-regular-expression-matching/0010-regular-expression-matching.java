class Solution {
    static boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Empty string matches empty pattern
        dp[0][0] = true;

        // Empty string with patterns like a*, a*b*, a*b*c*
        for (int j = 2; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                // Normal character or '.'
                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                }

                // '*'
                else if (pc == '*') {

                    // '*' matches zero occurrences
                    dp[i][j] = dp[i][j - 2];

                    // '*' matches one or more occurrences
                    char previous = p.charAt(j - 2);

                    if (previous == '.' || previous == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        return dp[n][m];
    }
}