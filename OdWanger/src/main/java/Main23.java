import java.util.Scanner;

public class Main23 {
    static int total=0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] nums = new int[split.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            total+= nums[i];
        }

        backtrack(nums,0,0,0);

        System.out.println(min);
    }

    static void backtrack(int[] nums,int sum,int count,int startIndex){
        //参数： nums选择列表，sum选择的和，count选择的个数，startIndex起始索引，避免重复选取
        if(count >= 5){
            if(Math.abs(sum*2 - total)<min){
                min = Math.abs(sum*2 - total);
            }
            return;
        }
        for (int i = startIndex; i <nums.length+count +1 - 5 ; i++) {//剪枝，待选>要选
            //选择
            sum+=nums[i];
            count++;
            backtrack(nums,sum,count,startIndex+1);
            //回溯
            sum-=nums[i];
            count--;
        }
    }
}
