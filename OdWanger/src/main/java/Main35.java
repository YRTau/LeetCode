import java.util.*;

public class Main35 {
        //注意单入口的意思是从整个矩阵的边界开始遍历
    static Map<Integer,Integer[]> res = new HashMap<>();//岛屿id为key，坐标+面积为value;
    static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    static int count = 0;
    static int flag = 1;
    public static void main(String[] args) {
        Scanner in  =new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int m  = Integer.parseInt(split[0]);
        int n  = Integer.parseInt(split[1]);
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            Integer[] s = Arrays.stream(in.nextLine().split(" "))
                    .map(e->{if(e.equals("O"))return 1;
                        else return 0;
                    })
                    .toArray(Integer[]::new);
            for (int j = 0; j < s.length; j++) {
                map[i][j] = s[j];
            }
        }

        //记录最大面积，
        int max_area = 0;
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j]!=0 && (i==0||i==m-1||j==0||j==n-1)){//从四周边界遍历
                    count=0;
                    boolean[][] vis  = new boolean[m][n];
                    dfs(map,i,j,vis);
                    if (count>0){//说明是单入口区域，比较面积,如果面积相同，则都记下坐标加面积.
                        String loc = i+" "+j+" "+count;
                        if (count>max_area){

                            if (temp.size()>0){
                            temp.remove(temp.size()-1); //删掉之前保存的最大面积单入口区域
                            }
                            temp.add(loc);
                            max_area = count;//更新
                        }
                        else if (count==max_area){//如果跟之前保存的相同，肯定不是同一个区域，因为同一个区域在dfs里面已经判断过了。
                            temp.add(loc);
                        }
                    }
                }
            }
        }


        if (temp.isEmpty()){
            System.out.println("NULL");
        }else if (temp.size()==1){
            System.out.println(temp.get(0));
        }else
            System.out.println(temp.get(0).split(" ")[2]);

    }

static void dfs(int[][] map,int x,int y,boolean[][] vis){
        vis[x][y] = true;
        count++;
        map[x][y] = flag;
    for (int i = 0; i < 4; i++) {
        int nextx = x + dirs[i][0];
        int nexty = y + dirs[i][1];
        if (nextx<0||nextx>=map.length||nexty<0||nexty>=map[0].length)
        continue;
        if (vis[nextx][nexty]||map[nextx][nexty]!=1)
            continue;
        //如果新坐标是边界，直接return,并设置count=0.不计算了。
        if (nextx==0||nextx==map.length-1||nexty==0||nexty==map[0].length-1){
            count = 0;
            return;
        }
        dfs(map,nextx,nexty,vis);

    }
}

}
