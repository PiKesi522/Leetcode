public class P58 {
    public int lengthOfLastWord(String s) {
        char[] sc = s.toCharArray();
        int cnt = 0;
        boolean startCount = false;
        for(int i = sc.length - 1; i >= 0; i--){
            if(startCount && sc[i] == ' '){
                break;
            }else if(sc[i] != ' '){
                startCount = true;
                cnt += 1;
            }
        }
        return cnt;
    }
}
