import java.util.*;

public class P50 {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }else if(n == 1 || x == 1.0){
            return x;
        }
        // 位数从左到右递增
        // 77 -> 1 0 1 1 0 0 1
        //       0 1 2 3 4 5 6
        List<Integer> bina = new ArrayList<>();
        int tempN = Math.abs(n);
        while(tempN > 0){
            bina.add(tempN % 2);
            tempN = tempN >> 1;
        }

        double ans = 1.0;
        List<Double> ref = new ArrayList<>();
        ref.add(x);
        for(int i = 1; i < bina.size(); i++){
            double temp = ref.get(i-1) * ref.get(i-1);
            if(bina.get(i) == 1){
                ans *= temp;
            }
            ref.add(temp);
        }
        if(bina.get(0) == 1) ans *= x;
        if(n < 0) return (1 / ans);
        return ans;
    }
}
