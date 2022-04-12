public class P38 {
    public static void main(String[] args) {
        countAndSay(10);
    }
    public static String countAndSay(int n) {
        String[] dp = new String[30];
        dp[0] = "1";
        dp[1] = "11";
        for(int i = 2; i < n; i++) {
            getDP(i, dp);
            System.out.println(dp[i]);
        }
        return dp[n - 1];
    }

    public static void getDP(int n, String[] dp){
        String pre = dp[n - 1];
        StringBuilder sb = new StringBuilder();
        int leftPtr = 1;
        int cnt = 1;
        while (leftPtr < pre.length()){
            if(pre.charAt(leftPtr - 1) == pre.charAt(leftPtr)){
                cnt ++;
            }else{
                sb.append((char)(cnt + '0'));
                sb.append((char)(pre.charAt(leftPtr - 1)));
                cnt = 1;
            }
            leftPtr ++;
        }

        sb.append((char)(cnt + '0'));
        sb.append((char)(pre.charAt(leftPtr - 1)));

        dp[n] = sb.toString();
    }
}
