import java.util.ArrayDeque;
import java.util.Deque;

public class P591 {
    public static void main(String[] args) {
        boolean ans = isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>");
        return;
    }
    public static boolean isValid(String code) {
        final int len = code.length();
        char[] Code = code.toCharArray();
        Deque<String> tags = new ArrayDeque<>();
        int pointer = 0;
        while (pointer < len){
            if(Code[pointer] == '<'){
                if(pointer == len - 1){
                    return false;
                }
                if(Code[pointer + 1] == '/'){
                    int end = code.indexOf('>', pointer);
                    if(end < 0){
                        return false;
                    }
                    String tag = code.substring(pointer + 2, end);
                    if(tags.isEmpty() || !tags.peek().equals(tag)){
                        return false;
                    }
                    tags.pop();
                    pointer = end + 1;
                    if(tags.isEmpty() && pointer != len){
                        return false;
                    }
                }
                else if(Code[pointer + 1] == '!'){
                    if(tags.isEmpty() || pointer + 9 > len)
                        return false;
                    String cdataPrefix = code.substring(pointer + 2, pointer + 9);
                    if(!"[CDATA[".equals(cdataPrefix))
                        return false;
                    int end = code.indexOf("]]>", pointer);
                    if(end < 0)
                        return false;
                    pointer = end + 1;
                }
                else {
                    int end = code.indexOf(">",pointer);
                    if(end < 0)
                        return false;
                    String tag = code.substring(pointer + 1, end);
                    if(tag.length() < 1 || tag.length() > 9)
                        return false;
                    for(int i = 0; i < tag.length(); i++){
                        if(!Character.isUpperCase(tag.charAt(i))){
                            return false;
                        }
                    }
                    tags.push(tag);
                    pointer = end + 1;
                }
            }
            else {
                if(tags.isEmpty())
                    return false;
                pointer ++;
            }
        }
        return tags.isEmpty();
    }
}
