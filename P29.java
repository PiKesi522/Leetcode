public class P29 {
    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }else if(divisor == 1){
            return dividend;
        }else if(divisor == -1){
            if(dividend == Integer.MIN_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return -dividend;
            }
        }
        int a = dividend;
        int b = divisor;
        int sign = 1;
        if(a < 0 && b < 0){
            a = -a;
            b = -b;
        } else if (a < 0 && b > 0) {
            a = -a;
            sign = -1;
        } else if ( a > 0 && b < 0){
            b = -b;
            sign = -1;
        }

        long res = div(a,b);
        if(sign == 1){
            return (int)(res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res);
        }else{
            return -(int)res;
        }
    }

    public long div(int a, int b){
        if(a < b){
            return 0;
        }

        int cnt = 1;
        int tempB = b;
        while(2 * tempB< a){
            tempB *= 2;
            cnt *= 2;
        }
        return cnt + div(a-tempB, b);
    }
}
