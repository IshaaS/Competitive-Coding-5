//https://leetcode.com/problems/valid-sudoku/
// Time Complexity :O(n*n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//for checking each condition, we iterate through all rows, all coloumns, all blcoks one by one, and use a boolean
//array to check if the element already exist or not.

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        //row
        for (int r = 0; r < N; r++) {
            boolean[] row = new boolean[N];
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.') continue;
                int pos = board[r][c] - '1';
                if (row[pos]) return false;
                row[pos] = true;
            }
        }
        //column
        for(int c=0;c<N;c++){
            boolean[] column = new boolean[N];
            for(int r=0; r<N;r++){
                if (board[r][c] == '.') continue;
                int pos = board[r][c] - '1';
                if (column[pos]) return false;
                column[pos] = true;
            } 
        }
        //block
        for(int b=0;b<N;b++){
            boolean[] block = new boolean[N];
            for(int i=(b/3)*3;i<(b/3)*3+3;i++){
                for(int j=b%3*3;j<b%3*3+3;j++){
                    if (board[i][j] == '.') continue;
                    int pos = board[i][j] - '1';
                    if (block[pos]) return false;
                    block[pos] = true;
                }
            }
        }
        return true;
    }
}