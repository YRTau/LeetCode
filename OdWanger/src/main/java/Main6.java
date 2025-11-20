import java.util.*;

public class Main6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] pf = new int[n];
        List<String[]> tlist = new ArrayList<>(m);

        for (int i = 0; i < n; i++) {
            pf[i] = in.nextInt();
        }
        in.nextLine(); //丢一个换行不读
        for (int i = 0; i < m; i++) {
            String[] str = in.nextLine().split(" ");

            String[] nstr = Arrays.copyOf(str,str.length+1);
            nstr[nstr.length-1] = String.valueOf(i+1);
            tlist.add(nstr);
        }

        tlist.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                int ascore=0;
                int bscore=0;
                for (int i = 0; i < a.length-1; i++) {
                    ascore+=pf[Integer.parseInt(a[i])-1];
                }
                for (int i = 0; i < b.length-1; i++) {
                    bscore+=pf[Integer.parseInt(b[i])-1];
                }
                //先比分,分数降序，b-a
                if(ascore!=bscore)
                return bscore-ascore;
                //分数相同，比较索引，升序，a-b
                else return tlist.indexOf(a) - tlist.indexOf(b);
            }
        });
        for (int i = 0; i < tlist.size(); i++) {
            String[] res = tlist.get(i);
            System.out.println(res[res.length-1]);
        }
    }
}
