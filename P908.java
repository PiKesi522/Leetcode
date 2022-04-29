import java.util.Arrays;

public class P908 {
    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        return Math.max(max - min - 2 * k, 0);
    }
}
