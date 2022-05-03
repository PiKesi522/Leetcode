public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer1 = m - 1, pointer2 = n - 1;
        int tail = m + n - 1;
        while(pointer1 >= 0 && pointer2 >= 0){
            nums1[tail--] = nums1[pointer1] < nums2[pointer2] ? nums2[pointer2--] : nums1[pointer1--];
        }
        if(pointer1 == 0){
            for(; tail >= 0; tail--){
                nums1[tail--] = nums2[pointer2--];
            }
        }
        return;
    }
}
