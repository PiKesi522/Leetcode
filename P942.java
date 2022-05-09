public class P942 {
    public int[] diStringMatch(String s) {
        final int len = s.length();
        char[] cs = s.toCharArray();
        int[] ans = new int[len + 1];
        ans[len] = 0;
        int min = 0, max = 0;
        for(int i = len - 1; i >= 0; i--){
            if(cs[i] == 'I'){
                ans[i] = --min;
            }else{
                ans[i] = ++max;
            }
        }
        for(int i = 0; i <= len; i++){
            ans[i] -= min;
        }
        return ans;
    }
}
