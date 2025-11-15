import java.util.*;
public class Main1021 {
    static int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
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
        boolean[][] vis = new boolean[n][m];

        for (int i = 1; i < n-1; i++) {
            for(int j = 1; j < m-1; j++){
                if(map[i][j] == 1 && !vis[i][j]){
                    bfs(map,i,j,vis);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


private static void bfs(int[][] map, int i, int j, boolean[][] vis) {
    Queue<int[]> queue = new LinkedList<>();
    //记录下这个岛的所有坐标，最后搜索完了发现是孤岛就沉没
    LinkedList<int[]> list = new LinkedList<>();
    boolean isIsolated = true; // 标记是否为孤岛
    queue.add(new int[]{i,j});
    vis[i][j] = true;
    list.add(new int[]{i,j});
    while (!queue.isEmpty()) {
        int x = queue.peek()[0];
        int y = queue.poll()[1];
        for (int k = 0; k < 4; k++) {
            int nextx = x + dir[k][0];
            int nexty = y + dir[k][1];

            if(nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map[0].length || vis[nextx][nexty] || map[nextx][nexty] == 0)
                continue;
            //碰到边界，说明不是孤岛,给这个岛打标记
            if(nextx == 0 || nextx == map.length - 1 || nexty == 0 || nexty == map[0].length - 1){
                isIsolated =false;
            }
            queue.add(new int[]{nextx,nexty});
            vis[nextx][nexty] = true;
            list.add(new int[]{nextx,nexty});
        }
    }

    //搜索完了检查有没有有标记，有标记给整个队列的坐标修改为0变成水域
    if (isIsolated){
        for (int[] item : list) {
            map[item[0]][item[1]] = 0;
        }
    }

}

}