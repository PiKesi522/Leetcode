import java.util.*;
public class P93 {
    static int totalLength = 0;
    public static void main(String[] args) {
        List<String> ans = restoreIpAddresses("25525511135");
        return;
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        if(s.length() > 12 || s.length() < 4){
            return ans;
        }
        totalLength = s.length();
        dfs(s, 0, ans, path);
        return ans;
    }

    public static void dfs(String subString, int layer, List<String> ans, Deque<String> path){
        if((4 - layer) * 3 < subString.length()){
            // IP地址一定分配不完了
            return;
        }

        if(layer == 4){
            // IP分配完成
//            System.out.println(path);
            ans.add(myToString(path));
        }

        for(int i = 1; i <= 3; i++){
            if(subString.length() - i < 0){
                // 即将分配的长度超过了原有的长度
                return;
            }
            if(subString.charAt(0) == '0' && i > 1){
                // 分配出0x，0xx的结果是不可接受的
                return;
            }
            if(Integer.parseInt(subString.substring(0,i)) > 255){
                // 分配出的大小大于255不可接受
                return;
            }

            path.addLast(subString.substring(0,i));
            String temp = subString.substring(i);
            dfs(temp, layer + 1, ans, path);
            path.removeLast();
        }
    }

    public static String myToString(Deque<String> path){
        StringBuilder sb = new StringBuilder();
        Deque<String> res = new ArrayDeque<>(path);
        for(int i = 0; i < 3; i++){
            sb.append(res.pollFirst());
            sb.append(".");
        }
        sb.append(res.pollFirst());
        return sb.toString();
    }
}
