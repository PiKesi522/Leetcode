class Solution {
    public int binaryGap(int n) {
        int pointer = 0, last = -1, temp, max = 0;
        while(n > 0){
            temp = n % 2;
            if(temp == 1){
                if (last != -1) {
                    max = Math.max(pointer - last, max);
                }
                last = pointer;
            }
            n = n >> 1;
            pointer ++;
        }
        return max;
    }
}
