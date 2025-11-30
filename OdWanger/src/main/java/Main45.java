import java.util.*;
/*
数字 n 代表生成括号的对数，请你设计一个函数，
用于能够生成所有可能的并且 有效的 括号组合。
示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]


提示：

1 <= n <= 8
 */

public class Main45 {
    static List<String> res = new ArrayList<>();
  static   public List<String> generateParenthesis(int n) {

        //选择列表不用传，就是（）括号选一个，需要传left跟right的数量方便选择
        dfs(new StringBuilder(),n,0,0);
        return  res;
    }
 static    void dfs(StringBuilder path, int n, int left,int right){
        if(path.length()>=2*n){
            if (path.length()==2*n) res.add(path.toString());
            return;
        }
            if(left<n) {
                path.append("(");
                dfs(path, n, left + 1, right);
                //left--; 这里不用减，因为是值传递
                path.deleteCharAt(path.length()-1);
                //这里必须删回去，因为path是引用，上面的递归改变了path这个对象
            }
            if (right<left){
                path.append(")");
                dfs(path,n,left,right+1);
                path.deleteCharAt(path.length()-1);
                //right--;
            }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    }

