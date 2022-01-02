package commonsolutions.algo.regular;

@SuppressWarnings("all")
public class RegularExpression {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j < p.length(); j ++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j - 1];
            }
        }
        for (int i = 0; i < s.length(); i ++) {
            for (int j = 0; j < p.length(); j ++) {
                //如果当前字符匹配那么只需要看前面的是否匹配即可 eg: s(abc) p(abc) 如果c == c的话，那么只需要看ab == ab就可以了（.代表任何字符所以存在.的时候都是match的）
                if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                //*的情况下需要考虑2种可能 第一种是匹配0个，第二种是匹配多个 当match的时候可以匹配0个或者多个 当不match的时候只能尝试匹配0个 eg:
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.') {
                        dp[i + 1][j + 1] = (dp[i + 1][j - 1] || dp[i][j + 1]);
                    }else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        boolean result = new RegularExpression().isMatch("aab", "a*b");
        System.out.println(result);
    }
}
