import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nums = in.nextLine().split(",");
        int n =  nums.length;
        String res = "";
        if (n>3) {
            Arrays.sort(nums, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() != o2.length()) {
                        return o1.length() - o2.length();
                    } else {

                        return (o1 + o2).compareTo(o2 + o1);
                    }
                }
            });
            String[] nums_final = new String[3];
            for (int i = 0; i < 3; i++) {
                nums_final[i] = nums[i];
            }

            Arrays.sort(nums_final, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o1 + o2).compareTo(o2 + o1);
                }
            });
            for(String num : nums_final){
                res+=num;
            }
        }
        else {
            String[] nums_final = new String[n];
            for (int i = 0; i < n; i++) {
                nums_final[i] = nums[i];
            }
            Arrays.sort(nums_final, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o1 + o2).compareTo(o2 + o1);
                }
            });
            for(String num : nums_final){
                res+=num;
            }

        }

        System.out.println(res);
    }
}
