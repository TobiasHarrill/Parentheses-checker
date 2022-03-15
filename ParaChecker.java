/*
    Tobias Harrill
    Availity Homework Parentheses test

    Thoughts: use a stack to store any open parentheses "(" then if a closer ")" is found pop the opening out.
    Can be expanded upon if needed for brackets or curley brace [] {} <> with same process
 */

import java.util.Stack;

public class ParaChecker {
    public static boolean isValid(String s) {

        Stack<Character> paraStack = new Stack<>();

        // loop every character in the passed in string
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                paraStack.push(ch);
            }
            else if(ch == ')'){
                if(paraStack.isEmpty())
                    return false;
                else if(paraStack.peek() != '(')
                    return false;
                else paraStack.pop();
            }
        }
        // after looping passed string if the stack is empty then we won, if not then we lost
        if(paraStack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        String testStringTrue = "()";       //should always pass
        String testStringTrue2 = "((()))";  //should pass but more of them
        String testStringfalse = ")(";      //should fail always
        String testStringFalse2 = "((())";  //fail again but more of them

        System.out.println(isValid(testStringTrue));
        System.out.println(isValid(testStringTrue2));
        System.out.println(isValid(testStringfalse));
        System.out.println(isValid(testStringFalse2));

    }
}
