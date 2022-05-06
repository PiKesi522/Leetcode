import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class P933 {

}

public class RecentCounter {
    Deque<Integer> queue;
    public RecentCounter() {
        this.queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        this.queue.addLast(t);
        while(!queue.isEmpty()){
            if(queue.getFirst() < t - 3000){
                queue.pollFirst();
            }
            else{
                break;
            }
        }
        return queue.size();
    }
}
