import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nm = split(in.nextLine(), " ");
        int n = nm[0];
        int m = nm[1];

        int[] pf = new int[n];
        List<int[]> res = new ArrayList<>(m);
        for (int i = 0; i < n; i++) {
            pf[i] = Integer.parseInt(in.nextLine());
        }
        //用（总分,索引）构造队列，
        for (int i = 0; i < m; i++) {
            int[] str = split(in.nextLine()," ");
            int total = 0;
            for(int s : str){
                total+=s;
            }
            res.add(new int[]{total,i+1});
        }//这样排序的时候直接比较总分，再比较索引就可以了
        res.sort((a,b)->{
            if(a[0]!=b[0])
                return b[0]-a[0];
            else return a[1]-b[1];
        });
        for (int[] re :res){
            System.out.println(re[1]);
        }
    }

    static int[] split(String str, String chars) {
        String[] split = str.split(chars);
        int[] res = new int[split.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(split[i]);
        }
        return res;
    }
}
