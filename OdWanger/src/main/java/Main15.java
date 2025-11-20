import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Main15 {
    public static void main(String[] args) {
        int[] nums1 =new int[]{4,1,2};
        int[] nums2 =new int[]{1,3,4,2};
        System.out.println(nextGreaterElement(nums1,nums2));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int [] res = new int[nums1.length];
        Map<Integer,Integer> temp_res = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            //没有重复元素，遍历过程将结果存到hash表，后面查找的快。
            temp_res.put(nums1[i], temp_res.getOrDefault(i,-1));
        }
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]>nums2[st.peek()]){
                Integer pop = st.pop();
                    //这里直接把当前元素，以及当前元素的下一个更大的元素存到哈希表
                    temp_res.put(nums2[pop],nums2[i] );
            }
            st.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] =  temp_res.get(nums1[i]);
        }

        return res;
    }
}
