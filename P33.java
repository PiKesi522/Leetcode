public class P33 {
    public int search(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        if(rightIndex == -1){
            return -1;
        }else if(rightIndex == 0){
            return nums[0] == target ? 0: -1;
        }
        while(leftIndex <= rightIndex){
            int midIndex = (leftIndex + rightIndex) / 2;
            if(nums[leftIndex] == target){
                return leftIndex;
            } else if (nums[rightIndex] == target) {
                return rightIndex;
            } else if (nums[midIndex] == target){
                return midIndex;
            }

            if(nums[0] < nums[midIndex]){
                // 左边有序
                if(nums[0] <= target && target < nums[midIndex]){
                    rightIndex = midIndex - 1;
                }else {
                    leftIndex = midIndex + 1;
                }
            }else{
                // 右边有序
                if(nums[midIndex] < target && target <= nums[nums.length - 1]){
                    leftIndex = midIndex + 1;
                }else {
                    rightIndex = midIndex - 1;
                }
            }
        }
        return -1;
    }
}
