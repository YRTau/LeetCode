import java.util.*;

public class Main7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nm = in.nextLine().split(" ");
        int n  = Integer.parseInt(nm[0]); //n个学生
        int m  = Integer.parseInt(nm[1]); //m个科目
        String[] sub = in.nextLine().split(" ");
//        List<String[]> table = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//             table.add(in.nextLine().split(" "));
//        }

        List<Student> all_student = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");
            String name = s[0];
            int[] score = new int[s.length-1];
            int total = 0;
            for (int j = 1; j < s.length; j++) {
                 score[j-1] =  Integer.parseInt(s[j]);
                total += Integer.parseInt(s[j]);
            }
        all_student.add(new Student(name,score,total));
        }

        int target_index = -1;
        if(in.hasNextLine()){
            String line = in.nextLine().trim();
            for (int i = 0; i < m; i++) {
                if(line.equals(sub[i])){
                    target_index = i;
                }
            }
        }
            Student.index = target_index;


        Collections.sort(all_student);
        for (Student stu : all_student ){
            System.out.println(stu.name);
        }

        // 检查是否有输入或者输入是否为空
//        if (in.hasNextLine()) {
//            String line = in.nextLine().trim();
//            if (line.isEmpty()) {
//                System.out.println("没有科目");
//            } else {
//                System.out.println("有科目");
//                // 处理科目名称
//            }
//        } else {
//            System.out.println("没有输入");
//        }


    }

   static  class Student implements Comparable<Student>{
        int total;
       static int index;
        String name;
        int[] score;
        public Student(String name,int[] score,int total){
            this.name = name;
            this.total= total;
            this.score = score;
        }
        @Override
        public int compareTo(Student o) {
            if(index ==-1){
                return o.total - this.total;
            }
            else {
              return   o.score[index] - this.score[index];
            }
        }
    }

}
