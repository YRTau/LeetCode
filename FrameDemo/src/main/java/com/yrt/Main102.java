package com.yrt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main102 {
    static final int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int count = 0;
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


        for (int i = 0; i < n; i++) {
            if (map[i][0] == 1 && !vis[i][0]) {
                bfs1(map, i, 0, vis);
            }
            if (map[i][m-1]==1 && !vis[i][m-1])
            bfs1(map,i,m-1,vis);
        }
        for (int i = 0; i < m; i++) {
            if (map[0][i] == 1 && !vis[0][i]) {
                bfs1(map, 0, i, vis);
            }
            if (map[n-1][i]==1 && !vis[n-1][i])
            bfs1(map,n-1,i,vis);
        }


        //第二次bfs之前要把vis清空
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = false;
            }
        }
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (map[i][j] == 1 && !vis[i][j]) {
                    bfs2(map, i, j, vis);
                }
            }
        }

        System.out.println(count);

    }
    static void bfs2(int[][] map, int x, int y, boolean[][] vis) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, y});
        vis[x][y] = true;
        count++;
        while (!queue.isEmpty()) {

            int curx = queue.peek()[0];
            int cury = queue.poll()[1];
            for (int i = 0; i < 4; i++) {
                int nextx = curx + dir[i][0];
                int nexty = cury + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map[0].length)
                    continue;
                if (!vis[nextx][nexty] && map[nextx][nexty] == 1){
                    queue.add(new Integer[]{nextx, nexty});
                    vis[nextx][nexty] = true;
                    count++;
                }

            }
        }
    }


    static void bfs1(int[][] map, int x, int y, boolean[][] vis) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x,y});
        vis[x][y]=true;
        //第一次bfs，把从边缘上能bfs到的岛屿都标记为0
        map[x][y] = 0;
        while (!queue.isEmpty()) {

            int curx = queue.peek()[0];
            int cury = queue.poll()[1];
            for (int i = 0; i < 4; i++) {
                int nextx = curx + dir[i][0];
                int nexty = cury + dir[i][1];
                if (nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map[0].length || vis[nextx][nexty] || map[nextx][nexty] == 0)
                    continue;
                queue.add(new Integer[]{nextx,nexty});
                vis[nextx][nexty] = true;
                //第一次bfs，把从边缘上能bfs到的岛屿都标记为0
                map[nextx][nexty] = 0;
             }
        }
    }
}
