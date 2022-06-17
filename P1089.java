public class P1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int fast = 0, slow = -1;
        // 正向查询
        while(fast < n){
            slow++;
            if(arr[slow] == 0){
                fast++;
            }
            fast++;
        }

        if(fast > n){
            fast -= 2;
            arr[fast--] = 0;
            slow--;
        }else{
            fast--;
        }

        // 反向更新
        while(fast >= 0){
            arr[fast--] = arr[slow];
            if(arr[slow] == 0){
                arr[fast--] = 0;
            }
            slow--;
        }
    }
}
