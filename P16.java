import java.util.Arrays;

public class P16 {
    public static void main(String[] args) {
        int[] s = {1,2,5,10,11};
        int ans = threeSumClosest(s,12);
        System.out.println("ans = " + ans);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[nums.length-1];
        for(int fixed = 0; fixed < nums.length - 2; fixed++){

            if(fixed > 0 && nums[fixed] == nums[fixed-1]){
                continue;
            }

            int left = fixed + 1, right = nums.length - 1;
            int temp = 0;
            while(left < right){
                temp = nums[fixed] + nums[left] + nums[right];
                if(temp < target){
                    int t = left + 1;
                    while(t < right && nums[t] == nums[left]){
                        t ++;
                    }
                    left = t;
                }else if(temp > target){
                    int t = right - 1;
                    while(left < t && nums[t] == nums[right]){
                        t --;
                    }
                    right = t;
                }else{
                    return target;
                }
                if(Math.abs(temp - target) < Math.abs(ans - target)){
                    ans = temp;
                }
            }
        }
        return ans;
    }
}
