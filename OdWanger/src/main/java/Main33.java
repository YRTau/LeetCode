import java.util.*;
import java.util.stream.Collectors;

public class Main33 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        Integer[] sortList = Arrays.stream(in.nextLine().split(" ")).map(Integer::parseInt)
                .toArray(Integer[]::new);//stream直接转为Integer数组

        List<Goods> goodsList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            goodsList.add(new Goods(in.nextLine().split(" "),sortList)) ;
        }
        //进入排序
        Collections.sort(goodsList);

        for (int i = 0; i < goodsList.size(); i++) {
            System.out.println(goodsList.get(i));
        }
    }

   static class Goods implements Comparable<Goods> {
        List<Integer> value; //这里属性不确定个数，所以用List装
        Integer[] sortList;
        Goods(String[] nums,Integer[] sortList){ //构造函数
            this.value = Arrays.stream(nums).
                    map(Integer::parseInt).
                    collect(Collectors.toList());//stream生成List

            this.sortList = sortList;
        }

       @Override
        public int compareTo(Goods o) {//关键，自定义多属性排序，当前属性相等再继续下一轮排序
            for (int i = 0; i < value.size(); i++) {
                if (this.value.get(i) != o.value.get(i)) {// 当前属性不等
                    if (sortList[i]==1) { //降序
                        return o.value.get(i)-this.value.get(i);
                    }
                    else if(sortList[i]==-1){ //升序
                        return this.value.get(i)-o.value.get(i);
                    }
                }

            }
            return 0;//这里要有默认返回值，但是无所谓。
        }

       @Override
       public String toString() {//重写toString方便输出，选用
           StringBuilder res=  new StringBuilder();
           for (int i = 0; i < value.size()-1; i++) {
               res.append(value.get(i));
               res.append(" ");
           }
           res.append(value.get(value.size()-1));
           return res.toString();
       }
    }
}
