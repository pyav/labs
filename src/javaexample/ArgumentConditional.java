package javaexample;

public class ArgumentConditional {
    private void func(int val, int k) {
        if (val == 1) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }
    }

    public static void main(String[] args) {
        new ArgumentConditional().func((1==1)? 1: null, 1);
    }
}

