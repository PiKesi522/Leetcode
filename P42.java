public class P42 {
    public int trap(int[] height){
        int leftPtr = 0, rightPtr = height.length - 1;
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        while(leftPtr < rightPtr){
            if(height[leftPtr] < height[rightPtr]){
                if(height[leftPtr] > leftMax){
                    leftMax = height[leftPtr];
                }else{
                    ans += leftMax - height[leftPtr];
                }
                leftPtr ++;
            }else {
                if(height[rightPtr] > rightMax){
                    rightMax = height[rightPtr];
                }else{
                    ans += rightMax - height[rightPtr];
                }
                rightPtr --;
            }
        }
        return ans;
    }
}
