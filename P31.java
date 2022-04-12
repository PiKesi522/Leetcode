import java.util.Arrays;

public class P31 {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2){
            return;
        }else if(nums.length == 2){
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        int lastIndex = nums.length - 1;
        int tarIndex = lastIndex - 1;
        for(;tarIndex > 0; tarIndex--){
            if(nums[tarIndex] < nums[tarIndex + 1]){
                break;
            }
        }
        if(tarIndex == 0){
            Arrays.sort(nums);
            return;
        }

        if(tarIndex == lastIndex - 1){
            int temp = nums[tarIndex];
            nums[tarIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
            return;
        }

        int largeNum = -1;
        for(int i = tarIndex + 2; i < lastIndex; i++){
            if(nums[i] > nums[tarIndex]){
                largeNum = i;
                break;
            }
        }

        int temp;

        if(largeNum != -1){
            temp = nums[tarIndex];
            nums[tarIndex] = nums[largeNum];
            nums[largeNum] = temp;
        }

        for(int i = tarIndex + 1; i < lastIndex; i++, lastIndex--){
            temp = nums[i];
            nums[i] = nums[lastIndex];
            nums[lastIndex] = temp;
        }
    }
}
