public class _221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] mat = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length; ++j){
                mat[i][j] = matrix[i][j] == '1' ? 1 : 0;
                System.out.print(mat[i][j] + " ");

            }
            System.out.println();
        }

        return solver(mat);
    }

    public int solver(int[][] matrix){

        int ans = 0;
        for(int i = 0; i < matrix.length; ++i){
            ans = Math.max(ans, matrix[i][0]);
        }
        for(int i = 0; i < matrix[0].length; ++i){
            ans = Math.max(ans, matrix[0][i]);
        }

        for(int i = 1; i < matrix.length; ++i){
            for(int j = 1; j < matrix[0].length; ++j){
                if(matrix[i][j] == 0){
                    System.out.print(matrix[i][j] + " ");
                    continue;
                }
                if(matrix[i-1][j] == matrix[i][j-1] && matrix[i-1][j-1] >= matrix[i-1][j] && matrix[i-1][j-1] > 0){
                    matrix[i][j] = matrix[i-1][j] + 1;
                } else if (matrix[i-1][j] == 0 ||  matrix[i][j-1] == 0){
                    System.out.print(matrix[i][j] + " ");
                    continue;
                } else if (Math.abs(matrix[i-1][j] - matrix[i][j-1]) > 1){
                    System.out.print("HIT");
                    matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
                System.out.print(matrix[i][j] + " ");
                ans = Math.max(ans, matrix[i][j]);
            }
            System.out.println();
        }

        return ans * ans;
    }

    public static void main(String[] args) {
        _221MaximalSquare obj = new _221MaximalSquare();
        char[][] matrix = new char[][]{{'0','0','0','1'},{'1','1','0','1'},{'1','1','1','1'},{'0','1','1','1'},{'0','1','1','1'}};
        System.out.println(obj.maximalSquare(matrix));

    }
}
