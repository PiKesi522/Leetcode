import java.util.Arrays;

public class P41 {
    public int firstMissingPositive(int[] nums){
        final int len = nums.length;
        for(int i = 0; i < len; i++){
            while((0 < nums[i] && nums[i] <= len) && (nums[nums[i] - 1] != nums[i])){
                swap(nums, nums[i] - 1, i);
            }
        }

        for (int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return (i + 1);
            }
        }
        return len;
    }

    public void swap(int[] nums, int indexA, int indexB){
        int temp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = temp;
    }
}
