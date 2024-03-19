import java.util.Arrays;
import java.util.TreeSet;

class _349IntersectionofTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int x = 0;
        int y = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        TreeSet<Integer> ans = new TreeSet<>();

        while(x < nums1.length && y < nums2.length){
            if(nums1[x] < nums2[y]){
                ++x;
            }

            else if(nums2[y] < nums1[x]){
                ++y;
            }
            
            else if(nums1[x] == nums2[y]){
                ans.add(nums1[x]);
                ++x;
                ++y;
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        //int[] ans = intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        int[] ans = intersection(new int[]{1,2}, new int[]{1,1});
        for(int a : ans){
            System.out.print(a + " ");
        }
    }
    
}
