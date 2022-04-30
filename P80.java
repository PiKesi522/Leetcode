public class P80 {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
//            if (u < k || nums[u - k] != x) nums[u++] = x;
            if(u < k){
                u++;
            }else if(nums[u - k] != x){
                nums[u] = x;
                u++;
            }
        }
        return u;
    }
}
