public class P806 {
    public int[] numberOfLines(int[] widths, String s) {
        int[] ans = {1, 0};
        final int MAX = 100;
        int totalLength = 0;
        for(int i = 0; i < s.length(); i++) {
            totalLength += widths[s.charAt(i) - 'a'];
            if(totalLength > 100){
                totalLength = 0;
                ans[0] += 1;
                i -= 1;
            }
        }
        if(totalLength > 0){
            ans[0] += 1;
            ans[1] = totalLength;
        }
        return ans;
    }
}
