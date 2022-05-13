public class F0105 {
    public boolean oneEditAway(String first, String second) {
        char[] cf = first.toCharArray(), cs = second.toCharArray();
        if(first.length() == second.length()){
            int i;
            for(i = 0; i < first.length(); i++){
                if(cf[i] != cs[i]){
                    cf[i] = cs[i];
                    break;
                }
            }
            i++;
            for(; i < first.length(); i++){
                if(cf[i] != cs[i]){
                    return false;
                }
            }
            return true;
        }else if(first.length() == second.length() - 1){
            int i;
            for(i = 0; i < first.length(); i++){
                if(cf[i] != cs[i]){
                    break;
                }
            }
            for(; i < first.length(); i++){
                if(cf[i] != cs[i+1]){
                    return false;
                }
            }
            return true;
        }else if(first.length() == second.length() + 1){
            int i;
            for(i = 0; i < second.length(); i++){
                if(cf[i] != cs[i]){
                    break;
                }
            }
            for(; i < second.length(); i++){
                if(cf[i+1] != cs[i]){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
