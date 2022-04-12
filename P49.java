import java.util.*;
public class P49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            // 把字符串给排序成一个个标准结果记为key
            Arrays.sort(array);
            String key = new String(array);

            // 从现有的map中按照key来取得对应的现有结果或是空值，更新并返回
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
