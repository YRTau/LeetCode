import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        Set<String> set = new HashSet<>();
        String res = "";

        Collections.addAll(set, strs);
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            boolean flag = true;
            for (int j = 1; j < str.length(); j++) {
                if(!set.contains(str.substring(0,j))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                //比较长度
                if(str.length()>res.length()){
                    res = str;
                }
                // 长度相等再比较字典序
                if(str.length()==res.length() && str.compareTo(res)>0){
                    res = str;
                }
            }

        }
        System.out.println(res);
    }
}
