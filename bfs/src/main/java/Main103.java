import java.util.Scanner;

public class Main103 {
static final int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
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


    //从上边界逆流往上搜索，搜到的标记一下
        int[][] first = new int[n][m];
            //左边
        for (int i = 0; i < n; i++) {
                if (first[i][0] == 0) {
                    dfs(map, first, i, 0);
                }
            }
            //上边
        for (int j = 0; j < m; j++) {
            if (first[0][j] == 0) {
                dfs(map, first, 0, j);
            }
        }


    //从下边界流往下搜索，搜到的标记一下
            //右边
        int[][] second= new int[n][m];
        for (int i = 0; i < n; i++) {

                if (second[i][m-1] == 0) {
                    dfs(map, second, i, m-1);

            }
        }
            //下边
        for (int j = 0; j < m; j++) {
            if (second[n-1][j] == 0) {
                dfs(map, second, n-1, j);
            }
        }



    //两个标记数组都重合的坐标说明是满足条件的答案
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (first[i][j] == 1 && second[i][j] == 1) {
                    System.out.println(i + " " + j);
                }
            }
        }

    }

    private static void dfs(int[][] map, int[][] first, int x, int y) {
            //出口
        first[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map[0].length){
                continue;//越界跳过
            }
            //逆流往上走，走过的不走
            if(map[nextx][nexty] <map[x][y] || first[nextx][nexty] == 1) continue;
            first[nextx][nexty] = 1;
            dfs(map, first, nextx, nexty);
         }
    }
}
