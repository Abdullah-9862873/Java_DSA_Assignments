import java.util.*;

public class NextGreaterElement_I{
    public static void main(String[] args){
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] finalAns = new int[nums1.length];

        for(int i=0; i<nums2.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }

        for(int i=0; i<nums1.length; i++){
            finalAns[i] = map.get(nums1[i]);
        }

        System.out.println(Arrays.toString(finalAns));
    }
}