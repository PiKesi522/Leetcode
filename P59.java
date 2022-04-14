public class P59 {
    public int[][] generateMatrix(int n) {
        if(n == 0) return null;
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        final int MAX = n * n;
        int num = 1, i;
        while(num <= MAX){
            for(i = left; i <= right; i++){
                ans[top][i] = num++;
            }
            top ++;
            for (i = top; i <= bottom; i++){
                ans[i][right] = num++;
            }
            right --;
            for (i = right; i >= left; i--){
                ans[bottom][i] = num++;
            }
            bottom --;
            for (i = bottom; i >= top; i--){
                ans[i][left] = num++;
            }
            left ++;
        }
        return ans;
    }
}
