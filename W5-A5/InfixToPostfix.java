import java.util.Stack;

public class InfixToPostfix extends Operator{

    public String postfix(String infix) {
        StringBuilder postfix = new StringBuilder(); // String builder for postfix expression
        Stack<Character> stack = new Stack<>();      // Stack for operators

        int i = 0;
        while (i < infix.length()) {
            char ch = infix.charAt(i);

            if (ch == ' ' || ch == '\t') { // Simple whitespace ignore
                i++;
                continue;
            }

            // If digit, read the full number (multi-digit)
            if (Character.isDigit(ch)) {       
                StringBuilder number = new StringBuilder(); // For multi-digit number
                while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
                    number.append(infix.charAt(i));
                    i++;
                }
                postfix.append(number).append(" "); // Append full number + space
                continue; // Already moved i in inner loop
            }

            // If operand is a letter (like variable)
            if (Character.isLetter(ch)) {       
                postfix.append(ch).append(" "); // Append operand + space
                i++;
                continue;
            }

            // If '(', push to stack
            if (ch == '(') {                    
                stack.push(ch);
                i++;
                continue;
            }

            // If ')', pop until '('
            if (ch == ')') {                    
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // discard '('
                }
                i++;
                continue;
            }

            // If operator, handle precedence
            if (isOperator(ch)) {              
                while (!stack.isEmpty() && precValue(stack.peek()) >= precValue(ch)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch); // Just push on an empty stack
                i++;
            }
        }

        // Pop any remaining operators
        while (!stack.isEmpty()) {            
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim(); // Remove trailing space
    }

    // Operator precedence value assignment
    public int precValue(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; // For '(' or unknown
        }
    }
}