public class P45 {
    public int jump(int[] nums) {
        int max_far = 0;// 目前能跳到的最远位置
        int step = 0;   // 跳跃次数
        int end = 0;    // 上次跳跃可达范围右边界（下次的最右起跳点）
        for (int i = 0; i < nums.length - 1; i++){
            // 通过不断循环，来扩大右边界。如果下一格跳跃没有扩展右边界，则视作没有跳跃，反之则视作跳跃过了一次
            max_far = Math.max(max_far, i + nums[i]);
            // 到达上次跳跃能到达的右边界了
            if (i == end){
                end = max_far;  // 目前能跳到的最远位置变成了下次起跳位置的有边界
                step++;         // 进入下一次跳跃
            }
        }
        return step;
    }
}
