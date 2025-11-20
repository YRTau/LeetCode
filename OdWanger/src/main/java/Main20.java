import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main20 {
    public static void main(String[] args) {
        List<String> out = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split("\\s+");
        int[] nums = new int[split.length];


        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            out.add(split[i]);
        }

        System.out.println(out);
    }
}
