
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中 「优美子数组」 的数目。

输入描述：

第一行为逗号分割的正整数数组

第二行一个整数k

输出描述：

数组中 「优美子数组」 的数目

示例 1：

输入：
1,1,2,1,1
3
输出：
2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：
2,4,6
1
输出：
0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：
2,2,2,1,2,2,1,2,2,2
2
输出：
16

 */
public class Main11 {
    public static void main(String[] args) {
        // 1. 读取输入
        Scanner scanner = new Scanner(System.in);
        String[] numStrs = scanner.nextLine().split(",");
        int k = scanner.nextInt();
        scanner.close();

        int[] nums = new int[numStrs.length];
        for (int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }

        // 2. 初始化变量
        int result = 0;
        int oddCountPrefix = 0;
        // prefixCounts 是哈希表，存储每个前缀和（奇数个数）出现的次数
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        // 初始化：前缀和为0的出现1次（空前缀）
        prefixCounts.put(0, 1);

        // 3. 遍历数组
        for (int num : nums) {
            // a. 更新当前的前缀和
            if (num % 2 != 0) {
                oddCountPrefix++;
            }

            // b. 查找所需的目标前缀和
            int targetPrefix = oddCountPrefix - k;

            // c. 如果目标前缀和在哈希表中存在，累加其出现次数到结果中
            result += prefixCounts.getOrDefault(targetPrefix, 0);

            // d. 更新当前前缀和在哈希表中的计数
            prefixCounts.put(oddCountPrefix, prefixCounts.getOrDefault(oddCountPrefix, 0) + 1);
        }

        // 4. 打印结果
        System.out.println(result);
    }
}