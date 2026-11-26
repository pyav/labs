/**
 * https://leetcode.com/problems/longest-uploaded-prefix/
 *
 * Output:
 * ------
 * 0
 * 1
 * 3
 */

public class LUPrefix {
    private boolean[] values = null;
    private int ptr;
    private int top;

    public LUPrefix(int n) {
        ptr = 1;
        values = new boolean[n+1];
        top = 0;
    }

    public void upload(int video) {
        values[video] = true;
        while(ptr < values.length && values[ptr] != false) {
            top = ptr++;
        }
    }

    public int longest() {
        return top;
    }

    public static void main(String[] args) {
        LUPrefix server = new LUPrefix(5);
        server.upload(3); 
        System.out.println(server.longest());
        server.upload(1);
        System.out.println(server.longest());
        server.upload(2);
        System.out.println(server.longest());
    }
}

