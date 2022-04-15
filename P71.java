import java.util.*;

public class P71 {
        public String simplifyPath(String path) {
            String[] dir = path.split("/");
            Deque<String> stack = new ArrayDeque<>();
            final int len = path.length();
            for (String s : dir){
                if("..".equals(s)){
                    if(!stack.isEmpty()){
                        stack.pollLast();
                    }
                }else if(!".".equals(s) && s.length() > 0){
                    stack.offerLast(s);
                }
            }
            if(stack.isEmpty()) return "/";
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()){
                sb.append('/');
                sb.append(stack.pollFirst());
            }
            return sb.toString();
        }
}
