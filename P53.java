public class P53 {
    public int maxSubArray(int[] nums) {
        final int Len = nums.length;
        if(Len == 0){
            return 0;
        }

        int[] dp = new int[Len];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i < Len; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
