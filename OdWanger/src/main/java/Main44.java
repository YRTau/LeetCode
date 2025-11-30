import java.util.*;

public class Main44 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean passible = false;
        List<Integer> res = new ArrayList<>();
        //题中给了图的所有边，用邻接表存储
        List<List<Integer>> grid = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            grid.add(new ArrayList<>());
        }
        //入度
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int to =  prerequisites[i][0];
            int from = prerequisites[i][1];
            grid.get(from).add(to);
            //入度初始化
            inDegree[to]++;
        }
        //找到入度为0 的节点，从图中删除（修改入度）
        Queue<Integer> zero_inDegrees = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0) zero_inDegrees.offer(i);
        }

        while (!zero_inDegrees.isEmpty()){
            //选中这个入度为0的节点
            int poll = zero_inDegrees.poll();
            //加入到拓扑排序结果集
            res.add(poll);
            //找到节点有关的边 处理
            for (int to : grid.get(poll)){
                inDegree[to]--;
                if (inDegree[to]==0)zero_inDegrees.offer(to);
            }
        }
        //如果拓扑排序结果集个数跟节点数(numsCourses)相同，则返回true
        if (res.size() == numCourses) passible =true;
        return passible;
    }
}
