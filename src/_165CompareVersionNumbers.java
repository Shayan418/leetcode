public class _165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int x = 0; 
        int y = 0;

        while (x < version1.length() && y < version2.length()) {
            int curr = x;
            while (curr != version1.length() && version1.charAt(curr) != '.') {
                ++curr;
            }

            int v1 = Integer.parseInt(version1.substring(x, curr));
            x = curr+1;

            curr = y;
            while (curr != version2.length() && version2.charAt(curr) != '.') {
                ++curr;
            }

            int v2 = Integer.parseInt(version2.substring(y, curr));
            y = curr + 1;

            if(v1 < v2){
                return -1;
            } 

            if (v2 < v1) {
                return 1;
            }
        }

        while (x < version1.length()) {
            if(version1.charAt(x) >= '1' && version1.charAt(x) <= '9'){
                return 1;
            }
            ++x;
        }

        while (y < version2.length()) {
            if(version2.charAt(y) >= '1' && version2.charAt(y) <= '9'){
                return -1;
            }
            ++y;
        }

        return 0;
    }

    public static void main(String[] args) {
        _165CompareVersionNumbers ob = new _165CompareVersionNumbers();
        System.out.println(ob.compareVersion("1", "1.1"));        
        System.out.println(ob.compareVersion("1.0", "1.0.0"));        
        System.out.println(ob.compareVersion("1.01", "1.001"));        
    
    }
}
