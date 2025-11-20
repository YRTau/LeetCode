import java.util.Arrays;
import java.util.Scanner;

public class Main12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int sumLeft = 0 ;
        int sumRight = Arrays.stream(nums).sum();
        for(int i = 0 ;i<nums.length;i++){
            sumRight = sumRight - nums[i];
            //若左侧元素和等于右侧元素和，返回中心下标
            if(sumRight == sumLeft ){
                return i;
            }
            sumLeft +=nums[i];
        }
        return -1;
    }
}
