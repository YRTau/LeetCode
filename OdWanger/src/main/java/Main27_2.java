import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main27_2 {

        public static void main(String[] args) {
            // 读取输入（字符串 + 序列长度）
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            String s = parts[0]; // 打乱的字符字符串
            int k = Integer.parseInt(parts[1]); // 连续序列的长度
            sc.close();

            // 1. 统计打乱字符串的字符频次（目标频次）
            Map<Character, Integer> targetFreq = new HashMap<>();
            for (char c : s.toCharArray()) {
                targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
            }

            int n = s.length();
            // 2. 确定最小数字的最大可能长度：总长度 - (k-1)（避免序列拼接后长度超界）
            int maxLen = n - (k - 1);

            // 3. 枚举最小数字的可能长度（从1位到maxLen位）
            for (int len = 1; len <= maxLen; len++) {
                // 4. 遍历所有长度为len的子串（候选最小数字的字符组合）
                for (int i = 0; i <= n - len; i++) {
                    String candidateStr = s.substring(i, i + len);
                    // 跳过以0开头的子串（正整数不能以0开头）
                    if (candidateStr.charAt(0) == '0') {
                        continue;
                    }

                    // 5. 生成候选最小数字对应的连续k个数字
                    long start = Long.parseLong(candidateStr); // 用long避免int溢出
                    StringBuilder sequenceSb = new StringBuilder();
                    for (int t = 0; t < k; t++) {
                        sequenceSb.append(start + t);
                    }
                    String sequenceStr = sequenceSb.toString();

                    // 6. 验证当前序列的字符频次是否与目标频次一致
                    if (sequenceStr.length() != n) { // 长度不一致直接跳过
                        continue;
                    }
                    Map<Character, Integer> currentFreq = new HashMap<>();
                    for (char c : sequenceStr.toCharArray()) {
                        currentFreq.put(c, currentFreq.getOrDefault(c, 0) + 1);
                    }

                    // 7. 频次完全匹配则输出最小数字（题目保证唯一解）
                    if (currentFreq.equals(targetFreq)) {
                        System.out.println(start);
                        return;
                    }
                }
            }
        }
    }

