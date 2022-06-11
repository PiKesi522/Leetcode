public class P926 {
    int[] dpForward;
    int[] dpBackward;
    int Min;
    char[] cs;
    public int minFlipsMonoIncr(String s) {
        this.cs = s.toCharArray();
        this.dpForward = new int[s.length()];
        this.dpBackward = new int[s.length()];

        this.dpForward[0] = 0;
        for(int i = 1; i < s.length(); i++){
            if(cs[i] == '0') dpBackward[0] += 1;
        }
        this.Min = dpBackward[0] + dpForward[0];
        for(int i = 1; i < s.length(); i++){
            updateDP(i);
            this.Min = Math.min(this.Min, dpBackward[i] + dpForward[i]);
        }
        return this.Min;
    }

    void updateDP(int i){
        dpForward[i] = dpForward[i - 1];
        dpBackward[i] = dpBackward[i - 1];
        if(cs[i - 1] == '1'){
            dpForward[i] += 1;
        }
        if(cs[i] == '0'){
            dpBackward[i] -= 1;
        }
    }
}
