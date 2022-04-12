public class P14 {
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        longestCommonPrefix(str);
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs == null){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            prefix = longestCommonPrefix(prefix, strs[i]);
            System.out.println(prefix);
            if(prefix.length() == 0)
                break;
        }
        return prefix;
    }

    public static String longestCommonPrefix(String s1, String s2){
        int len = Math.min(s1.length(), s2.length()), i = 0;
        for(; i < len; i++){
            if(s1.charAt(i) != s2.charAt(i))
                break;
        }
        return s1.substring(0,i);
    }
}
