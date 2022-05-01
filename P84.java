import java.util.*;

public class P84 {
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
