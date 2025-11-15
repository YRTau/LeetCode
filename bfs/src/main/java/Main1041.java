import java.util.Scanner;

/**
 * 题目描述
 * 给定一个由 1（陆地）和 0（水）组成的矩阵，你最多可以将矩阵中的一格水变为一块陆地，在执行了此操作之后，矩阵中最大的岛屿面积是多少。
 *
 *
 *
 * 岛屿面积的计算方式为组成岛屿的陆地的总数。岛屿是被水包围，并且通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设矩阵外均被水包围。
 */
public class Main1041{
    static int count = 0;
    static int max = 0;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
    //转换成起点一定算是陆地.
        //矩阵内每个0点都可以算是陆地，然后从0点直接算一个岛的最大面积
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (map[i][j] == 0) {
                count=0;
                map[i][j] = 1;
                //每次都要用新的vis =======相当于每个格子都要完整的DFS一次（因为每次都要边遍历边计算面积），这里的时间复杂度变高。
                boolean[][] vis = new boolean[n][m];
                dfs(map, i, j, vis);
                map[i][j] = 0;
                max = Math.max(max, count);
            }
            else {//正常的岛面积也计算一下，有可能全是岛
                count=0;
                boolean[][] vis = new boolean[n][m];
                dfs(map, i, j, vis);
                max = Math.max(max, count);
            }
        }
     }

        System.out.println(max);
    }

    private static void dfs(int[][] map, int i, int j, boolean[][] vis) {
        count++;
        vis[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int nextx = i + dir[k][0];
                int nexty = j + dir[k][1];
                if (nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map[0].length)
                    continue;
                if(vis[nextx][nexty] || map[nextx][nexty] == 0)continue;
                dfs(map, nextx, nexty, vis);
            }
    }

}
