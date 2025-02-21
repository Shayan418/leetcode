public class _2375ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        pattern = 'I' + pattern;

        int[] ans = new int[pattern.length()+1];
        int curr = 0;

        for(int i = 0; i < pattern.length(); ++i){
            int dcount = 0;
            
            if(pattern.charAt(i) == 'I'){
                curr = ans[i+1] = Math.max(curr, ans[i]) + 1;
            }
            else if(pattern.charAt(i) == 'D'){
                ans[i+1] = ans[i] - 1;
            }


            if(i + 1  < pattern.length() && pattern.charAt(i) == 'I' && pattern.charAt(i+1) == 'D'){
                int j = i+1; 
                while(j < pattern.length() && pattern.charAt(j) == 'D'){
                    ++dcount;
                    ++j;
                }
                //++dcount;
                curr += dcount;
                ans[i+1] = curr;
                //++i;
            }


        }



        StringBuilder res = new StringBuilder();

        for (int i = 1; i < ans.length; ++i) {
            res.append(ans[i]);
        }


        return res.toString();

    }

    public static void main(String[] args) {
        _2375ConstructSmallestNumberFromDIString ob = new _2375ConstructSmallestNumberFromDIString();

        System.out.println(ob.smallestNumber("IIIDIDDD"));


    }
}
