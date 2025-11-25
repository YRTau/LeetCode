import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
同 最大岛屿面积问题,注意输入
 */
public class Main32 {
    static int res = 0;
    static int total =0 ;
    static int m = 0;
    static int n = 0;
    static int[][] dirs =new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        List<int[]> maze = new ArrayList<>();

        while (in.hasNextLine()){//注意输入，行数m是不定的，所以先拿list来接
            char[] charArray = in.nextLine().toCharArray();
            n = charArray.length;
            int[] row = new int[n];
            for (int i = 0; i < n; i++) {
                row[i] = Integer.parseInt(String.valueOf(charArray[i]));
            }
            maze.add(row);
            m++;
        }

        int[][] mazes = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mazes[i][j] = maze.get(i)[j];
            }
        }

         boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mazes[i][j]!=0) {
                    total = 0;//初始化每个矿的价值
                    dfs(mazes, i, j, vis);
                    res = Math.max(res,total);//记录最大价值
                }
            }
        }
        System.out.println(res);
    }
   static void dfs(int[][] maze, int x, int y, boolean[][] vis){
        vis[x][y] = true;
        if (maze[x][y]!=0){
            total+=maze[x][y];
        }
       for (int i = 0; i < 4; i++) {
           int nextx = x + dirs[i][0];
           int nexty = y + dirs[i][1];

           if (nextx<0||nextx>=maze.length||nexty<0||nexty>=maze[0].length)continue;
           //越界不去
            if(maze[nextx][nexty]==0||vis[nextx][nexty])continue;
           //不能去不去

           dfs(maze,nextx,nexty,vis);
       }
    }
}
