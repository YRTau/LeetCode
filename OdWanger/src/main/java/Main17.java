import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int[] nnums = new int[nums.length*2];
        for (int i = 0; i < nnums.length; i++) {
            nnums[i] = nums[i%nums.length];
        }
        Arrays.fill(nums,-1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nnums.length; i++) {
            while(!st.isEmpty() && nnums[st.peek()]< nnums[i]){
                Integer pop = st.pop();
                nums[pop%nums.length] = nnums[i];
            }
            st.push(i);
        }

        for (int i = 0; i <nums.length-1; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println(nums[nums.length-1]);
    }
}
