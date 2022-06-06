import java.util.*;

public class P732 {
}

class MyCalendarThree {
    private Map<Integer, Integer> array;
    public MyCalendarThree() {
        this.array = new TreeMap<>((x,y) -> y - x);
    }

    public int book(int start, int end) {
        array.put(start, array.getOrDefault(start, 0) + 1);
        array.put(end, array.getOrDefault(end, 0) - 1);

        int ans = 0;
        int temp = 0;
        for(Integer key : array.keySet()){
            temp = temp - array.get(key);
            ans = Math.max(temp, ans);
        }
        return ans;
    }
}