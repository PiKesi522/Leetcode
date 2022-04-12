public class P35 {
    public int searchInsert(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        int midIndex = 0;
        while(leftIndex <= rightIndex){
            midIndex = (leftIndex + rightIndex) / 2;
            if(target == nums[midIndex]){
                return midIndex;
            }else if(target < nums[midIndex]){
                rightIndex = midIndex - 1;
            }else{
                leftIndex = midIndex + 1;
            }
        }
        return leftIndex;
    }
}
