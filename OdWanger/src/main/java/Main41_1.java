import java.util.*;

/*
堆优化迪杰斯特拉算法
 */
public class Main41_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        //邻接表存图
        //边构造一个数据结构edge
        List<List<Edge>> grid = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {//用List的话要初始化
            grid.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {//读取每条边存入
            String[] s = in.nextLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            grid.get(x).add(new Edge(y, k));
        }

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] vis = new boolean[n + 1];
        //优先级队列存放<节点，源点到该节点的权> 默认小顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        //初始化
        int start = 1;
        minDist[start] = 0;//起点到自身距离为0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {//跟朴素版区别，这里枚举边
            //1 选出源点到哪个节点近且该节点未被访问过
            //cur[]{节点，源点到该节点的权}
            int[] cur = pq.poll();//小顶堆，这里弹出来的就是未访问过且最近的节点
            int curV = cur[0];

            if (vis[curV]) continue;
            //2 标记该节点
            vis[curV] = true;
            //3 更新minDist数组，跟朴素版区别，这里枚举边
            //最终还是要一个新的最短的未访问节点
            for (Edge edge : grid.get(curV)) {
                int v = edge.to;
                if (!vis[v] && minDist[v] > minDist[curV] + edge.val) {
                    //未访 可达 更短
                    minDist[v] = minDist[curV] + edge.val;
                    //将目前到源点的最短midDist加入堆中
                    pq.add(new int[]{v, minDist[v]});
                }
            }
        }

//        //打印debug
//        for (int e : minDist) {
//            System.out.print(e + " ");
//        }
//        System.out.println();

        if (minDist[n] == Integer.MAX_VALUE) {//能否到达终点
            System.out.println(-1);
        } else System.out.println(minDist[n]);
    }


    static class Edge {
        int to;//表示边的终点
        int val;//表示边的权

        Edge(int to, int val) {
            this.to = to;
            this.val = val;
        }
    }

}
