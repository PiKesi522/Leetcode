import java.util.*;

public class P890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int[] map = new int[26];
        int[] vis = new int[26];
        for(String word : words){
            Arrays.fill(map, -1);
            Arrays.fill(vis, 0);
            boolean ok = true;
            for(int i = 0; i < word.length() && ok; i++){
                int c1 = word.charAt(i) - 'a';
                int c2 = pattern.charAt(i) - 'a';
                if(map[c1] == -1 && vis[c2] == 0){
                    map[c1] = c2;
                    vis[c2] = 1;
                }else if(map[c1] != c2){
                    ok = false;
                }
            }
            if(ok) ans.add(word);
        }
        return ans;
    }
}
