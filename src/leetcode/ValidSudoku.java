/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Output:
 * ------
 * true
 * false
 */

package leetcode;

import java.util.Arrays;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] gridCheck = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            Arrays.fill(rowCheck[i], false);
            Arrays.fill(colCheck[i], false);
            Arrays.fill(gridCheck[i], false);
        }
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int val = board[i][j] - '0';
                if (!rowCheck[i][val-1]) {
                    rowCheck[i][val-1] = true;
                } else {
                    return false;
                }
                if (!colCheck[j][val-1]) {
                    colCheck[j][val-1] = true;
                } else {
                    return false;
                }
                if (!gridCheck[((i/3)*3)+(j/3)][val-1]) {
                    gridCheck[((i/3)*3)+(j/3)][val-1] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = { {'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},
                           {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'},
                           {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'},
                           {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'},
                           {'.','.','.','.','8','.','.','7','9'} };
        System.out.println(new ValidSudoku().isValidSudoku(board));
        char[][] board2 = { {'8','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},
                           {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'},
                           {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'},
                           {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'},
                           {'.','.','.','.','8','.','.','7','9'} };
        System.out.println(new ValidSudoku().isValidSudoku(board2));
    }

}

