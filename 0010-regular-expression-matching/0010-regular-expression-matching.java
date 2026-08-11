class Solution {
    static boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    static boolean solve(String s, String p, int i, int j) {

        // Pattern completely finished
        if (j == p.length()) {
            return i == s.length();
        }

        // Check whether current characters match
        boolean match = i < s.length() &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        // Next character is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {

            // 1. '*' matches zero times
            // 2. '*' matches one or more times
            return solve(s, p, i, j + 2) ||
                   (match && solve(s, p, i + 1, j));
        }

        // Normal character or '.'
        return match && solve(s, p, i + 1, j + 1);
    }
}