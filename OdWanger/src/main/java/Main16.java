import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main16 {
        public int[] nextGreaterElements(int[] nums) {
            int[] nnums = new int[nums.length*2];
            for (int i = 0; i < nnums.length; i++) {
                int j = i%nums.length;
                nnums[i] =  nums[j];
            }
            //用nums装答案
            Arrays.fill(nums,-1);
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < nnums.length; i++) {
                while(!st.isEmpty()&&nnums[st.peek()] < nnums[i]){
                    int pop = st.pop();
                    // 直接记下更大的值
                    nums[pop] = nnums[i];

                }

                st.push(i);
            }

            return nums;
        }
}
