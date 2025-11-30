public class Main42 {
    static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]=='1'&&!vis[i][j]) {
                    res++;
                    dfs(grid,vis,i,j);
                }
            }
        }


        return res;
    }
    void dfs(char[][]grid, boolean[][] vis, int x, int y){
        vis[x][y] =true;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx<0||nx>=grid.length||ny<0||ny>=grid[0].length||vis[nx][ny]){continue;}
            if (grid[nx][ny]=='0') continue;
            dfs(grid,vis,nx,ny);
        }
    }
}
