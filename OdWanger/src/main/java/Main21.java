import java.util.ArrayDeque;
import java.util.Deque;

public class Main21 {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        boolean[] vis = new boolean[26];//保存栈中出现过的字母
        int[] lastIndex = new int[26];
        char[] chars = s.toCharArray();
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {//保存最后一个索引位置
            lastIndex[ chars[i]-'a' ] = i ;
        }
        for (int i = 0; i < len; i++) {
            if(vis[chars[i]-'a']) continue;//这个要放前面
            while (!st.isEmpty() && chars[st.peek()]>chars[i]
                    && lastIndex[chars[st.peek()]-'a']>i //这里是大于i
            )
            {
                Integer pop = st.pop();
                vis[chars[pop]-'a'] = false;
            }
            st.push(i);
            vis[chars[i]-'a'] =true;
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()){
            res.append(chars[st.pollLast()]);
        }
        return res.toString();

    }

}
