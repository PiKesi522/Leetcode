public class P5 {
    public static void main(String[] args) {
//        longestPalindrome("babad");
    }
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String ans = new String();
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j >= 0; j--){
                if ((s.charAt(i) == s.charAt(j)) && (i - j < 2 || dp[i-1][j+1])){
                    dp[i][j] = true;
                }

                if (dp[i][j] && (i - j + 1 > ans.length())){
                    ans = s.substring(j, i + 1);
                }
            }
        }
        return ans;
    }
}
