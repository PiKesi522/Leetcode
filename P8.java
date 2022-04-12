public class P8 {
    public static void main(String[] args) {
        myAtoi("words and 987");
    }
    public static int myAtoi(String s) {
        boolean moreZero = true, moreWord = true;
        int negetive = 1;
        int ans = 0, res = 0, loc = 0;
        while(loc < s.length()){
            char ch = s.charAt(loc++);

            if(ch == '0' && moreZero){
                System.out.println("if1");
                continue;
            }
            else if('0' <= ch && ch <= '9'){
                System.out.println("if2");
                moreZero = false;
                moreWord = false;
            }
            else if(ch == '-' && moreWord){
                System.out.println("if3");
                negetive = -1;
                continue;
            }
            else if(moreWord){
                System.out.println("if4");
                continue;
            }
            else
                return ans;

            res = ch - '0';

            if(ans < Integer.MIN_VALUE / 10)
                return Integer.MIN_VALUE;
            else if(ans > Integer.MAX_VALUE / 10)
                return Integer.MAX_VALUE;

            ans = ans * 10 + negetive * res;
            System.out.println(ans);
        }
        return ans;
    }
}
