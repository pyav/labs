/**
 * Program to show the usage of abstract method and default value.
 *
 * Output
 * ------
 * Cycle
 * Cycle2
 */

public class Cycle extends Machine {

    private String data = "Cycle";

    private void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public static void main(String[] args) {
        Cycle c = new Cycle();
        c.printData();
        c.setData("Cycle2");
        c.printData();
    }

}
