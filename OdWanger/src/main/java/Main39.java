import java.util.*;

/*
题目
题目描述
存在一个mxn的二维数组，其成员取值范围为0或1，其中值为1的成员具备扩散性，每经过1S，将上下左右值为0的成员同化为1，
二维数组的成员初始值都为0，将第[i。j]和[K，]两个个位置上元素修改成1后，求矩阵的所有，元素变为1需要多长时间
输入描述
输入数据中的前2个数字表示这是一个mxn的矩阵，m和n不会超过1024大小；
中间两个数字表示一个初始扩散点位置为I，j
最后2个数字表示另一个扩散点位置为k,I
输出描述
输出矩阵的所有元素变为1所需要秒数
示例1:
输入：
4,4,0,0,3,3
输出：
3
说明:
输入数据中的前2个数字表示这是一个4*4的矩阵；
中间两个数字表示一个初始扩散点位置为0,0；
最后2个数字表示另一个扩散点位置为3，3。
给出的样例是一个简单模型，初始点在对角线上，达到中间的位置分别为3次迭代，即3秒。所以输出为3。
 */
public class Main39 {
    /*
    *  思路：标准多源BFS问题，直接两个点开始BFS，BFS的标准代码别忘了
    *   同LeetCode
     */
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        Scanner in = new Scanner( System.in);
        String[] nums = in.nextLine().split(",");
        int m = Integer.parseInt(nums[0]);
        int n = Integer.parseInt(nums[1]);
        int startX1 = Integer.parseInt(nums[2]);
        int startY1 = Integer.parseInt(nums[3]);
        int startX2 = Integer.parseInt(nums[4]);
        int startY2 = Integer.parseInt(nums[5]);
        int[][] map = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        int res = bfs(map,vis,startX1,startY1,startX2,startY2);
        System.out.println(res);
    }
    static int bfs(int[][]map,boolean[][] vis,int x1,int y1,int x2,int y2){
        int time = 0 ;
        Queue<int[]> que = new LinkedList<>();
        //将源点加入队列
        que.offer(new int[]{x1,y1});
        vis[x1][y1] = true;
        if (!vis[x2][y2]){//有可能两个点是同一个
            que.offer(new int[]{x2,y2});
            vis[x2][y2] = true;
        }
        while(!que.isEmpty()){
            int size = que.size();   // 表示当前这一轮（这一秒）有多少个点需要向外扩散

            boolean spread = false;
            for (int i = 0; i < size; i++) {
                //标准bfs模版
                int[] cur =  que.poll();
                for (int[] dir : dirs) {
                    int nextx = cur[0]+dir[0];
                    int nexty = cur[1]+dir[1];
                    if (nextx<0||nextx>=map.length||nexty<0||nexty>=map[0].length)continue;
                    if (vis[nextx][nexty]) continue;
                    que.offer(new int[]{nextx,nexty});//入队
                    vis[nextx][nexty] =true;//标记
                    spread =true;            //说明扩散成功，时间可以增加
                }

            }

            if(spread) time+=1;// 只有当这一轮确实发生了扩散（有新节点入队），时间才+1
                                // 有些源是最后一圈，下一圈没有新的入队

        }

    return  time;
    }
}



