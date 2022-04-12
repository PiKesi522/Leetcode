public class P12 {
    public String intToRoman(int num) {
        int[] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            for(int i = 0; i < 14; i++){
                if(num - values[i] >= 0){
                    num -= values[i];
                    sb.append(rom[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
