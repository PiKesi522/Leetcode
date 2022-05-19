import java.util.Arrays;

public class P462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        int mid = nums[len / 2];
        for(int i = 0; i < len / 2; i++){
            ans += Math.abs(nums[i] - mid) + Math.abs(nums[len - i] - mid);
        }
        return ans;
    }
}
