import java.util.*;

public class Main29_3 {


    public static void main(String[] args) {

        Scanner in  =new Scanner(System.in);
      Integer[] nums =
              Arrays.stream(in.nextLine().split(" "))
                      .map(Integer::parseInt).
                      toArray(Integer[]::new);

        List<Athlete> all_athlete = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            all_athlete.add(new Athlete(i,nums[i]));
        }
        List<Athlete> win = new ArrayList<>();
        List<Athlete> lose = new ArrayList<>();

        //获得四强以后的结果
        compete(all_athlete,win,lose);

        Collections.sort(win);
        Collections.sort(lose);

        System.out.println(
                win.get(0).id + " "+
                        win.get(1).id   +" " +
                        lose.get(0).id
        );
    }

    private static void compete(List<Athlete> allAthlete, List<Athlete> win, List<Athlete> lose) {
            List<Athlete> result = new ArrayList<>();
            int len = allAthlete.size();
        for (int i = 0; i < allAthlete.size(); i+=2) {
            if (i == len - 1) {//i是最后一个，直接轮空
                if(len<=4){
                win.add(allAthlete.get(i));
                }
                result.add(allAthlete.get(i));
                break;
            } else
            {   Athlete one = allAthlete.get(i);
                Athlete two = allAthlete.get(i+1);

                if (one.score>=two.score){
                    result.add(one);
                    if (len<=4){
                        win.add(one);
                        lose.add(two);
                    }
                }
                else {
                    result.add(two);
                    if (len<=4){
                        win.add(two);
                        lose.add(one);
                    }
                }
            }
        }
        if (result.size() >=3){
            compete(result,win,lose);
        }
    }


    static class Athlete implements Comparable<Athlete>{
        int id;
        int score;

        public Athlete(int id,int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Athlete o) {
            if(this.score!=o.score){
                return o.score -this.score;
            }else return this.id - o.id ;

        }
    }
}
