import java.util.LinkedList;
import java.util.Queue;

public class Main40 {
    public int orangesRotting(int[][] grid) {
        int res = 0;

        Queue<int[]> que = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        int count_one = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){//源点入队
                    que.offer(new int[]{i,j});
                    vis[i][j] = true;
                }
                if (grid[i][j]==1) count_one++;
            }
        }
        //如果开始就没有新鲜橘子，直接返回0
        if (count_one == 0) return 0;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int time = 0;
        while(!que.isEmpty()){
            int size = que.size();
            boolean spread = false;
            for (int i = 0; i < size; i++) {//每层
                int[] cur =  que.poll();
                for(int[]dir :dirs){
                    int nextx = cur[0]+dir[0];
                    int nexty = cur[1]+dir[1];
                if (nextx<0||nextx>=grid.length||nexty<0||nexty>=grid[0].length||vis[nextx][nexty])continue;
                if (grid[nextx][nexty]==1){
                    que.offer(new int[]{nextx,nexty});
                    vis[nextx][nexty] = true;
                    spread = true;
                    count_one--;//新鲜橘子数量减少
                }
                }
            }
            if (spread) time++;
        }
        //有无不会被扩散到的橘子
        if (count_one!=0) return -1;
        return time;
    }

}
