import java.util.*;

public class Main36  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cap = Integer.parseInt(in.nextLine());
        int ops_size = Integer.parseInt(in.nextLine());
        List<String> ops = new ArrayList<>();
        for (int i = 0; i < ops_size; i++) {
            ops.add(in.nextLine());
        }
        Map<String,File> map = new HashMap<>();
        int time = 1;
        for(String op : ops){
            String[] split = op.split(" ");
            if (split[0].equals("put")) {
                File x = new File(split[1],Integer.parseInt(split[2]),0,time);
                if (x.size>cap){ //删除逻辑
                cap = rin(x,map,cap);
                }
                map.put(x.name,x);
                cap -= x.size;
            }else if (split[0].equals("get")){
                File file = map.get(split[1]);
                if (file==null)continue;//注意非空
                file.count+=1;
                file.time = time;
                map.put(file.name,file);
            }
            time++;
        }
        if (map.isEmpty()) System.out.println("NONE");
        else {
            List<String> res = new ArrayList<>(map.keySet());
            Collections.sort(res);//答案字典序排序
            for (int i = 0; i < res.size() - 1; i++) {
                System.out.printf(res.get(i) + ",");
            }
            System.out.println(res.get(res.size() - 1));
        }
        }
static int rin(File x, Map<String,File> map,int cap){
    //对map排序
    //map转List
    List<File> map_list = new ArrayList<>(map.values());
    Collections.sort(map_list);
    int i = 0 ;
    while (x.size>cap) {
        File remove = map.remove(map_list.get(i).name);
        cap +=remove.size;
    }
    return cap;
    }


static class File implements Comparable<File>{
      String name;
      int size;
      int count;
      int time;
    File(String name,int size,int count,int time){
        this.name = name;
        this.size = size;
        this.count = count;
        this.time = time;
    }

    @Override
    public int compareTo(File o) {
        if (this.count!=o.count){
            return this.count - o.count;
        }else return this.time - o.time;
    }
}

}
