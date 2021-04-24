/**
 * Following program demonstrates multi-level inheritance.
 * 
 * 
 * Output
 * ------
 * 
 * Product = 6 
 * d = 4 
 * e = 5
 * 
 * 
 * @author pyav
 * 
 */

class One {
    int a;
    int b;
    int c;
    
    One(int x, int y, int z) {
        a = x;
        b = y;
        c = z;
    }
    
    int product() {
        return a * b * c;
    }
}

class Two extends One {
    int d;
    
    Two(int x, int y, int z, int w) {
        super(x, y, z);
        d = w;
    }
}

class Three extends Two {
    int e;
    
    Three(int x, int y, int z, int w, int v) {
        super(x, y, z, w);
        e = v;
    }
}

public class MultilevelInheritance {
    
    public static void main(String[] args) {
        Three obj3 = new Three(1, 2, 3, 4, 5);
        System.out.println("Product = " + Integer.toString(obj3.product()));
        System.out.println("d = " + Integer.toString(obj3.d));
        System.out.println("e = " + Integer.toString(obj3.e));
    }
    
}
