public class P91 {
    public int numDecodings(String s) {
        final int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        s = " " + s;
        char[] cs = s.toCharArray();
        int onebit, twobit;
        for(int i = 1; i <= len; i++){
            onebit = cs[i] - '0';
            twobit = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if(1 <= onebit && onebit <= 9){
                dp[i] += dp[i-1];
            }
            if(10 <= twobit && twobit <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }
}
