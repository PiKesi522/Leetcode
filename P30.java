import java.util.*;
public class P30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() == 0 || s == null) return ans;
        if(words.length == 0 || words == null) return ans;
        int wordSize = words.length;
        int charSize = words[0].length();
        int totalSize = wordSize * charSize;
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(int i = 0; i < s.length() - totalSize + 1; i++){
            String sub = s.substring(i, i + totalSize);
            HashMap<String, Integer> temp = new HashMap<>();
            for(int j = 0; j < totalSize; j += charSize){
                String subsub = sub.substring(j, j + charSize);
                temp.put(subsub, temp.getOrDefault(subsub, 0) + 1);
            }
            if(map.equals(temp)){
                ans.add(i);
            }
        }
        return ans;
    }
}
