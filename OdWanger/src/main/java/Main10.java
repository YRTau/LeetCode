import java.util.HashMap;
import java.util.Scanner;

/*
给定一个含有N个正整数的数组, 求出有多少个连续区间（包括单个正整数）, 它们的和大于等于x。

输入描述

第一行两个整数N x（0 < N <= 100000, 0 <= x <= 10000000)

第二行有N个正整数（每个正整数小于等于100)。

输出描述

输出一个整数，表示所求的个数。

注意：此题对效率有要求，暴力解法通过率不高，请考虑高效的实现方式。

示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

3 7

3 4 7

输出

4

样例解释

第一行的3表示第二行数组输入3个数，第一行的7是比较数，用于判断连续数组是否大于该数；

组合为 3 + 4; 3 + 4 + 7; 4 + 7; 7; 都大于等于指定的7；所以共四组。

示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

10 10000

1 2 3 4 5 6 7 8 9 10

样例解释

所有元素的和小于10000，所以返回0。
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        //in.nextLine();
        //String[] nums = in.nextLine().split(" ");
        //读取第二行输入
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        //HashMap保存前缀和
        HashMap<Integer, Long> preVals = new HashMap<>();
        preVals.put(0, 0L);//使用Long避免整型溢出

        //计算前缀和
        int i = 1;
        while (i < n + 1) {
            long tempVal = preVals.get(i - 1) + nums[i - 1];
            preVals.put(i, tempVal);
            i++;
        }
        // 双指针逻辑

        long count = 0;
        int left = 0;

        // 对于每个右端点right
        for (int right = 1; right <= n; right++) {
            // 移动左指针，直到区间和小于x
            while (left < right && preVals.get(right) - preVals.get(left) >= x) {
                // 以left到right-1为起点的所有扩展都满足条件
                count += n - right + 1;
                left++;
            }

            // 确保left不会超过right
            if (left >= right) {
                left = right;
            }
        }

        System.out.println(count);
    }

}
