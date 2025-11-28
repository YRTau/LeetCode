
import java.util.Scanner;
import java.util.*;

public class Main37 {
    public static void main(String[] args) {
        //处理输入：读取一行整数，用空格分隔
        Scanner in=new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(asteroidCollision(nums));
        return;
    }

    /**
     * 模拟荒岛逃生过程
     * @param asteroids 代表每个人的体力值，正数表示向右逃生，负数表示向左逃生
     * @return 最终能够逃生的人数
     */
    public static int asteroidCollision(int[] asteroids) {
        // 使用双端队列（栈）来存储向右逃生的人
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int i=0;
        int left_cnt = 0; // 统计向左逃生成功的人数

        // 遍历每个人
        while(true){
            if(i>=asteroids.length){
                break;
            } else {
                // 当前人向左逃生（负数）
                if(asteroids[i] <=0) {
                    // 处理与向右逃生的人相遇的情况
                    while (true) {
                        if (stack.isEmpty()) {
                            // 没有向右逃生的人，可以直接向左逃生
                            left_cnt +=1;
                            break;
                        }
                        // 检查相遇后的结果
                        int sum = asteroids[i] + stack.peekLast();
                        if (sum > 0) {
                            // 向右逃生的人体力更大，获胜并减少相应体力
                            Integer i1 = stack.removeLast();
                            stack.addLast(asteroids[i] + i1);
                            break;
                        } else if (sum < 0) {
                            // 向左逃生的人体力更大，获胜并减少相应体力
                            asteroids[i] = asteroids[i] + stack.peekLast();
                            stack.removeLast();
                        } else if (sum == 0){
                            // 体力相同，同归于尽
                            stack.removeLast();
                            break;
                        }
                    }
                } else {
                    // 当前人向右逃生（正数），直接加入栈中
                    stack.addLast(asteroids[i]);
                }
            }
            i+=1;
        }

        // 统计最终逃生人数：向左逃生成功的人数 + 向右逃生的人数
        int right_cnt = stack.size();
        return left_cnt+right_cnt;
    }
}