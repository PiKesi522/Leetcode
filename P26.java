public class P26 {
    public int removeDuplicates(int[] nums) {
        int lastIndex = nums.length - 1;
        int fast = 0, slow = fast;
        for(int i = 1; i <= lastIndex; i++){
            if(nums[i] != nums[i - 1]){
                if(fast != slow){
                    for(int j = fast; j <= lastIndex; j++){
                        nums[j - (fast - slow)] = nums[j];
                    }
                    // for(int k = 0; k < nums.length; k++){
                    //     System.out.print(nums[k]);
                    // }
                }
                lastIndex -= (fast - slow);
                fast = ++slow;
                i = fast;
                // System.out.println("i:" + i + ",fast:" + fast + ",slow:" + slow + ",last:" + lastIndex);
            }else{
                fast++;
                // System.out.println("i:" + i + ",fast:" + fast + ",slow:" + slow + ",last:" + lastIndex);
            }
        }

        if(fast != slow){
            lastIndex = slow;
        }

        // for(int i = 0; i < nums.length; i++){
        //     System.out.print(nums[i]);
        // }
        // System.out.println();
        return lastIndex + 1;
    }
}
