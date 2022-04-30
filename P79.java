public class P79 {
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int rows;
    private int cols;
    private int len;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.len = word.length();
        this.charArray = word.toCharArray();

        if(rows == 0)
            return false;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];
        this.board = board;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x, int y, int begin){
        if(begin == len - 1){
            return board[x][y] == charArray[begin];
        }

        if(charArray[begin] == board[x][y]){
            visited[x][y] = true;
            for(int[] i : DIRECTIONS){
                int newX = x + i[0];
                int newY = y + i[1];
                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]){
                    if(dfs(newX, newY, begin + 1)){
                        return true;
                    }
                }
            }
            visited[x][y] = false;
        }
        return false;
    }
}
