public class Operator {
    // Valid operators for OTP generator algo
    public boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public int performOperation(int x, int y, char operator) {
        // Assuming use case of these four operators only
        switch(operator){
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
