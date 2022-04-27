import java.util.*;
public class P417 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int W,H;
    int[][] heights;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        this.W = heights[0].length;
        this.H = heights.length;

        int i, j;
        boolean[][] PacificAccess = new boolean[W][H];
        boolean[][] AtlanticAccess = new boolean[W][H];
        for (i = 0; i < W; i++) {
            bfs(0, i, PacificAccess);
        }
        for (i = 0; i < H; i++) {
            bfs(i, 0, PacificAccess);
        }
        for (i = 0; i < W; i++) {
            bfs(H - 1, i, AtlanticAccess);
        }
        for (i = 0; i < H; i++) {
            bfs(i, W - 1, AtlanticAccess);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (i = 0; i < H; i++) {
            for (j = 0; j < W; j++) {
                if (PacificAccess[i][j] && AtlanticAccess[i][j]) {
                    List<Integer> BothAccess = new ArrayList<>();
                    BothAccess.add(i);
                    BothAccess.add(j);
                    ans.add(BothAccess);
                }
            }
        }
        return ans;
    }

    public void bfs(int row, int col, boolean[][] ocean){
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[0];
                if (newRow >= 0 && newRow < H && newCol >= 0 && newCol < W
                        && heights[newRow][newCol] >= heights[cell[0]][cell[1]]
                        && !ocean[newRow][newCol]) {
                    ocean[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
