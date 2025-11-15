import java.util.*;

public class Main {
    static final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int count = 0;
    static int res=1;

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

        //
        int[][] mark = new int[n][m];
        Map<Integer, Integer> land = new HashMap<>();
        int num = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && mark[i][j] == 0) {
                    count = 0;
                    dfs(map, i, j, mark, num);
                    land.put(num, count);
                    num++;
                }
            }
        }
        //如果没0可以遍历的话，直接输出land里面的最小值，如果land为空，则输出1
        for (Integer key : land.keySet()) {
            res = Math.max(res, land.get(key));
        }
        //遍历0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    int temp = getSize(map, i, j, land, mark);
                    res = Math.max(res, temp);
                }
            }
        }

        //res = res == 0 ? 1 : res;

        System.out.println(res);
    }

    static int getSize(int[][] map, int x, int y, Map<Integer, Integer> land, int[][] mark) {
        int res = 1;
        int markNum = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map[0].length)
                continue;
            if (map[nextx][nexty] == 1 && mark[nextx][nexty] != 0) {
                markNum = mark[nextx][nexty];
                set.add(markNum);
            }
        }
        for (Integer num : set) {
            res += land.get(num);
        }
        return res;
    }

    static void dfs(int[][] map, int x, int y, int[][] mark, int num) {
        count++;
        mark[x][y] = num;

        for (int i = 0; i < 4; i++) {
            int nextx = x + dir[i][0];
            int nexty = y + dir[i][1];
            if (nextx < 0 || nexty < 0 || nextx >= map.length || nexty >= map[0].length)
                continue;
            if (map[nextx][nexty] == 0 || mark[nextx][nexty] != 0) continue;
            dfs(map, nextx, nexty, mark, num);
        }
    }
}
