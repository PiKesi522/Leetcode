import java.util.*;

public class P85 {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[] numMartix = new int[col];
        for(int i = 0; i < col; i++){
            numMartix[i] = 0;
        }
        int max = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '0'){
                    numMartix[j] = 0;
                }else{
                    numMartix[j] += 1;
                }
            }
            max = Math.max(max, largestRectangleArea(numMartix));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] leftEdge = new int[len];
        int[] rightEdge = new int[len];
        Deque<Integer> monoStack = new ArrayDeque<>();

        for(int i = 0; i < len; i++){
            // 从左到右找左边界
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]){
                monoStack.pop();
            }
            leftEdge[i] = monoStack.isEmpty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }

        monoStack.clear();
        for(int i = len - 1; i >= 0; i--){
            // 从右到左找右边界
            while (!monoStack.isEmpty() && heights[monoStack.peek()] >= heights[i]){
                monoStack.pop();
            }
            rightEdge[i] = monoStack.isEmpty() ? len : monoStack.peek();
            monoStack.push(i);
        }

        int max = 0;
        for(int i = 0; i < len; i++){
            max = Math.max(max, heights[i] * (rightEdge[i] - leftEdge[i] - 1));
        }
        return max;
    }
}
