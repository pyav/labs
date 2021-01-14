/**
 * Following program demonstrates the sequence of constructor calls in 
 * multi-level inheritance.
 * 
 *  
 * Output
 * ------
 * 
 * In the constructor of the first class.
 * In the constructor of the second class.
 * In the constructor of the third class.
 *
 * 
 * @author pyav
 * 
 */

class FirstClass {
    FirstClass() {
        System.out.println("In the constructor of the first class.");
    }
}

class SecondClass extends FirstClass {
    SecondClass() {
        System.out.println("In the constructor of the second class.");
    }
}

class ThirdClass extends SecondClass {
    ThirdClass() {
        System.out.println("In the constructor of the third class.");
    }
}

public class ConstructorCallSequence {
    
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        ThirdClass obj = new ThirdClass();     
    }
    
}
