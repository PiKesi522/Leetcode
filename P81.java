import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P81 {
    public boolean search(int[] nums, int target) {
        int min = 0, max = nums.length - 1, mid;
        if(nums.length == 0)  return false;
        if(nums.length == 1)  return nums[0] == target;
        while(min < max){
            mid = (min + max) / 2;
            if(nums[mid] == target)  return true;

            if(nums[min] == nums[mid] && nums[mid] == nums[max]){
                min += 1;
                max -= 1;
            }else if(nums[min] <= nums[mid]){
                if(nums[min] <= target && target < nums[mid]){
                    max = mid - 1;
                }else{
                    min = mid + 1;
                }
            }else{
                if(nums[mid] < target && target <= nums[max]){
                    min = mid + 1;
                }else{
                    max = mid - 1;
                }
            }
        }
        return false;
    }
}
