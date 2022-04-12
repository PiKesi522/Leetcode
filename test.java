import java.util.HashMap;

public class test {
    public static void main(String[] args) {
            int rev = 0, x = -123;
            while( x != 0){
                if(rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10){
                    return;
                }
                int digit = x % 10;
                x /= 10;
                System.out.println("x=" + x);
                rev = rev * 10 + digit;
                System.out.println("rev=" + rev);
            }
            System.out.println(rev);
            return;
    }
}
