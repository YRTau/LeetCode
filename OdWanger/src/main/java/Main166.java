import java.util.Arrays;
import java.util.Scanner;

public class Main166 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
             }

        int res = 0;
        Arrays.sort(nums);
        if(n%2==1){
            res = nums[n/2];
        }else{
            res = (nums[n/2-1]);
        }
        System.out.println(res);
    }
}
