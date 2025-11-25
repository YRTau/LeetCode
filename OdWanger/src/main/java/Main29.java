import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] nums =Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        List<Athlete> all_athletes = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            Athlete athlete = new Athlete(i, nums[i]);
            all_athletes.add(athlete);
        }
        List<Athlete> win = new ArrayList<>();
        List<Athlete> lose = new ArrayList<>();

        compete(all_athletes,win,lose);
        Collections.sort(win);
        Collections.sort(lose);

        System.out.println(win.get(0).id +" "+ win.get(1).id +" "+ lose.get(0).id);
        return;
    }
    public static void compete(List<Athlete> all_athletes, List<Athlete> win, List<Athlete> lose){
        List<Athlete> result = new ArrayList<>();
        int len = all_athletes.size();
        for(int i=0; i<len; i+=2){
            Athlete one = all_athletes.get(i);
            if(i == all_athletes.size() - 1){
                result.add(one);
                if(len == 3){
                    win.add(one);
                }
                break;
            }
            Athlete two = all_athletes.get(i+1);
            if(one.score >= two.score){
                result.add(one);
                if(len <= 4){
                    win.add(one);
                    lose.add(two);
                }
            }else {
                result.add(two);
                if(len <= 4){
                    win.add(two);
                    lose.add(one);
                }
            }
        }

        if(result.size() >= 3){
            compete(result,win,lose);
        }
    }

    public static class Athlete implements Comparable<Athlete>{
        int id;
        int score;
        public Athlete(int id, int score){
            this.id = id;
            this.score = score;
        }

        //自定义排序
        @Override
        public int compareTo(Athlete o) {
            if(this.score == o.score){
                return this.id - o.id;
            }
            return o.score - this.score;
        }
    }
}