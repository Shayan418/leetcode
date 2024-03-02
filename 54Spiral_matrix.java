import java.util.ArrayList;
import java.util.List;

class _54Spiral_matrix {

    public static List<Integer> spiralMatrix(int[][] matrix) {

        ArrayList<Integer> ans = new ArrayList<Integer>();

        int size = matrix.length;
        int sizeTB = matrix[0].length;

        for (int x = 0; x < Math.max(size, sizeTB) / 2; ++x) {

            int row = x;
            int col = x;
            //int realSize = size - x * 2;
            int border = size - x - 1;
            int borderTB = sizeTB - x - 1;

            for (int j = col; j < borderTB; ++j, ++col) {
                ans.add(matrix[row][col]);
                //System.out.println(matrix[row][col]);
            }
            col = borderTB;

            for (int i = row; i < border; ++i, ++row) {
                ans.add(matrix[i][col]);
                //System.out.println(matrix[i][col]);
                
            }
            row = border;

            for (int j = col; j > x; --j, --col) {
                ans.add(matrix[row][col]);
                //System.out.println(matrix[row][col]);
            }
            col = x;

            for (int i = row; i > x; --i, --row) {
                ans.add(matrix[row][col]);
                //System.out.println(matrix[row][col]);
            }
        }

        if(size == sizeTB && size % 2 ==1){
            ans.add(matrix[size/2][size/2]);
        }
        

        return ans;

    }

    public static void main(String[] args) {
        //int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        //int[][] arr = new int[][] { { 1, 2, 3, 4, 5}, { 6,7,8,9,10 }, {11,12,13,14,15  },{16,17,18,19,20}, {21,22,23,24,25} };

        int[][] arr = new int[][] { { 1, 2, 3 } };

        //int[][] arr = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        //int[][] arr = new int[][] {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

        System.out.println(spiralMatrix(arr));
    }
}
