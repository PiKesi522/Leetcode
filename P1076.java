public class P1076 {
    public int[] findBall(int[][] grid) {
        int width = grid[0].length;
        int[] ans = new int[width];
        for(int i = 0; i < width; i++){
//            System.out.print(i + "=");
            ans[i] = simulate(ans, width, grid.length, i, grid);
//            System.out.println();
        }
        return ans;
    }

    public static int simulate(int[] ans, int width, int height,
                                int locx, int[][] grid){
        int locy = 0, headFor = grid[0][locx];
        while(locy < height - 1){
//            System.out.print("[" + locy + "," + locx + "]->");
            if(headFor == 1){
                if(locx == width - 1){
                    return -1;
                }

                if(grid[locy][locx + 1] == -1){
                    return -1;
                }else {
                    headFor = grid[++locy][++locx];
                }
            }else{
                if(locx == 0){
                    return -1;
                }

                if(grid[locy][locx - 1] == 1){
                    return -1;
                }else {
                    headFor = grid[++locy][--locx];
                }
            }
        }

        if(headFor == 1){
            if(locx == width - 1 || grid[locy][locx + 1] == -1){
                return -1;
            }else {
                return locx + 1;
            }
        }else {
            if(locx == 0 || grid[locy][locx - 1] == 1){
                return -1;
            }else {
                return locx - 1;
            }
        }
    }
}
