package com.yrt;

import java.util.*;
public class Main99{
    //存储方向模拟运动
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static void bfs(int[][] grid, int x, int y, boolean[][] visited){
        // bfs里面维护一个队列，表示每一圈，要存坐标
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(x,y));
        visited[x][y]=true;//节点入队就要标记已访问，不然会重复遍历
        //队列不空就继续搜
        while(!queue.isEmpty()){
            //从队列中取出要遍历的当前点
            Pair cur = queue.poll();
            int curX = cur.getFirst();
            int curY = cur.getSecond();

            //当前队列的4个方向的点加入队列
            for(int i =0;i< 4 ;i++) {
            int nextx = curX + dir[i][0];
            int nexty = curY + dir[i][1];
                if(nextx<0 || nextx >= grid.length||nexty<0||nexty>=grid[0].length){
                    continue; // 排除边界
                }
                if(visited[nextx][nexty]==true || grid[nextx][nexty]==0) continue;//排除不符合条件
                //入队
                queue.add(new Pair(nextx,nexty));
                visited[nextx][nexty]=true;
            }
        }
    }

    public static void main(String[] args){
        //输入
        Scanner sc= new Scanner(System.in);
        int n  = sc.nextInt();
        int m  = sc.nextInt();
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ;i < n;i++){
            for(int j = 0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int res=0;


        for(int i = 0 ;i < n;i++){
            for(int j = 0;j<m;j++){
                if(visited[i][j]==false && grid[i][j]==1){
                    //新找到一个岛屿，答案+1，然后把这个岛屿搜完并标记。
                    res++;
                    bfs(grid,i,j,visited);
                }
            }
        }

        System.out.println(res);
    }
     static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getFirst(){
            return x;
        }
        public int getSecond(){
            return y;
        }
    }
}