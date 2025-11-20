import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toCharArray();
        Deque<Integer> st = new ArrayDeque<>();
        int[] count = new int[10];
        int[] vis = new int[10];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]-'0']+=1;
        }

        for (int i = 0; i < chars.length; i++) {
            if(vis[chars[i]-'0']>=2)continue;
            while (!st.isEmpty()&&chars[i]>chars[st.peek()]
                    &&count[chars[st.peek()]-'0']>2 ){
                Integer pop = st.pop();
                count[chars[pop]-'0']-=1;
                vis[chars[pop]-'0']-=1;
            }
            st.push(i);
            vis[chars[i]-'0']+=1;
        }
    StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){//注意栈里面是索引
            res.append(chars[st.pollLast()] );
        }
        System.out.println(res);
    }
}
