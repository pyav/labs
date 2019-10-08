/**
 * Following code demonstrates the usage of output and input streams
 * associated with a process to input some data and print the output
 * of the command executed. The file and shell paths are removed.
 * 
 * 
 * Contents of the shell script
 * ----------------------------
 * Please check shell_scripting/test.sh file.
 * 
 * Output
 * ------
 * Welcome Anand!
 * your age: -1!
 *
 *
 * @author pyav
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Interactive {

    public static void main(String[] args) throws InterruptedException {
        try {
            String cmd = "<shell> <path_to_parent_dir>/test.sh";
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            writer.write("Anand" + "\n");
            writer.flush();
            writer.write("-1" + "\n");
            writer.close();
            // Print std output
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
            // Print std error
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

}
