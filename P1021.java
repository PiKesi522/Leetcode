class P1021 {
    public String removeOuterParentheses(String s) {
        String ans = new String();
        int stack = 0, head = 0, tail = 0;
        final int len = s.length();
        for(tail = 0; tail < len; tail++){
            if(s.charAt(tail) == '('){
                stack += 1;
            }else{
                stack -= 1;
            }

            if(stack == 0){
                ans += s.substring(head + 1, tail);
                head = tail + 1;
            }
        }
        return ans;
    }
}
