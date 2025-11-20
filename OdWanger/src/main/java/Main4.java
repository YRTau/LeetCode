import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        Arrays.sort(split,new Comparator<String>(){
                @Override
                public int compare(String a, String b ){
                    String a1 = a.substring(0,2);
                    String a2 = a.substring(2);
                    String b1 = b.substring(0,2);
                    String b2 = b.substring(2);
                    if(a1.compareTo(b1)!=0){
                        return a1.compareTo(b1);
                    }else return a2.compareTo(b2);
        }
        });
        for (int i = 0; i < split.length-1; i++) {
            System.out.print(split[i]+",");
        }
        System.out.println(split[split.length-1]);
    }
}
