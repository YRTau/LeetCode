import java.util.*;

public class Main18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i]= Integer.parseInt(split[i]);
        }
        int[] right = new int[nums.length];
        int[] left = new int[nums.length];
        Arrays.fill(right,-1);
        Arrays.fill(left,-1);
        //单减栈，往右遍历
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]){
                Integer pop= st.pop();
                    right[pop] = i;
            }

            st.push(i);
        }
        while (!st.isEmpty())st.pop();
        //单增栈，往左边遍历
        for (int i = left.length-1; i >=0 ; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]){
                Integer pop = st.pop();
                    left[pop] = i;
                }
            st.push(i);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(left[i]!=-1&&right[i]!=-1){
                int distance = right[i] - left[i];
                res = Math.min(distance,res);
            }
        }
        System.out.println(res==Integer.MAX_VALUE?-1:res);
    }
}
