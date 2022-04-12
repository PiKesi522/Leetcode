public class P34 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);
        if(leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target){
            return new int[]{leftIndex,rightIndex};
        }
        return new int[]{-1,-1};
    }

    public int binarySearch(int[] nums, int target, boolean lower){
        int leftIndex = 0, rightIndex = nums.length - 1;
        int mid = (leftIndex + rightIndex) / 2;
        int ans = nums.length;
        while(leftIndex <= rightIndex){
            mid = (leftIndex + rightIndex) / 2 ;
            if((nums[mid] > target) || (lower && nums[mid] >= target)){
                rightIndex = mid - 1;
                ans = mid;
            }else {
                leftIndex = mid + 1;
            }
        }
        return ans;
    }
}
