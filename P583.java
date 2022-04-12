public class P583 {
    public int minDistance(String word1, String word2) {
        int size1 = word1.length(), size2 = word2.length();
        int[][] dp = new int[size1+1][size2+1];
        for (int i = 0; i < size1 + 1; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i < size2 + 1; i++) {
            dp[0][i] = i;
        }

        for(int j = 1; j < size2 + 1; j++){
            for(int i = 1; i < size1 + 1; i++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
                }
            }
        }

        return dp[size1][size2];
    }
}
