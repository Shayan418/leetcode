import java.util.Stack;

public class _1106ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '!' || c == '&' || c == '|'){
                operatorStack.push(c);
                stack.push(c);
            }
            if(c == 't' || c == 'f'){
                stack.push(c);
            }

            if (c == ')'){
                boolean curr = stack.pop() == 't';
                while(!stack.isEmpty() && stack.peek() == 't' || stack.peek() == 'f'){
                    curr = switch (operatorStack.peek()) {
                        case '&' -> curr & stack.pop() == 't';
                        case '|' -> curr | stack.pop() == 't';
                        default -> curr;
                    };
                }

                if(stack.peek() == '!'){
                    curr = !curr;
                }

                stack.pop();
                operatorStack.pop();
                stack.push(curr ? 't' : 'f');
            }
        }

        return stack.pop() == 't';
    }


    public static void main(String[] args) {
        _1106ParsingABooleanExpression ob = new _1106ParsingABooleanExpression();

        System.out.println(ob.parseBoolExpr("!(&(f,t))"));

    }
}
