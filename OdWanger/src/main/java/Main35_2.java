import java.util.Scanner;
import java.util.*;

class Main35_2 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        Character[][] matrix = new Character[m][n];
        in.nextLine();

        for(int i=0;i<m;i++){
            String[] strs = in.nextLine().split(" ");
            for(int j=0;j<n;j++){
                matrix[i][j] = strs[j].charAt(0);
            }
        }

        //最大的区域大小
        int max_area = 0;
        HashMap<String, Integer> zones = new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]=='O' && (i==0 || j==0 || i==m-1 || j==n-1)){
                    //先假定当前可以为入口
                    int area = calc_area(copy(matrix), i, j, true);//直接拿map 表示vis，走过的就原地修改，每次都传一个copy进来。
                    if (area > 0) {
                        String key = i + " " + j;
                        zones.put(key, area);
                        if (area > max_area) {
                            max_area = area;
                        }
                    }

                }
            }
        }

        //输出
        String max_entrace = "";
        for (Map.Entry<String, Integer> e : zones.entrySet()) {
            if (e.getValue() == max_area) {
                if (max_entrace.isEmpty()) {
                    max_entrace = e.getKey();
                } else {
                    max_entrace = "more";
                    break;
                }
            }
        }

        if (max_area == 0) {
            System.out.println("NULL");
        } else if (max_entrace == "more") {
            System.out.println(max_area);
        } else {
            System.out.println(max_entrace + " " + max_area);
        }

    }

    public static Character[][] copy(Character[][] a) {
        int m = a.length;
        int n = a[0].length;
        Character[][] matrix = new Character[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = a[i][j];
            }
        }
        return matrix;
    }

    public static int calc_area(Character[][] matrix, int i, int j, boolean flag) {
        if(!flag) {//这里是关键，表示刚进来的时候不用判断边界，
            //后面每次遍历都要判断是不是边界，如果是边界直接返回0了。
            if (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix[0].length - 1) {
                return 0;
            }
        }

        matrix[i][j] = 'X';
        int count = 1;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int newX = i + direction[0], newY = j + direction[1];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length &&
                    matrix[newX][newY] == 'O') {
                int count1 = calc_area(matrix, newX, newY, false);
                if (count1 == 0) {
                    return 0;
                }
                count += count1;
            }
        }

        return count;
    }
}