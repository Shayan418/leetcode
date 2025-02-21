class _79WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for(int i = 0 ; i < board.length; ++i){
            for(int j = 0 ; j < board[0].length; ++j){
                if(helper(board, word, i, j, 0, isVisited))
                    return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, String word, int row, int col, int idx, boolean[][] isVisited){
        if(board[row][col] != word.charAt(idx)){
            return false;
        }
        ++idx;

        if(idx == word.length()){
            return true;
        }
        
        isVisited[row][col] = true;

        int[] x = new int[]{ 1, -1, 0,  0};
        int[] y = new int[]{ 0,  0, 1, -1};

        for(int i = 0 ; i < 4; ++i){
            int newx = row + x[i];
            int newy = col + y[i];

            if(newx >=0 && newy >= 0 && newx < board.length && newy < board[0].length && !isVisited[newx][newy]){
                if(helper(board, word, newx, newy, idx, isVisited)){
                    return true;
                }
            }

        }

        isVisited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        _79WordSearch ob = new _79WordSearch();

        System.out.println(ob.exist(new char[][]{{'A'}}, "A"));
        System.out.println(ob.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
        System.out.println(ob.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }
}
