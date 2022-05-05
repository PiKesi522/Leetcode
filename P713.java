import java.util.*;

public class P713 {
    int end;
    int cnt = 0;
    List<Integer> path;

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        this.end = nums.length - 1;
        for(; end >= 0; end--){
            if(nums[end] <= k){
                break;
            }
        }
        if(end == -1){
            return 0;
        }
        this.path = new ArrayList<>();
        dfs(nums, 0, k);
        return cnt;
    }

    public void dfs(int[] nums, int startIndex, int threshold){
        if(!path.isEmpty() && calcu(path, threshold)){
            this.cnt += 1;
        }
        for(int i = startIndex; i <= end; i++){
            path.add(nums[i]);
            dfs(nums, i + 1, threshold);
            path.remove(path.size() - 1);
        }
    }

    public boolean calcu(List<Integer> path, int threshold){
        int product = 1;
        for(int i : path){
            product *= i;
            if(product >= threshold){
                return false;
            }
        }
        for(int i : path){
            System.out.print(i + ",");
        }
        System.out.println();
        return true;
    }
}
