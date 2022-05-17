public class P953 {
    public boolean isAlienSorted(String[] words, String order) {
        String test, beTested;
        int i,j,k;
        for(i = 0; i < words.length; i++){
            test = words[i];
            for(j = i + 1; j < words.length; j++){
                beTested = words[j];
                for(k = 0; k < Math.min(test.length(), beTested.length()); k++){
                    if(order.indexOf(test.charAt(k)) > order.indexOf(beTested.charAt(k))){
                        return false;
                    }
                    else if(order.indexOf(test.charAt(k)) < order.indexOf(beTested.charAt(k))){
                        break;
                    }
                }
                if(k == beTested.length() && k < test.length()){
                    return false;
                }
            }
        }
        return true;
    }
}
