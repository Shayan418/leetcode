import java.util.Arrays;

class _1980FindUniqueBinaryString {
    int idx;
    _1980FindUniqueBinaryString(){
        idx = 0;
    }

    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);

        return helper(nums[0].length(), nums, new StringBuilder());
        
    }

    public String helper(int n, String[] nums, StringBuilder sb) {
        if(sb.length() == n){
            
            if(!sb.toString().equals(nums[idx])){
                return sb.toString();
            }
            ++idx;
            return null;
        }
        
        String a = helper(n, nums, sb.append('0'));
        if(a != null){
            return a;
        }
        sb.deleteCharAt(sb.length() - 1);
        a = helper(n, nums, sb.append('1'));
        if(!sb.isEmpty()){
            sb.deleteCharAt(sb.length() - 1);
        }

        if(a != null){
            return a;
        }

        return null;
    }

    public static void main(String[] args) {
        
        _1980FindUniqueBinaryString ob = new _1980FindUniqueBinaryString();

        System.out.println(ob.findDifferentBinaryString(new String[]{
            "111","011","000"
        }));
    }
}
