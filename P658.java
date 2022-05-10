import java.util.*;
import java.util.stream.Collectors;

public class P658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        final int len = ret.size();
        if(x <= ret.get(0)){
            return ret.subList(0, k);
        }else if(x >= ret.get(len - 1)){
            return ret.subList(len - k, len);
        }

        int index = Collections.binarySearch(ret, x);
        if(index < 0){
            index = -index - 1;
        }
        System.out.println(index);
        int low = index - 1, high = index;
        while(high - low - 1 < k){
            if(low < 0){
                high++;
                continue;
            }
            if(high > len - 1){
                low--;
                continue;
            }
            if(Math.abs(ret.get(high) - x) < Math.abs(ret.get(low) - x)){
                high++;
                System.out.println("high: " + high);
            }else{
                low--;
                System.out.println("low: " + low);
            }
        }
        return ret.subList(low + 1, high);
    }
}
