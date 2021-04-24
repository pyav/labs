/**
 * Following program shows dynamic method dispatch. 
 * 
 * Output
 * ------
 * In the class: Super1
 * In the class: Sub1
 * In the class: Sub2
 * 
 * @author pyav
 */

class Super1 {
    void show() {
        System.out.println("In the class: Super1");
    }
}

class Sub1 extends Super1 {
    void show() {
        System.out.println("In the class: Sub1");
    }
}

class Sub2 extends Super1 {
    void show() {
        System.out.println("In the class: Sub2");
    }
}

public class DynamicMethodDispatch {
    
    public static void main(String[] args) {
        Super1 obj1 = new Super1();
        Sub1 obj2 = new Sub1();
        Sub2 obj3 = new Sub2();
        Super1 objn;
        
        // First object assignment
        objn = obj1;
        objn.show();
        
        // Second object assignment
        objn = obj2;
        objn.show();
        
        // Third object assignment
        objn = obj3;
        objn.show();
    }
    
}
