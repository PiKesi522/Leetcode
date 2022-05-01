import java.util.Arrays;
import java.util.Comparator;

public class P522 {
    public int findLUSlength(String[] strs){
        final int len = strs.length;
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });
        for (int i = 0; i < len; i++){
            System.out.print(strs[i] + ", ");
        }
        System.out.println();
        for(int i = 0; i < len; i++){
            int j;
            for (j = 0; j < len; j++){
                if(i == j){
                    continue;
                }
                if(isSubSequence(strs[i], strs[j])){
                    break;
                }
            }
            if(j == len){
                return strs[i].length();
            }
        }
        return -1;
    }

    public boolean isSubSequence(String a, String b){
        System.out.println(a);
        System.out.println(b);
        int i, j;
        for(i = 0, j = 0; i < b.length() && j < a.length(); i ++){
            if (a.charAt(j) == b.charAt(i)){
                j++;
            }
        }
        System.out.println(j == b.length());
        System.out.println("==============");
        return j == a.length();
    }
}
