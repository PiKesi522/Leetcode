import java.util.*;

public class P433 {
    public static void main(String[] args) {
        String start ="AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(start, end, bank));
        return;
    }

    public static int minMutation(String start, String end, String[] bank) {
        Set<String> cnt = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] keys = {'A', 'C', 'G', 'T'};
        for(String str : bank)
            cnt.add(end);
        if(!cnt.contains(end)){
            return -1;
        }
        if(start.equals(end))
            return 0;
        Deque<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                String cur = queue.pollFirst();
                for(int j = 0; j < 8; j++){
                    for(int k = 0; k < 4; k++){
                        if(keys[k] != cur.charAt(j)){
                            StringBuffer sb = new StringBuffer(cur);
                            sb.setCharAt(j, keys[k]);
                            String temp = sb.toString();
                            if(!visited.contains(temp) && cnt.contains(temp)){
                                if(temp.equals(end))
                                    return step;
                                queue.offer(temp);
                                visited.add(temp);
                            }
                        }
                    }
                }
            }
            step += 1;
        }
        return -1;
    }
}
