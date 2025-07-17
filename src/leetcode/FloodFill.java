/**
 * https://leetcode.com/problems/flood-fill/
 *
 * Output:
 * ------
 * 2 2 2 
 * 2 2 0 
 * 2 0 1 
 * 
 * 0 0 0 
 * 0 0 0 
 */

import java.util.Arrays;

public class FloodFill {
    private void performFloodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
            return;
        }
        image[sr][sc] = newColor;
        performFloodFill(image, sr+1, sc, oldColor, newColor);
        performFloodFill(image, sr, sc+1, oldColor, newColor);
        performFloodFill(image, sr, sc-1, oldColor, newColor);
        performFloodFill(image, sr-1, sc, oldColor, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor != color) {
            performFloodFill(image, sr, sc, oldColor, color);
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        new FloodFill().floodFill(image, 1, 1, 2);
        for (int[] row : image) {
            Arrays.stream(row).forEach(val -> System.out.printf("%d ", val));
            System.out.println();
        }
        System.out.println();
        int[][] image2 = {{0,0,0}, {0,0,0}};
        new FloodFill().floodFill(image, 0, 0, 0);
        for (int[] row : image2) {
            Arrays.stream(row).forEach(val -> System.out.printf("%d ", val));
            System.out.println();
        }
    }
}

