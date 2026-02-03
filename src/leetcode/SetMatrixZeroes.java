/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * Output:
 * ------
 * 1 0 1 
 * 0 0 0 
 * 1 0 1 
 * 
 * 0 0 0 0 
 * 0 4 5 0 
 * 0 3 1 0
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SetMatrixZeroes {

	class Idx {
		int i;
		int j;
		Idx(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public void setZeroes(int[][] matrix) {
        List<Idx> zeroes = new ArrayList<Idx>();
        
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == 0) {
        			zeroes.add(new Idx(i, j));
        		}
        	}
        }
        
        Iterator<Idx> itr = zeroes.iterator();
        while (itr.hasNext()) {
        	Idx node = itr.next();
        	for (int j = 0; j < matrix[0].length; j++) {
        		matrix[node.i][j] = 0;
        	}
        	for (int i = 0; i < matrix.length; i++) {
        		matrix[i][node.j] = 0;
        	}
        }
    }
	
	public static void main(String[] args) {
		int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
		new SetMatrixZeroes().setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.printf("%d ", matrix[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		int[][] matrix2 = {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
		new SetMatrixZeroes().setZeroes(matrix2);
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2[0].length; j++) {
				System.out.printf("%d ", matrix2[i][j]);
			}
			System.out.println();
		}
	}

}
