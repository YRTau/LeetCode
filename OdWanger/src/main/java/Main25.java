import java.util.*;

public class Main25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine().replaceAll("[^A-Za-z]", "");
        char[] charArray = s.toLowerCase().toCharArray();
//        Map<Character,Integer> map = new HashMap<>(); 不能用map，这里有重复字符分开统计
        List<String> res =new ArrayList<>();
        int i = 0;
        while (i<charArray.length)
        {
            int continueCount = 1;
            int j  = i + 1;
            while (j<charArray.length && charArray[j]==charArray[i]){
                j++;
                continueCount++;
            }
            if (continueCount>1){//处理连续字符串
                res.add(charArray[i]+""+continueCount);
            }
            else {
                int nextCount = 0;//处理非连续字符串，向后找出现次数
                for (int k = j; k < charArray.length; k++) {
                    if (charArray[k] == charArray[i]){
                        nextCount++;
                    }
                }
                res.add(charArray[i]+""+nextCount);
            }

            i = j;
        }
        //自定义集合排序
        res.sort((a,b)->{
            if(a.substring(1).equals(b.substring(1)))return a.substring(0).toCharArray()[0]-b.substring(0).toCharArray()[0];
            else return b.substring(1).toCharArray()[0]-a.substring(1).toCharArray()[0];
        });

        res.forEach(System.out::print);
    }
}
