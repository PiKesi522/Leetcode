import java.util.LinkedList;
import java.util.Queue;

public class P258 {
    public int addDigits(int num) {
        Queue<Integer> buffer = new LinkedList<>();
        while(num != 0){
            buffer.add(num % 10);
            num /= 10;
        }
        int ans = 0;
        while(!buffer.isEmpty()){
            ans += buffer.remove();
            if(ans >= 10){
                ans -= 10;
                buffer.add(1);
            }
        }
        return ans;
    }
}
