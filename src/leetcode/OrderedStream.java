/**
 * https://leetcode.com/problems/design-an-ordered-stream/description/
 *
 * Output:
 * ------
 * [aaaaa]
 * [bbbbb, ccccc]
 * [ddddd, eeeee]
 */

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    private String[] values = null;
    private int ptr;

    public OrderedStream(int n) {
        ptr = 1;
        values = new String[n+1];
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();

        values[idKey] = value;
        while(ptr < values.length && values[ptr] != null) {
            result.add(values[ptr++]);
        }

        return result;
    }

    public static void main(String[] args) {
        OrderedStream obj = new OrderedStream(5);
        obj.insert(3, "ccccc");
        List<String> result3 = obj.insert(1, "aaaaa");
        System.out.println(result3);
        List<String> result2 = obj.insert(2, "bbbbb");
        System.out.println(result2);
        obj.insert(5, "eeeee");
        List<String> result = obj.insert(4, "ddddd");
        System.out.println(result);
    }
}

