/**
 * Program to provide the abstract method to Cycle.java.
 *
 * @author pyav
 */

public abstract class Machine {

    public abstract String getData();

    protected void printData() {
        System.out.println(getData());
    }

}
