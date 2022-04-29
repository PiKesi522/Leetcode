class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};

public class P427 {
    int n;
    public Node construct(int[][] grid) {
        this.n = grid.length;
        return dfs(0, n, 0, n, grid);
    }

    public Node dfs(int top, int down, int left, int right, int[][] grid){
        boolean same = true;
        for(int i  = top; i < down; i++){
            for(int j = left; j < right; j++){
                if(grid[i][j] != grid[top][left]){
                    same = false;
                    break;
                }
            }
            if(!same)
                break;
        }
        if(same){
            return new Node(grid[top][left] == 1, true);
        }

        Node ret = new Node(
                true,
                false,
                dfs(top, (top + down) / 2, left, (left + right) / 2, grid),
                dfs(top, (top + down) / 2, (left + right) / 2, right, grid),
                dfs((top + down) / 2, down, left, (left + right) / 2, grid),
                dfs((top + down) / 2, down, (left + right) / 2, right, grid)
        );
        return ret;
    }
}
