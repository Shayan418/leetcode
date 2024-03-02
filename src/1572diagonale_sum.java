class _1572diagonale_sum {
    public static int diagonalSum(int[][] mat) {

        int sum = 0;
        int len = mat.length;
        for(int i = 0; i<len; ++i){
            sum += mat[i][i];
            sum += mat[len-1-i][i];

        }

        if (len % 2 == 0){
            return sum;
        } 

        return sum- mat[len/2][len/2];

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{7,3,1,9},{3,4,6,9},{6,9,6,6},{9,5,8,5}};

        System.out.println(diagonalSum(arr));
    }
}
