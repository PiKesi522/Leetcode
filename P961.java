import java.util.*;

public class P961 {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for(int num : nums){
            if(!ans.add(num)){
                return num;
            }
        }
        return -1;
    }
}
