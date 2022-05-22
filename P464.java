import java.util.*;

public class P464 {
    Map<Integer, Boolean> cache = new HashMap<>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger + 1) * (maxChoosableInteger) / 2 < desiredTotal) {
            return false;
        }
        return dfs(maxChoosableInteger, 0, desiredTotal, 0);
    }

    public boolean dfs(int maxChoosableInteger, int usedNumber, int desiredTotal, int currentTotal) {
        if (!cache.containsKey(usedNumber)) {
            boolean res = false;
            for (int i = 1; i <= maxChoosableInteger; i++) {
                if (((usedNumber >> i) & 1) == 0) {
                    if (i + currentTotal >= desiredTotal) {
                        res = true;
                        break;
                    }
                    if (!dfs(maxChoosableInteger, usedNumber | (1 << i), desiredTotal, currentTotal + i)) {
                        res = true;
                        break;
                    }
                }
            }
            cache.put(usedNumber, res);
        }
        return cache.get(usedNumber);
    }
}
