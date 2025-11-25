import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        char[] chars = split[0].toCharArray();
        int len = Integer.parseInt(split[1]);
        //收集字符频率,字符总数
        int target_count = 0;
        Map<Character,Integer> target_freq = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            target_freq.put(chars[i],
                    target_freq.getOrDefault(chars[i],0)+1);
            target_count++;
        }
        //滑动遍历0-1000，因为最大正整数不超过1000
        int left = 0 ;
        int right = left+len - 1;
        //左闭右闭
        //初始化窗口
        //窗口内字符频率，字符总数
        Map<Character,Integer> window_freq = new HashMap<>();
        int window_count = 0;
        for (int i = left; i <=right; i++) {
            window_freq.put((char) (i+'0'), window_freq.getOrDefault((char)(i+'0'),0)+1);
            window_count++;
        }
        int res= 0;
        //开始滑动
        for (int i = right+1; i < 1000; i++) {
            if(isMatch(target_freq,target_count,window_freq,window_count)){
                res =  i-len;
                break;
            }
            String putStr =  String.valueOf(i);
            String outStr = String.valueOf(i-len);
            //修改频率以及字符总数
            for (int j = 0; j < putStr.length(); j++) {
                window_freq.put(putStr.charAt(j),window_freq.getOrDefault(putStr.charAt(j),0)+1);
                window_count++;
            }
            for (int j = 0; j < outStr.length(); j++) {
                window_freq.put(outStr.charAt(j),window_freq.get(outStr.charAt(j))-1);
                window_count--;
            }
        }

        System.out.println(res);
    }
    static boolean isMatch(Map<Character,Integer> target_freq,int target_count,
                           Map<Character,Integer> window_freq,int window_count){

        if (target_count!=window_count) return  false;
        for(Map.Entry<Character,Integer> t : target_freq.entrySet()){
            if (!window_freq.containsKey(t.getKey())
            || !t.getValue().equals(window_freq.get(t.getKey()))
            ) return false;

        }

        return true;
    }

}
