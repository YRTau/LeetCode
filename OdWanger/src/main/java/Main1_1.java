import java.util.LinkedList;
import java.util.Queue;
    import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class Main1_1 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[][] matrix = new int[n][n];
        Cell start = new Cell(0,0);
        Cell end= new Cell(0,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = in.nextInt();
                if(matrix[i][j] == -3){
                    start.x = i;
                    start.y = j;
                }
                if(matrix[i][j] == -2){
                    end.x = i;
                    end.y = j;
                }
            }
        }
        int[][] visited = new int[n][n];
        int[][] candys = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                visited[i][j] = 0;
                candys[i][j] = -1;
            }
        }

        //第一轮BFS找到最短时间
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(start);
        int time = 0;
        int flag = 0;
        while (true){
            if(queue.isEmpty()) {
                break;
            } else {
                int size = queue.size();
                for (int k=0;k<size;k++){
                    Cell cur = queue.poll();
                    if (cur.x == end.x && cur.y == end.y) {
                        flag = 1;
                        break;
                    }

                    for (int i=0;i<4;i++) {
                        int xx = cur.x + directions[i][0];
                        int yy = cur.y + directions[i][1];

                        if (xx >= 0 && xx < n && yy >= 0 && yy < n
                                && visited[xx][yy]==0 && matrix[xx][yy] != -1) {
                            visited[xx][yy] = 1;
                            Cell temp = new Cell(xx,yy);
                            queue.offer(temp);
                        }
                    }
                }
                if(flag==1){
                    break;
                }
                time += 1;
            }
        }

        if(flag==0){
            System.out.println(-1);
            return;
        }

        //第二轮BFS找到最大糖果数
        Queue<Cell> candy_queue = new LinkedList<>();
        candy_queue.offer(start);
        candys[start.x][start.y]=0;
        while(true){
            if(time <0){
                break;
            } else {
                int size = candy_queue.size();
                for (int k=0;k<size;k++){
                    Cell cur = candy_queue.poll();
                    for (int i=0;i<4;i++) {
                        int xx = cur.x + directions[i][0];
                        int yy = cur.y + directions[i][1];
                        if (xx >= 0 && xx < n && yy >= 0 && yy < n
                                &&  matrix[xx][yy] != -1) {
                            if(candys[xx][yy] == -1){
                                Cell temp = new Cell(xx,yy);
                                candy_queue.offer(temp);
                            }
                            if(matrix[xx][yy] != -2){
                                if(candys[cur.x][cur.y] + matrix[xx][yy] > candys[xx][yy]){
                                    candys[xx][yy] = candys[cur.x][cur.y] + matrix[xx][yy];
                                }
                            } else {
                                if(candys[cur.x][cur.y] > candys[xx][yy]){
                                    candys[xx][yy] = candys[cur.x][cur.y];
                                }
                            }
                        }
                    }
                }
            }
            time -=1;
        }

        System.out.println(candys[end.x][end.y]);

    }

    public static class Cell {
        int x;
        int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
