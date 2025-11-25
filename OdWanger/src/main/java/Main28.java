import java.util.*;

public class Main28 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int m=0 ,n = 0;
            String[] split = in.nextLine().split(",");
            m = Integer.parseInt(split[0]);
            n = Integer.parseInt(split[1]);

            //校验输入
            if (m<3||m>10||n<3||n>100){
                System.out.println(-1);
                return;
            }
            int[][] scores = new int[m][n];
            for (int i = 0; i < m; i++) {
                String[] strings = in.nextLine().split(",");
                if (strings.length!=n){//打分的个数不对
                    System.out.println(-1);
                    return;
                }
                for (int j = 0; j < n; j++) {
                    scores[i][j] = Integer.parseInt(strings[j]);
                    if (scores[i][j] >10 || scores[i][j]<1) {//打分不符合要求
                        System.out.println(-1);
                        return;
                    }
                }
            }
            //设计一个选手类
            List<Player> res = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                int total=0;
                List<Integer> score = new ArrayList<>(m);
                for (int j = 0; j < m; j++) {
                    total += scores[j][i];
                    score.add( scores[j][i]);
                }
                res.add(new Player(i,total,score));
            }
            Collections.sort(res, new Comparator<Player>() {
                @Override
                public int compare(Player o1, Player o2) {
                    if (o1.total!=o2.total) return o2.total - o1.total;
                    else {
                        for (int i = 10; i > 0 ; i--) {
                            int f1 = Collections.frequency(o1.score,i);
                            int f2 = Collections.frequency(o2.score,i);
                            if (f1!=f2)return f2-f1;
                        }
                    }
                    return 0;
                }
            });
            System.out.println(
                    (res.get(0).index+1)+","
                            + (res.get(1).index+1)+","+
                            (res.get(2).index+1)
            );
        } catch (Exception e) {
            System.out.println(-1);
        }

    }


}
class Player  {
    int index;
    int total;
    List<Integer> score;

    Player(int index, int total, List<Integer> score) {
        this.score = score;
        this.total = total;
        this.index = index;
    }


}