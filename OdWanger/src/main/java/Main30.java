import java.util.Scanner;

public class Main30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int step1 = 1;
        int step2 = 1;
        int step3 = 2;
        int step4 = 0;
        //外面初始化
        if (n<=2)step4 = 1;
        else if (n==3) step4 =2;

        //里面递推
        for (int i = 4; i <=n; i++) {
                step4 = step1+step3;
                //迭代
                step1 = step2;
                step2 = step3;
                step3 = step4;
        }
        System.out.println(step4);
    }
}
