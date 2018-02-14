/**
 * Following program demonstrates overloading and overriding of methods.
 * 
 * Output
 * ------
 * a = 1, b = 2
 * c = 3
 * c from overridden method = 3
 *
 * @author pyav
 */

class Top {
    int a;
    int b;
    
    Top(int i, int j) {
        a = i;
        b = j;
    }
    
    void show() {
        System.out.println("a = " + a + ", b = " + b);
    }
}

class Bottom extends Top {
    int c;
    
    Bottom(int i, int j, int k) {
        super(i, j);
        c = k;
    }
    
    // Overloaded method
    void show() {
        super.show();
        System.out.println("c = " + c);
    }
    
    // Overridden method
    void show(String msg) {
        System.out.println(msg + c);
    }
}

public class OverloadAndOverride {
    
    public static void main(String[] args) {
        Bottom child = new Bottom(1, 2, 3);
        child.show();
        child.show("c from overridden method = ");
    }
    
}
