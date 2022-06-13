import java.util.Arrays;
import java.util.stream.Stream;

public class P1051 {
    public int heightChecker(int[] heights) {
        int ans = 0;
        int[] order = new int[heights.length];
        System.arraycopy(heights, 0, order, 0, heights.length);
        Arrays.sort(order);
        for(int i = 0; i < heights.length; i++){
            if(order[i] != heights[i]){
                ans++;
            }
        }
        return ans;
    }
}
