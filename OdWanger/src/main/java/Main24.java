import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main24 {
    static int res = 0;
    static List<List<Character>> res_list = new ArrayList<>();
    static List<Character> path = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        char[] chars = split[0].toCharArray();
        Arrays.sort(chars);//排列问题去重 要排序
        int k  = Integer.parseInt(split[1]);
        boolean[] vis = new boolean[chars.length];
        backtrack(chars,vis,k);
        System.out.println(res);
      //  System.out.println(res_list.toString());
    }
    static void backtrack(char[] chars,boolean[] vis,int k){
        if(path.size()>=k){
            res++;
            res_list.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if(vis[i] == true) continue;
            if(i>0&&chars[i]==chars[i-1]&&vis[i-1]==false)continue;//这里就跟全排列②一样去重。
            if(path.size()>0&&chars[i]==path.get(path.size()-1)) continue;//多了个不能有相邻重复元素，
            vis[i] = true;
            path.add(chars[i]);
            backtrack(chars,vis,k);
            vis[i] = false;
            path.remove(path.size()-1);
        }
    }
}
