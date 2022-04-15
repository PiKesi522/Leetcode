public class P72 {
    public int minDistance(String word1, String word2) {
        final int Len1 = word1.length(), Len2 = word2.length();
        int[][] dp = new int[Len1+1][Len2+1];
        dp[0][0] = 0;
        for(int i = 1; i <= Len2; i++) dp[0][i] = i;
        for(int i = 1; i <= Len1; i++) dp[i][0] = i;
        for(int i = 1; i <= Len1; i++){
            for (int j = 1; j <= Len2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }
        return dp[Len1][Len2];
    }
}
