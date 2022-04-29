class P74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[matrix.length-1].length - 1]) return false;
        int colLoc = binaSearchCol(matrix, matrix.length, target);
//        if(matrix[colLoc][0] == target) return true;
//        if(matrix[colLoc][0] > target) return false;
        System.out.println(colLoc);
        return binaSearchRow(matrix[colLoc], matrix[colLoc].length, target);
    }

    public int binaSearchCol(int[][] martix, int colSize, int target){
        int left = 0, right = colSize - 1;
        while(left < right){
            int mid = left +  (right - left + 1) / 2;
            if(martix[mid][0] <= target){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean binaSearchRow(int[] martix, int rowSize, int target){
        int left = 0, right = rowSize - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            if(martix[mid] == target){
                return true;
            }

            if(target < martix[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }
}
