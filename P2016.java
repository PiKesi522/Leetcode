public class P2016 {
    public int maximumDifference(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[nums.length-1];
        int dpMax = -1;
        dp[nums.length - 1] = -1;
        for(int i  = nums.length - 2; i >= 0; i--){
            if(nums[i] >= max){
                dp[i] = -1;
                max = nums[i];
            }else{
                dp[i] = max - nums[i];
            }

            if(dp[i] > dpMax){
                dpMax = dp[i];
            }
        }
        return dpMax;
    }
}
