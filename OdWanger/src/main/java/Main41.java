import java.util.Arrays;
import java.util.Scanner;

public class Main41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] grid = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {//领接矩阵存储图
            String[] s = in.nextLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            grid[x][y] = k;
        }

        int[] minDist = new int[n+1];
        boolean[] vis = new boolean[n+1];
        //初始化
        for (int i = 1; i < n+1; i++) {
            minDist[i] = Integer.MAX_VALUE;//不可达无穷
            if (grid[1][i]!=0) {
                minDist[i] = grid[1][i];
            }
        }
        minDist[1] = 0;//存源点到其他所有节点的最短路径，源点是0，不可达节点是MAX
        vis[1] = true;//表示访问过的节点


        for (int i = 0; i < n; i++) {//每轮将未访问的可达节点加入
            //选出要访问的节点，这里贪心
            int curV = 0;
            int tempDis = Integer.MAX_VALUE;
            for (int v = 1; v < n+1; v++) {
                if (vis[v])continue;
                if (minDist[v]<tempDis) {
                    curV = v;
                    tempDis = minDist[v];
                }
            }
            vis[curV] = true;
            for (int v = 1; v < n+1; v++) {//新访问的节点，带来变化，更新minDist数组
                if (!vis[v] && grid[curV][v]!=0 && minDist[curV]+grid[curV][v]<minDist[v]){
                    //未访，可达，更短
                    minDist[v] = minDist[curV]+grid[curV][v];
                }
            }
//            //打印debug
//            for(int e : minDist){
//                System.out.print(e+" ");
//            }
//            System.out.println();
        }

        if (minDist[n]==Integer.MAX_VALUE){//能否到达终点
            System.out.println(-1);
        }else System.out.println(minDist[n]);
    }
}
