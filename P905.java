public class P905 {
    public int[] sortArrayByParity(int[] nums) {
        final int len = nums.length;
        int start = 0, end = len - 1, cache;
        while (start < end){
            if(nums[start] % 2 == 1){
                start ++;
            }else if(nums[end] % 2 == 0){
                end --;
            }else{
                cache = nums[start];
                nums[start++] = nums[end];
                nums[end++] = cache;
            }
        }
        return nums;
    }
}
