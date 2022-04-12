public class P11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0, ans = 0;
        while(left < right){
            if(height[left] < height[right]){
                ans = (right - left) * height[left++];
            }else{
                ans = (right - left) * height[right--];
            }
            max = Math.max(max, ans);
        }
        return max;
    }
}
