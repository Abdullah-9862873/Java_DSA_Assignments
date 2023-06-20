import java.util.*;

public class ValidParenthesis {
    public static void main(String[] args) {
        boolean ans = true;
        String str = "(){}[]{}([)]";

        Stack<Character> stack1 = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        // Making the map
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ']' || str.charAt(i) == '}' || str.charAt(i) == ')'){
                if(stack1.isEmpty()){
                    ans = false;
                    break;
                }else{
                    if(stack1.peek() == map.get(str.charAt(i))){
                        stack1.pop();
                    }else{
                        ans = false;
                        break;
                    }
                }
            }
            else if(str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '('){
                if(i == str.length()-1){
                    ans = false;
                    break;
                }
                stack1.push(str.charAt(i));
            }
        }
        if(!stack1.isEmpty()){
            ans = false;
        }
        System.out.println(ans);
    }
}
