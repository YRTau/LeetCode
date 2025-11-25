import java.util.Scanner;

public class Main31 {
    // 迷宫矩阵：存储每个方格的状态
    // 状态定义：0-初始未标记 1-障碍物 2-可达方格 3-陷阱方格
    private static int[][] maze;
    // 迷宫的X轴（列数）和Y轴（行数），对应题目中的X和Y
    private static int xSize;
    private static int ySize;
    public static void main(String[] args) {
        // 1. 读取输入数据
        Scanner scanner = new Scanner(System.in);

        // 读取迷宫尺寸：第一行输入X（列数）和Y（行数）
        xSize = scanner.nextInt();
        ySize = scanner.nextInt();

        // 读取障碍物数量N：第二行输入障碍物个数
        int obstacleCount = scanner.nextInt();

        // 初始化迷宫矩阵：行对应Y，列对应X，初始值均为0（未标记）
        maze = new int[ySize][xSize];

        // 读取N个障碍物坐标，设置障碍物状态为1
        for (int i = 0; i < obstacleCount; i++) {
            // 障碍物坐标（obstacleX, obstacleY），对应迷宫的列和行
            int obstacleX = scanner.nextInt();
            int obstacleY = scanner.nextInt();
            // 验证坐标合法性（题目说明输入合法，此处可省略，但保留增强鲁棒性）
            if (obstacleX >= 0 && obstacleX < xSize && obstacleY >= 0 && obstacleY < ySize) {
                maze[obstacleY][obstacleX] = 1;
            }
        }


    // 2. 检查起点合法性：若起点(0,0)是障碍物，则无法出发，所有方格均不可达/陷阱
        if (maze[0][0] == 1) {
            countAndOutput();
            return;
        }

        // 3. 深度优先搜索（DFS）：从起点(0,0)出发，标记可达方格和陷阱方格
        dfs(0, 0);

        // 4. 统计陷阱方格和不可达方格数量，并输出结果
        countAndOutput();


    }

    private static void dfs(int x, int y) {
                // 终止条件1：坐标越界（超出迷宫范围），直接返回
        if (x >= xSize || y >= ySize) {
            return;
        }

        // 终止条件2：当前方格是障碍物（1）或已标记（2/3），直接返回（避免重复遍历）
        if (maze[y][x] == 1 || maze[y][x] == 2 || maze[y][x] == 3) {
            return;
        }

        // 终止条件3：当前方格是终点(xSize-1, ySize-1)，标记为可达（2），返回
        if (x == xSize - 1 && y == ySize - 1) {
            maze[y][x] = 2;
            return;
        }
        // 递归逻辑：向X增加方向（右）和Y增加方向（下）搜索
        // 先搜索右边方格（x+1, y）
        dfs(x + 1, y);
        // 再搜索下边方格（x, y+1）
        dfs(x, y + 1);

        // 回溯标记：根据子路径结果标记当前方格状态
        // 若右边或下边存在可达路径（子方格是2），则当前方格可达（2）
        if ((x + 1 < xSize && maze[y][x + 1] == 2) || (y + 1 < ySize && maze[y + 1][x] == 2)) {
            maze[y][x] = 2;
        } else {
            // 若右边和下边均无可达路径，则当前方格是陷阱（3）
            maze[y][x] = 3;
        }

    }

        /**
     * 统计陷阱方格（3）和不可达方格（0）的数量，并按格式输出
     */
    private static void countAndOutput() {
        int trapCount = 0;    // 陷阱方格数量（状态3）
        int unreachableCount = 0; // 不可达方格数量（状态0，仅可能是起点被障碍物堵塞的情况）

        // 遍历整个迷宫矩阵，统计对应状态的方格数量
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                if (maze[y][x] == 3) {
                    trapCount++;
                } else if (maze[y][x] == 0) {
                    unreachableCount++;
                }
                // 状态1（障碍物）和2（可达）不统计
            }
        }

        // 输出结果：陷阱数量 空格 不可达数量
        System.out.println(trapCount + " " + unreachableCount);
    }
}
