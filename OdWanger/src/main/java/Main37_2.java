
import java.util.*;
/**
 * 荒岛逃生问题
 *
 * 题目描述：
 * 有一个荒岛，只有左右两个港口，只有一座桥连接这两个港口。
 * 现在有一群人需要从两个港口逃生，有的人往右逃生，有的往左逃生。
 * 如果两个人相遇，则PK，体力值大的能够打赢体力值小的，体力值相同则同归于尽，
 * 赢的人才能继续往前逃生，并减少相应的体力。
 *
 * 输入描述：
 * 一行非0整数，用空格隔开，正数代表向右逃生，负数代表向左逃生
 *
 * 输出描述：
 * 最终能够逃生的人数
 *
 * 示例1：
 * 输入：5 10 8 -8 -5
 * 输出：2
 * 说明：8与-8相遇，同归于尽；10遇到-5，打赢并减少五点体力；
 * 最终逃生的为5，5，均从右侧港口逃生，输出2
 */
public class Main37_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Deque<Integer> st = new ArrayDeque<>();// 使用双端队列模拟向右逃生的人群
        int left_count = 0;// 统计向左逃生成功的人数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<0){
                while (!st.isEmpty()){

                    int pk = nums[i] + st.peek();// 向左逃生的人与栈顶的向右逃生者PK
                    if (pk == 0){
                        st.pop();
                        nums[i] = pk;
                        break;
                    }else if (pk > 0){// 向右逃生者获胜，体力减少
                        st.pop();
                        st.push(pk);
                        nums[i] = pk;
                        break;
                    }else {// 向左逃生者获胜，向右逃生者被消灭，继续跟栈顶pk
                        nums[i] = pk;
                        st.pop();
                    }

                }
                if (nums[i]<0) left_count+=1; // 没有向右逃生的人，向左逃生的人可以直接逃脱
            }else{
                st.push(nums[i]);// 当前人向右逃生（正数），直接加入栈中
            }
        }

        int res = st.size() + left_count;
        System.out.println(res);
    }
}