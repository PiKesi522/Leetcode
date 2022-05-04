import java.util.*;

public class P32 {
    public int longestValidParentheses(String s) {
        char[] cs = s.toCharArray();
        final int len = cs.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] mark = new int[len];
        int pointer = 0;
        while (pointer < len){
            char ch = cs[pointer];
            if(ch == '('){
                stack.push(pointer);
            }else{
                if(stack.isEmpty()){
                    mark[pointer] = 1;
                }else{
                    stack.pop();
                }
            }
            pointer += 1;
        }

        while (!stack.isEmpty()){
            mark[stack.pop()] = 1;
        }
        for(int i : mark){
            System.out.print(i);
        }
        int res = 0, ans = 0;
        for(int i = 0; i < len; i++){
            if(mark[i] == 1){
                res = 0;
                continue;
            }

            res += 1;
            ans = Math.max(ans, res);
        }
        return ans;
    }
}
