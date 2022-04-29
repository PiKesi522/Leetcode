import java.util.HashMap;

public class P76 {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, count = 0, startIndex = 0, len = Integer.MAX_VALUE;
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for(char c : t.toCharArray())
            need.put(c, need.getOrDefault(c, 0) + 1);
        while(right < s.length()){
            char c = s.charAt(right);
            right ++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(window.get(c))){
                    count ++;
                }
            }
            while(count == need.size()){
                if(right - left < len){
                    len = right - left;
                    startIndex = left;
                }
                char cc = s.charAt(left);
                left++;
                if(need.containsKey(cc)){
                    if(need.get(cc).equals(window.get(cc))){
                        count--;
                    }
                    window.put(cc, window.get(cc) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + len);
    }
}
