public class P668 {
    public int count(int m, int n, int mid){
        int count = 0;
        int i = m, j = 1;
        while(i > 0 && j < n + 1){
            int cons = i * j;
            if(cons <= mid){
                count += i;
                j++;
            }else{
                i--;
            }
        }
        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        while(left < right){
            int mid = (left + right) / 2;
            if(count(m, n, mid) < k){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
