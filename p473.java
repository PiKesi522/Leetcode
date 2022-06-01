import java.util.Arrays;

public class p473 {
    public boolean makesquare(int[] matchsticks) {
        int len = Arrays.stream(matchsticks).sum();
        if(len % 4 != 0){
            return false;
        }else{
            len = len / 4;
        }
        int size = matchsticks.length;
        int[] dp = new int[1 << size];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int s = 0; s < (1 << size); s++){
            for (int k = 0; k < size; k++){
                if((s & (1 << k)) == 0){
                    continue;
                }

                int s1 = s & ~(1 << k);
                if(dp[s1] >= 0 && dp[s1] + matchsticks[k] <= len){
                    dp[s] = (dp[s1] + matchsticks[k]) % len;
                    break;
                }
            }
        }
    return dp[(1 << size) - 1] == 0;
    }
}
