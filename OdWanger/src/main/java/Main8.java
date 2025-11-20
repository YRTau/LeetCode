import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        //利用字典序比较，两个字符串拼在一起位数都是一样的。比较字典序就可以比较大小了
        //不能转成Integer字符串太长了
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
              return   (o1+o2).compareTo(o2+o1);
            }
        });

        //处理前导零的情况，有前导零的一定排序后在第一个。这时候不能输出它开头，要选一个不是前导零的换到它前面来输出
        if(s[0].charAt(0)=='0'){

            for (int i = 1; i < s.length; i++) {
                //从它后面找一个不是0开头的，直接放到最前面，这样还能保证整个数最小，因为其他数都是有序的
                if (s[i].charAt(0)!='0'){
                    //找到了直接插到最前面来，拼接到第一位
                     s[0]  = s[i] + s[0];
                     s[i]  = "";//把找到的变成空串
                    break;
                }
            }
        }

            //处理全是0的情况，直接replaceAll,正则去掉0开头，拼出来全是000会变成空串。
            String res = new String();
                //拼接
                for (String x : s) {
                    res+=x;
                }
            res = res.replaceAll("^0+","");
            if (res.equals("")){
                System.out.println("0");
            }
            else {
                System.out.println(res);
            }
    }
}
