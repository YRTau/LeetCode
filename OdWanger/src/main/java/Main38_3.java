import java.util.Scanner;

public class Main38_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int res = balancedString(s);
        System.out.println(res);
    }
    static     public int balancedString(String s) {
            char[] c = s.toCharArray();
            int[] map = new int[26];
            int n = c.length;
            int m = n/4;
            for (int i = 0; i < c.length; i++) {
                map[idx(c[i])]++;
            }
            if (map[idx('W')]==m&&map[idx('A')]==m&&map[idx('S')]==m&&map[idx('D')]==m){
                return 0;
            }
            int left = 0;//窗口左边
            int res = n ;
            for (int right = 0; right < c.length; right++) {
                map[idx(c[right])]--;//减去窗口内的字符
                //注意这里一定是while，不停缩小左边界
                while (map[idx('W')]<=m&&map[idx('A')]<=m&&map[idx('S')]<=m&&map[idx('D')]<=m){
                    //满足条件，记录窗口长度? -> 题目说了n一定是4的倍数，所以如果每个字母都少于n/4
                    //那么窗口内的长度一定满足条件,
                    //n-q-w-e-r = m-q+m-w+m-e+m-r = 4m -q-w-e-r
                    res = Math.min(res,right-left+1);

                    //迭代，缩小子串，把c[left]放到外面
                    map[idx(c[left])]++;
                    left++;

                }
            }


            return res;
        }

    static int idx(char c){
            return c-'A';
        }

}
