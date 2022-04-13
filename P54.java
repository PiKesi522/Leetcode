import java.util.*;
public class P54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, right  = matrix[0].length - 1;
        int top  = 0, bottom = matrix.length - 1;
        while(left < right && top < bottom){
            int i;
            for(i = left; i < right; i++){
                ans.add(matrix[top][i]);
            }
            for(i = top; i < bottom; i++){
                ans.add(matrix[i][right]);
            }
            for(i = right; i > left; i--){
                ans.add(matrix[bottom][i]);
            }
            for(i = bottom; i > top; i--){
                ans.add(matrix[i][left]);
            }

            left += 1;
            right -= 1;
            top += 1;
            bottom -= 1;
        }
        if(left == right){
            for(int i = top; i <= bottom; i++){
                ans.add(matrix[i][left]);
            }
        }else if(top == bottom){
            for(int i = left; i <= right; i++){
                ans.add(matrix[top][i]);
            }
        }
        return ans;
    }
}
