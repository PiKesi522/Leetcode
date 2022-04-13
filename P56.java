import java.util.*;

public class P56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int L = intervals[i][0], R = intervals[i][1];
            if(ans.get(ans.size() - 1)[1] < L){
                // 如果前一个区间的右边界比此区间的左边界小，则前一个边界已经合并完成
                ans.add(intervals[i]);
            }else{
                // 如果前一个区间的右边界比此区间的左边界小，则考虑扩大范围
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], R);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
