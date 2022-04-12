import java.util.*;
public class P22 {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        traceBack(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }
    public static void traceBack(List<String> combinations, StringBuilder combination ,int open, int close, int max){
        if(combination.length() == max * 2){
            combinations.add(combination.toString());
        }

        if(open < max){
            combination.append('(');
            traceBack(combinations, combination, open + 1, close, max);
            combination.deleteCharAt(combination.length() - 1);
        }
        if(close < open){
            combination.append(')');
            traceBack(combinations, combination, open, close + 1, max);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
