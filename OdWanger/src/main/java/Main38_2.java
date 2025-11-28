public class Main38_2 {
    public int balancedString(String s) {
        char[] c = s.toCharArray();
        int[] map = new int[26];
        int n = c.length;
        int m = n/4;
        for (int i = 0; i < c.length; i++) {
            map[idx(c[i])]++;
        }
        if (map[idx('Q')]==m&&map[idx('W')]==m&&map[idx('E')]==m&&map[idx('R')]==m){
            return 0;
        }
        int left = 0;
        int res = n ;
        for (int right = 0; right < c.length; right++) {
            map[idx(c[right])]--;//减去窗口内的字符
            while (map[idx('Q')]<=m&&map[idx('W')]<=m&&map[idx('E')]<=m&&map[idx('R')]<=m){
                //满足条件，记录窗口长度?->题目说了n一定是4的倍数，所以如果每个字母都少于n/4
                //那么窗口内的长度一定满足条件,
                //n-q-w-e-r = m-q+m-w+m-e+m-r = 4m -q-w-e-r
                res = Math.min(res,right-left+1);

                //迭代，缩小子串，把c[left]放到外面
                left++;
                map[idx(c[left])]++;
            }
        }


        return res;
    }

    int idx(char c){
        return c-'A';
    }
}
