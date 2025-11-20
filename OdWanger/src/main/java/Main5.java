import java.util.*;

public class Main5 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int proNum = in.nextInt();
        in.nextLine();
        String[] wight = in.nextLine().split(" ");
        List<String[]> pros = new ArrayList<>();
        for (int i = 0; i < proNum; i++) {
            pros.add(in.nextLine().split(" "));
        }

        pros.sort((a, b) -> {
          int ascore = 0;
          int bscore = 0;
             for (int i = 1; i < a.length; i++) {
                 ascore+=Integer.parseInt(a[i])* Integer.parseInt(wight[i-1]);
                 bscore+=Integer.parseInt(b[i])* Integer.parseInt(wight[i-1]);
             }
             if (ascore!=bscore)
             return bscore - ascore;
             else return b[0].compareToIgnoreCase(a[0]);
         });

//                pros.sort(new Comparator<String[]>() {
//            @Override
//           public int compare(String[] a,String[] b){
//             int ascore = 0;
//             int bscore = 0;
//                for (int i = 1; i < a.length; i++) {
//                    ascore+=Integer.parseInt(a[i])* Integer.parseInt(wight[i-1]);
//                    bscore+=Integer.parseInt(b[i])* Integer.parseInt(wight[i-1]);
//                }
//                if (ascore!=bscore)
//                return bscore - ascore;
//                else return b[0].toLowerCase().compareTo(a[0].toLowerCase());
//            }
//        });


    for (String[]pro : pros){
        System.out.println(pro[0]);
    }
    }
}
