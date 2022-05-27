public class P2633 {
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, i = 0, distance = Integer.MAX_VALUE;
        for(String word : words){
            if(word.equals(word1)){
                index1 = i;
            }else if(word.equals(word2)){
                index2 = i;
            }

            if(index1 > -1 && index2 > -1){
                distance = Math.min(Math.abs(index1 - index2), distance);
            }

            i++;
        }
        return distance;
    }
}
