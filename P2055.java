public class P2055 {
    public static void main(String[] args) {
        int[][] temp = {{2,5},{5,9}};
        platesBetweenCandles("**|**|***|", temp);
    }
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = checkPlate(s.substring(queries[i][0], queries[i][1] + 1));
        }
        return ans;
    }

    public static int checkPlate(String s){
        int firstCandle = s.indexOf('|');
        int lastCandle = s.lastIndexOf('|');
        if(firstCandle == -1 || lastCandle == firstCandle){
            return 0;
        }
        int cnt = 0;
        for(int i = firstCandle + 1; i < lastCandle; i++){
            if(s.charAt(i) == '*'){
                cnt += 1;
            }
        }
        return cnt;
    }
}
