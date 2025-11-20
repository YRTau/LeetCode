import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
static StringBuilder path = new StringBuilder();
static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();//读一个换行
        String in = sc.nextLine();

        String[] nums = in.split(" ");
        boolean[] vis = new boolean[n];
        Arrays.sort(nums);
        dfs(nums,vis);
        System.out.println(res);
    }
    static void dfs(String[]nums,boolean[] vis){
        if(path.length() == nums.length){
            res.add(new String(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {

            if(vis[i]==true)continue;

            if(i>0 && nums[i-1].equals(nums[i]) && vis[i-1]==false)continue;

            path.append(nums[i]);
            vis[i]=true;
            dfs(nums,vis);
            path.deleteCharAt(path.length()-1);
            vis[i]=false;
        }

    }
}
