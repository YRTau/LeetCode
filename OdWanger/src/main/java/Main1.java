import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 题目
宝宝和妈妈参加亲子游戏，在一个二维矩阵（N*N）的格子地图上，宝宝和妈妈抽签决定各自的位置，地图上每个格子有不同的糖
果数量，部分格子有障碍物。
游戏规则是妈妈必须在最短的时间（每个单位时间只能走一步）到达宝宝的位置，路上的所有糖果都可以拿走，不能走障碍物的格
子，只能上下左右走。
请问妈妈在最短到达宝宝位置的时间内最多拿到多少糖果（优先考虑最短时间到达的情况下尽可能多拿糖果）。
输入描述
第一行输入为N，N标识二维矩阵的大小
之后N行，每行有N个值，表格矩阵每个位置的值
其中：
-3:妈妈
-2:宝宝
-1：障碍
>=0：糖果数(0表示没有糖果，但是可以走）
输出描述
输出妈妈在最短到达宝宝位置的时间内最多拿到多少糖果，行末无多余空格
备注
地图最大50*50
 */
public class Main1 {
    static int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static List<Integer> path = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        List<int[]> loc = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == -3){
                    loc.add(new int[]{i,j});
                }else if(map[i][j] == -2){
                    loc.add(new int[]{i,j});
                }
            }
        }
        int x = loc.get(0)[0];
        int y = loc.get(0)[1];
        vis[x][y] = true;
        dfs(map,path,x,y,vis);

        // 处理找不到路径的情况
        if(res.isEmpty()){
            System.out.println(-1);
            return;
        }

        // 找到最短路径长度
        int minLen = Integer.MAX_VALUE;
        for(List<Integer> path : res){
            minLen = Math.min(minLen, path.size());
        }

                // 在最短路径中找到糖果数最大的
        int maxCandy = Integer.MIN_VALUE;
        for(List<Integer> path : res){
            if(path.size() == minLen){
                int candySum = 0;
                for(Integer candy : path){
                    candySum += candy;
                }
                maxCandy = Math.max(maxCandy, candySum);
            }
        }

        System.out.println(res);
        System.out.println(maxCandy);
    }
static void  dfs(int[][]map, List<Integer> path, int x, int y, boolean[][] vis){

        if(map[x][y]==-2){
            res.add(new ArrayList<>(path));
        return;
        }
    for(int i = 0; i < 4; i++) {

        int nx = x +dir[i][0];
        int ny = y +dir[i][1];
        if(nx<0 ||nx>=map.length||ny<0||ny>=map[0].length )continue;
        if(map[nx][ny]==-1||vis[nx][ny]==true)continue;
            // 起点和终点不加入糖果计算
            if(map[nx][ny] != -3 && map[nx][ny] != -2) {
                path.add(map[nx][ny]);
            }
        vis[nx][ny]=true;
        dfs(map,path,nx,ny,vis);
          if(map[nx][ny] != -3 && map[nx][ny] != -2) {
                path.remove(path.size()-1);
            }
        vis[nx][ny]=false;
    }
    }
}
