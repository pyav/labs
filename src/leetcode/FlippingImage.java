/**
 * https://leetcode.com/problems/flipping-an-image/description/?envType=problem-list-v2&envId=array
 *
 * Output:
 * ------
 * 1 0 0 
 * 0 1 0 
 * 1 1 1 
 * 
 * 1 1 0 0 
 * 0 1 1 0 
 * 0 0 0 1 
 * 1 0 1 0 
 */

class FlippingImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (; j < n/2; j++) {
                int sum = image[i][j] + image[i][n-j-1];
                int right = (sum - image[i][n-j-1]);
                int left = (sum - image[i][j]);
                image[i][n-j-1] = right ^ 1;
                image[i][j] = left ^ 1;
            }
            if (j == n/2 && n%2 != 0) {
                image[i][j] = image[i][j] ^ 1;
                continue;
            }
        }
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,0}, {1,0,1}, {0,0,0}};
        image = new FlippingImage().flipAndInvertImage(image);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.printf("%d ", image[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        int[][] image2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        image2 = new FlippingImage().flipAndInvertImage(image2);
        for (int i = 0; i < image2.length; i++) {
            for (int j = 0; j < image2[i].length; j++) {
                System.out.printf("%d ", image2[i][j]);
            }
            System.out.println();
        }
    }
}

