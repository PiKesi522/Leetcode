import java.util.*;

public class P43 {
    public static void main(String[] args) {
        multiply("123","456");
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }else if(num1.equals("1")){
            return num2;
        }else if(num2.equals("1")){
            return num1;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = num2.length() - 1; i >= 0; i--){
            int num = num2.charAt(i) - '0';
            if(num == 0)
                continue;
            List<Integer> sb = new ArrayList<>();
            for(int j = i; j < num2.length() - 1; j++)
                sb.add(0);
            add(ans, sb, num1, num);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = ans.size() - 1 ; i >= 0; i--){
            sb.append(ans.get(i));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void add(List<Integer> ans, List<Integer> sb, String num1, int num2){
        int sum = 0, carry = 0;
        for(int i = 0; i < num1.length(); i++){
            int num = num1.charAt(i) - '0';
            sum = (num * num2 + carry) % 10;
            carry = (num * num2 + carry) / 10;
            sb.add(sum);
        }
        if(carry > 0){
            sb.add(carry);
            carry = 0;
        }

        int ptr = 0;
        for(; ptr < ans.size(); ptr++){
            sum = (sb.get(ptr) + ans.get(ptr) + carry) % 10;
            carry = (sb.get(ptr) + ans.get(ptr) + carry) / 10;
            ans.set(ptr, sum);
        }
        for (; ptr < sb.size(); ptr++){
            sum = (sb.get(ptr) + carry) % 10;
            carry = (sb.get(ptr) + carry) / 10;
            ans.add(sum);
        }
        if(carry > 0){
            ans.add(carry);
        }
    }
}
