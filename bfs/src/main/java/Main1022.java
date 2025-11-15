import java.util.Scanner;

public class Main1022 {
    static int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int map[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //两边往中间搜
        for (int i = 0; i < n; i++) {
            if (map[i][0] == 1) {
                dfs(map,i,0);
            }
            if (map[i][m-1] == 1) {
                dfs(map,i,m-1);
            }
        }
        //上下往中间搜
        for (int j = 0; j < m; j++) {
            if (map[0][j] == 1) {
                dfs(map,0,j);
            }
            if (map[n-1][j] == 1) {
                dfs(map,n-1,j);
            }
        }

        //最后统一处理标记
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = 0;
                }
                    if (map[i][j] == 2) {
                    map[i][j] = 1;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void dfs(int[][] map, int x, int y) {
            //能搜到的是岛但不是孤岛，直接标记为2
            map[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map[0].length || map[nextx][nexty] == 0)
                continue; //越界不搜
            if (map[nextx][nexty] == 2)
                continue; //搜过不搜
            dfs(map,nextx,nexty);
        }
    }
}
