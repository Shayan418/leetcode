import java.util.Arrays;

class _238ProductofArrayExceptSelf {
    public static int[] productExceptSelf2(int[] nums) {
        
        int zeros = 0;
        int zidx = -1;
        int[] pf = new int[nums.length];

        if(nums[0] == 0){
            ++zeros;
            zidx = 0;
            pf[1] = nums[1];
        } else {
            pf[0] = nums[0];
        }

        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == 0){
                ++zeros;
                zidx = i;
                pf[i] = pf[i-1];
            } else {
                pf[i] = pf[i-1] == 0 ? nums[i] : pf[i-1] * nums[i];
            }
        }

        if(zeros > 1){
            pf = new int[nums.length];
            return pf;
        } else if (zeros == 1){
            int temp = pf[pf.length - 1];
            Arrays.fill(pf, 0);
            pf[zidx] = temp;
            return pf;
        }

        int sf = 1;
        for(int i = nums.length - 1; i >= 0; --i){
            if(i == 0){
                pf[i] = sf;
                return pf;
            }
            pf[i] = pf[i-1] * sf;
            sf *= nums[i];
        }

        return pf;        

    }
    
    public static int[] productExceptSelf(int[] nums) {
        
        int[] pf = new int[nums.length];
        pf[0] = 1;

        for(int i = 1; i < nums.length; ++i){
            pf[i] = nums[i-1] * pf[i-1];
        }

        int sf = 1;
        for(int i = nums.length - 1; i >=0; --i){
            pf[i] = pf[i] * sf;
            sf = sf * nums[i];
        }

        return pf;
    }
    public static void main(String[] args) {
 //       int ans[] = productExceptSelf(new int[] {1,2,3,4}); 
       int ans[] = productExceptSelf(new int[] {-1,1,0,-3,3}); 
        
        for(int n:ans){
            System.out.print(n + " ");
        }
    }
    
}
