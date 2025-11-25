
import java.util.*;


public class Main29_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        Integer[] nums = Arrays.stream(split).map(Integer::parseInt).toArray(size -> new Integer[size]);

        //最后肯定是4强里面选冠亚季军.
        //保留四强比赛完以后的胜者组，败者组
        List<Athlete> win = new ArrayList<>();
        List<Athlete> lose = new ArrayList<>();

        List<Athlete> all_athletes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            all_athletes.add(new Athlete(i,nums[i]));
        }
        //循环比赛直到四强结束，获得四强结束后的胜者组败者组。
        compete(win,lose,all_athletes);

        //最后比较胜者组里面选冠亚军，败者组里面选季军
        Collections.sort(win);
        Collections.sort(lose);

        //输出
        System.out.println(win.get(0).index +" "+ win.get(1).index +" "+ lose.get(0).index);
        return;
    }
    //一直compete，直到比完4强，进入决赛，得到决赛的胜者组跟败者组。
    static void compete(List<Athlete> win,List<Athlete> lose,List<Athlete> all_athletes){
        List<Athlete> result = new ArrayList<>();
        int len = all_athletes.size();
        for (int i = 0; i <len; i+=2) {
            Athlete one = all_athletes.get(i);
            if (i== all_athletes.size() -1) {//如果i是最后一个，轮空
                result.add(one);
                if (len == 3) {//如果只剩3个，轮空直接去胜者组
                    win.add(one);
                }
                break; //必须要加break；不然下面直接越界了。
            }
                //没有轮空
                Athlete two = all_athletes.get(i+1);
                if (one.power >= two.power){ //注意这里是>=!!!想同的分数one肯定索引小！！！必须是one进下一轮
                    result.add(one);
                    if (len <= 4){//四强
                    win.add(one);
                    lose.add(two);
                    }
                }else {
                    result.add(two);
                    if ( len <= 4){//四强
                        win.add(two);
                        lose.add(one);
                    }
                }

        }
        if (result.size() >= 3){//这里为什么是3，如果只剩3个也是要进4强比的。
            compete(win,lose,result);//递归循环比赛
        }
    }


}
  class Athlete implements Comparable<Athlete>{
        int index;
        int power;

      public Athlete(int index, int power) {
          this.index = index;
          this.power = power;
      }

      //决赛 胜者组跟败者组的规则
      //自定义排序
      @Override
      public int compareTo(Athlete o) {
          if(this.power == o.power){
              return this.index - o.index;
          }
          return o.power - this.power;
      }
    }