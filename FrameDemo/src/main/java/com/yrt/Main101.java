package com.yrt;

import java.util.Scanner;
/*
dfs 处理孤岛问题模版
 */
public class Main101 {
    static final int[][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
    static int count = 0;
    static int res = 0;
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

    //DFS处理
        for(int i = 0;i < n;i++){
            for(int j = 0;j<m;j++){
                if(map[i][j] == 1 && !vis[i][j]){
                    count = 0;
                    //从某个点开始dfs
                    dfs(map,i,j,vis);
                    res = Math.max(res,count);
                }
            }
        }
    System.out.println(res);
    }

    private static void dfs(int[][] map, int x, int y, boolean[][] vis) {
        //坐标标记
        vis[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if(nextx >= 0 && nextx < map.length && nexty >= 0 && nexty < map[0].length && map[nextx][nexty] == 1 && !vis[nextx][nexty]){

                dfs(map,nextx,nexty,vis);

            }

         }
    }
}
