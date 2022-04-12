import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class P17 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new LinkedList<>();
        if(digits.length() == 0){
            return combinations;
        }
        HashMap<Character, String> codeTrans = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        traceBack(combinations, codeTrans, digits, 0, new StringBuilder());
        return combinations;
    }
    public void traceBack(List<String> combinations, HashMap<Character,String> map,String digits, int index, StringBuilder combination){
        if(index == digits.length()){
            combinations.add(combination.toString());
        }else{
            char digit = digits.charAt(index);
            String buffer = map.get(digit);
            for(int i = 0; i < buffer.length(); i++){
                combination.append(buffer.charAt(i));
                traceBack(combinations, map, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
        return;
    }
}
