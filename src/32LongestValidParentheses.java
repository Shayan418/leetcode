import java.util.Stack;

class _32LongestValidParentheses {
    public static int longestValidParentheses(String A) {
        Stack<Character> st = new Stack<>();

        int realAns = -1;

        int old = 0;
        int ans = 0;

        for (int i = 0; i < A.length(); ++i) {
            if (st.empty()) {
                ans = ans + old;
                if (ans > realAns) {
                    realAns = ans;
                    ;
                }
                old = ans;
                ans = 0;
            }
            char ch = A.charAt(i);

            if (ch == '(') {
                st.push(ch);
                ++ans;
            } else {
                if (st.empty()) {

                    if (ans > realAns) {
                        realAns = ans;
                    }
                    old = 0;
                    ans = 0;
                } else {
                    st.pop();
                    ++ans;
                }
            }

        }

        if (st.empty()) {
            ans = ans + old;

            if (ans > realAns) {
                realAns = ans;
            }

            return realAns;
        }

        if (ans > realAns) {
            realAns = ans;
        }

        return realAns - st.size();
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(")()())()()("));

        String s = "()(()()";
        System.out.println(longestValidParentheses(s));

        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(
                ")(()((()())((()(()()((())((()((())(()))))))()()))(()(()(((((((())))()))(((()(((()())((((()))))())))("));

    }
}
