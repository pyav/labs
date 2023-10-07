/**
 * https://leetcode.com/problems/fizz-buzz/description/
 *
 * Output:
 * ------
 * [1, 2, Fizz]
 * [1, 2, Fizz, 4, Buzz]
 * [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
 */

import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if (i%3 == 0 && i%5 == 0) {
                answer.add(new String("FizzBuzz"));
            } else if (i%3 == 0) {
                answer.add(new String("Fizz"));
            } else if (i%5 == 0) {
                answer.add(new String("Buzz"));
            } else {
                answer.add(new String(String.valueOf(i)));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(3));
        System.out.println(new FizzBuzz().fizzBuzz(5));
        System.out.println(new FizzBuzz().fizzBuzz(15));
    }
}

