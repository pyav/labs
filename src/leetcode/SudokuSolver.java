/**
 * https://leetcode.com/problems/sudoku-solver/
 *
 * Output:
 * ------
 * 5 3 4 6 7 8 9 1 2 
 * 6 7 2 1 9 5 3 4 8 
 * 1 9 8 3 4 2 5 6 7 
 * 8 5 9 7 6 1 4 2 3 
 * 4 2 6 8 5 3 7 9 1 
 * 7 1 3 9 2 4 8 5 6 
 * 9 6 1 5 3 7 2 8 4 
 * 2 8 7 4 1 9 6 3 5 
 * 3 4 5 2 8 6 1 7 9
 */

import java.util.Arrays;

public class SudokuSolver {

    private boolean isValidSudoku(char[][] board, int row, int col, int val) {
        for (int j = 0; j < 9; j++) {
           if (board[row][j] == (char) val+'0') {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == (char) val+'0') {
                return false;
            }
        }
        int startRow = row - row%3;
        int startCol = col - col%3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i+startRow][j+startCol] == (char) val+'0') {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean calcSolveSudoku(char[][] board) {
		int row = -1;
		int col = -1;
		boolean found = false;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					row = i;
					col = j;
					found = true;
					break;
				}
			}
			if (found) {
				break;
			}
		}
        if (!found) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            if (isValidSudoku(board, row, col, i)) {
                board[row][col] = (char) (i + '0');
                if (calcSolveSudoku(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
	}

    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        calcSolveSudoku(board);
    }

    public static void main(String[] args) {
        char[][] board = {
                            {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}
                         };
        SudokuSolver obj = new SudokuSolver();
        obj.solveSudoku(board);
        obj.printBoard(board);
    }

}

