import java.util.Arrays;

public class P719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        int mid, cnt;
        while(left <= right){
            mid = left + (right - left) / 2;
            cnt = 0;
            for(int i = 0, j = 0; j < n; j++){
                while (nums[j] - nums[i] > mid){
                    i++;
                }
                cnt += j - i;
            }

            if(cnt >= k){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
