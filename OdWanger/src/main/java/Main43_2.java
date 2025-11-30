import java.util.*;

public class Main43_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        //存储每个节点的入度
        int[] inDegree = new int[n];
        List<List<Integer>> edges = new ArrayList<>(n);//邻接表存储 边的信息
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] s = in.nextLine().split(" ");
            int from = Integer.parseInt(s[0]);
            int to = Integer.parseInt(s[1]);
            inDegree[to]++;//更新入度
            edges.get(from).add(to);
        }
        //结果集
        List<Integer> res = new ArrayList<>();
        //由于正常情况删除一个节点必然导致新的节点入度为0
        //也就是说处理完选中的节点会带来新的节点，可以用队列保存
        Queue<Integer> queue = new LinkedList<>();
        //把入度为0的节点放到队列里面，表示选中的节点
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0){queue.offer(i);}
        }
        while (!queue.isEmpty())
        {
            Integer poll = queue.poll();
            res.add(poll);
            //找到要删除的节点连接的节点
            List<Integer> toList = edges.get(poll);
            //入度-1
            for(int to : toList){
                inDegree[to]--;
                if (inDegree[to] == 0){//导致减到0
                    queue.offer(to);//添加到选中的节点列表
                }
            }
        }
        //检查res里面是不是有所有节点,检查有无环
        if (res.size()!=n) System.out.println(-1);
        else {
            for(int i = 0;i<res.size()-1;i++){
                System.out.print(res.get(i)+" ");
            }
            System.out.println(res.get(res.size()-1));
        }
    }
}
