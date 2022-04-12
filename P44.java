public class P44 {
    public boolean isMatch(String s, String p) {
        final int sLen = s.length(), pLen = p.length();
        int i, j;
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for(j = 1; j <= pLen; j++){
            if(p.charAt(j - 1) == '*'){
                dp[0][j] = true;
            }else{
                break;
            }
        }

        for(i = 1; i <= sLen; i++){
            for(j = 1; j <= pLen; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[sLen][pLen];
    }
}
