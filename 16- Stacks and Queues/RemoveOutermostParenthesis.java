import java.util.*;

public class RemoveOutermostParenthesis {
    public static void main(String[] args) {
        String str = "((()))(())(((())))";

        Stack<Character> stack = new Stack<>();
        int count = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
            }
            if(str.charAt(i) == ')'){
                // Keep popping the stack and storing it in some string till you reach at a point where more popping makes the stack empty
                while(!stack.isEmpty()){
                    stack.pop();
                    count += 1;
                }
                for(int j=1; j<count; j++){
                    System.out.print("(");
                }
                System.out.print(str.charAt(i));
                stack.push('(');
                // Now you are allowed to take the next 
            }
        }
    }
}
