import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main34 {
    // 创建一个静态的、可重用的格式化工具
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    // 辅助函数：将字符串解析为 LocalDateTime 对象
    private static LocalDateTime parseTime(String timeStr) {
        return LocalDateTime.parse(timeStr, FORMATTER);
    }

    // 辅助函数：将 LocalDateTime 对象格式化为字符串
    private static String formatTime(LocalDateTime dtObj) {
        return dtObj.format(FORMATTER);
    }

    // 辅助函数：返回两个时间中较晚的那个
    private static LocalDateTime max(LocalDateTime dt1, LocalDateTime dt2) {
        return dt1.isAfter(dt2) ? dt1 : dt2;
    }

    // 辅助函数：返回两个时间中较早的那个
    private static LocalDateTime min(LocalDateTime dt1, LocalDateTime dt2) {
        return dt1.isBefore(dt2) ? dt1 : dt2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- 1. 读取并解析用户的查询时间范围 ---
        String[] queryRangeParts = scanner.nextLine().split(",");
        LocalDateTime queryStartDt = parseTime(queryRangeParts[0]);
        LocalDateTime queryEndDt = parseTime(queryRangeParts[1]);

        // --- 2. 读取压缩日志的记录行数 ---
        int n = Integer.parseInt(scanner.nextLine());

        // 这个列表将用于存储最终的输出行
        List<String> results = new ArrayList<>();

        // --- 3. 逐行处理压缩日志记录 ---
        for (int i = 0; i < n; i++) {
            String[] logParts = scanner.nextLine().split(",");
            LocalDateTime logStartDt = parseTime(logParts[0]);
            LocalDateTime logEndDt = parseTime(logParts[1]);
            String kpi = logParts[2];

            // --- 4. 找到日志范围和查询范围的交集 ---
            LocalDateTime overlapStart = max(queryStartDt, logStartDt);
            LocalDateTime overlapEnd = min(queryEndDt, logEndDt);

            // --- 5. 对交集时段进行解压缩 ---
            if (!overlapStart.isAfter(overlapEnd)) { // 等价于 overlapStart <= overlapEnd
                // 从重叠的开始时间开始，逐分钟遍历到结束时间
                LocalDateTime currentTime = overlapStart;
                while (!currentTime.isAfter(overlapEnd)) {
                    // 每一分钟，都格式化输出字符串并添加到结果列表中
                    results.add(formatTime(currentTime) + "," + kpi);
                    // 将时间增加一分钟
                    currentTime = currentTime.plusMinutes(1);
                }
            }
        }
        scanner.close();

        // --- 6. 打印最终结果 ---
        if (results.isEmpty()) {
            System.out.println("-1");
        } else {
            // 将所有结果用换行符连接并打印
            System.out.println(String.join("\n", results));
        }
    }
}