import java.util.Deque;
import java.util.LinkedList;

public class Main14 {
/*
请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是
 */
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new LinkedList<>();//Deque模拟栈
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            //这里要while出栈到不能出为止
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()] ) {
                    Integer pop = st.pop();
                    res[pop] = i - pop;
            }
                    //每一次都要入栈其实，注意出入栈的都是i索引。
                    st.push(i);
        }
        return res;
    }

}
