import java.util.Stack;

class _1614MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for(Character ch : s.toCharArray()){
            if(ch.equals('(')){
                st.push(ch);
            } else if (ch.equals(')')){
                st.pop();
            }
            ans = Math.max(ans, st.size());
        }
        return ans;
    }
}
