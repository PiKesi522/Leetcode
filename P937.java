import java.util.*;

public class P937 {
    public String[] reorderLogFiles(String[] logs) {
        final int len = logs.length;
        Deque<String> log = new ArrayDeque<>();
        int i = 0;
        for(String str : logs){
            if (str.substring(0, 3).equals("dig")) {
                log.addLast(str);
            } else {
                log.addFirst(str);
                i += 1;
            }
        }
        String[] let = new String[i];
        for(int j = 0; j < i; j++){
            let[j] = log.pollFirst();
        }

        Arrays.sort(let, new Comparator<String>(){
            public int compare(String A, String B){
                String[] Ac = A.substring(5).split(" ");
                String[] Bc = B.substring(5).split(" ");
                final int la = Ac.length, lb = Bc.length;
                int i = 0;
                while(i < la && i < lb){
                    if(Ac[i].equals(Bc[i])){
                        i ++;
                    }else{
                        return Ac[i].compareTo(Bc[i]);
                    }
                }
                if(la == lb){
                    return Ac[0].compareTo(Bc[0]);
                }else{
                    return la - lb;
                }
            }
        });

        String[] ans = new String[len];
        int j = 0;
        for(j = 0; j < i; j++){
            ans[j] = let[j];
        }
        for(String str : log){
            ans[j++] = str;
        }
        return ans;
    }
}
