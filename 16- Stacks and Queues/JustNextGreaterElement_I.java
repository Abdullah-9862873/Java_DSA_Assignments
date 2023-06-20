/*
The question is that you have two num arrays

num1 = {4,1,2}
num2 = {1,3,4,2}

The answer should be {-1,3,-1}

Because:
--> For 4, there is no greater element after 4, so this will give -1
--> For 1, the just greater element after 1 which is present in num2 array is 2 which is at index 3 so this will give 3
--> For 2, there is no element after 2 in the array num2, so it will give -1

{-1,3,-1}
 */
import java.util.*;


public class JustNextGreaterElement_I{
    public static void main(String[] args) {
        int[] num1 = {4,1,2};
        int[] num2 = {1,3,4,2};

        int[] ans = new int[num1.length];

        for(int i=0; i<num1.length; i++){
            for(int j=0; j<num2.length; j++){
                if(num1[i] == num2[j]){
                    ans[i] = j;
                }
            }
        }

        int[] finalAns = new int[num1.length];
        int indexFinalAns = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0; i<ans.length; i++){
            int index = ans[i];
            int value = num2[index];

            if(index == num2.length-1){
                finalAns[indexFinalAns] = -1;
                indexFinalAns++;
            }
            else if(index == num2.length-2){
                if(num2[index+1] > value){
                    if(stack.isEmpty()){
                        stack.push(num2[index+1]);
                        finalAns[indexFinalAns] = index+1;
                        indexFinalAns++;
                    }else{
                        if(stack.peek() > num2[index+1]){
                            stack.pop();
                            stack.push(num2[index+1]);
                            finalAns[indexFinalAns] = index+1;
                            indexFinalAns++;
                        }
                    }
                }else{
                    finalAns[indexFinalAns] = -1;
                    indexFinalAns++;
                }
            }else{
                for(int j=index; j<num2.length; j++){
                    while(j != num2.length-1){
                        if(num2[j+1] > value){
                            if(stack.isEmpty()){
                                stack.push(num2[j+1]);
                                finalAns[indexFinalAns] = j+1;
                            }else{
                                if(stack.peek() > num2[j+1]){
                                    stack.pop();
                                    stack.push(num2[j+1]);
                                    finalAns[indexFinalAns] = j+1;
                                }
                            }
                        }
                        j++;
                    }
                    indexFinalAns++;
                }
            }
        }

        System.out.println(Arrays.toString(finalAns));
    }
}