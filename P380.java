
import java.util.*;

public class P380 {
    class RandomizedSet {
        List<Integer> nums;
        Random random;
        Map<Integer, Integer> map;

        //初始化 RandomizedSet 对象
        public RandomizedSet() {
            this.nums = new ArrayList<>();
            this.map = new HashMap<>();
            this.random = new Random();
        }

        //当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false
        public boolean insert(int val) {
            if(map.containsKey(val)) return false;

            nums.add(val);
            map.put(val, nums.size());
            return true;
        }

        //当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false
        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;

            int index = map.get(val);
            int last = map.get(nums.size() - 1);
            nums.set(index, last);
            map.put(last, index);
            nums.remove(nums.size() - 1);
            map.remove(val);
            return true;
        }

        //随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回
        public int getRandom() {
            int randomIndex = random.nextInt(nums.size());
            return nums.get(randomIndex);
        }
    }
}
