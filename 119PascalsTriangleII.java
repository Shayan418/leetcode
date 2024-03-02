import java.util.ArrayList;
import java.util.List;

class _119PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if(rowIndex == 0){ return ans;}
        ans.add(1);
        if(rowIndex == 1){ return ans;}

        int prev, curr;

        while(ans.size() != rowIndex + 1){
            prev = ans.get(0);
            curr = ans.get(1);

            for(int i = 1; i < ans.size(); ++i){
                ans.set(i, prev + curr);
                prev = curr;
                
                if(i == ans.size() - 1){break;}
                curr = ans.get(i+1);
            }
            //ans.add(curr + 1);
            ans.add(1);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        _119PascalsTriangleII ob = new _119PascalsTriangleII();

        System.out.println(ob.getRow(3));
    }
}
