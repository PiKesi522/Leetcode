public class P75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, pointer = 0, temp;
        while(pointer <= right){
            if(nums[pointer] == 0 && pointer > left){
                nums[pointer] = nums[left];
                nums[left++] = 0;
            }else if(nums[pointer] == 2){
                nums[pointer] = nums[right];
                nums[right--] = 2;
            }else{
                pointer ++;
            }
        }
        return;
    }
}
