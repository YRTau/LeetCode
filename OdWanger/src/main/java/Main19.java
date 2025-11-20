import java.beans.Introspector;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split("\\s+");
        int[]  nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int[] nnums = new int[nums.length*2];

        for (int i = 0; i < nnums.length; i++) {
            nnums[i] = nums[i%nums.length];
        }
        Arrays.fill(nums,0);

        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nnums.length; i++) {
            while (!st.isEmpty() && nnums[st.peek()]> nnums[i]){
                Integer pop = st.pop();
                nums[pop%nums.length] = nnums[i];
            }
            st.push(i);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
                res[i] = nnums[i] + nums[i];
        System.out.print(res[i]+" ");
        }
    }
}
