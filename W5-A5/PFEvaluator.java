import java.util.Stack;

public class PFEvaluator extends Operator{
    public int evaluate(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.split(" "); // Assuming correctly formatted with whitespace separator

        for(String token : tokens) {
            if(isOperator(token.charAt(0))){
                int x = stack.pop(); // second operand                                                 
                int y = stack.pop(); // first operand
                int result = performOperation(y, x, token.charAt(0));
                stack.push(result);                                                   
            } else {
                stack.push(Integer.parseInt(token));                               
            }
            
        }
        return stack.pop();   
    }
}
