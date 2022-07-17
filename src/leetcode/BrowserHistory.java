/**
 * https://leetcode.com/problems/design-browser-history/
 *
 * Output:
 * ------
 * facebook.com
 * google.com
 * facebook.com
 * linkedin.com
 * google.com
 * leetcode.com
 * zav.com
 * zav.com
 * kni.com
 * kni.com
 * zav.com
 */

package leetcode;

import java.util.Stack;

public class BrowserHistory {

    Stack<String> stack;
    Stack<String> next;

    public BrowserHistory(String homepage) {
        stack = new Stack<String> ();
        stack.push(homepage);
        next = new Stack<String> ();
    }

    public void visit(String url) {
        stack.push(url);
        next.clear();
    }

    public String back(int steps) {
        String lastUrl = stack.peek();
        while(steps > 0 && !stack.isEmpty()) {
            lastUrl = stack.pop();
            next.push(lastUrl);
            steps--;
        }
        if (!stack.isEmpty()) {
            lastUrl = stack.peek();
        } else {
            stack.push(lastUrl);
            next.pop();
        }
        return lastUrl;
    }

    public String forward(int steps) {
        String nextUrl = stack.peek();
        while (steps > 0 && !next.isEmpty()) {
            nextUrl = next.pop();
            stack.push(nextUrl);
            steps--;
        }
        return nextUrl;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
        BrowserHistory browserHistory2 = new BrowserHistory("zav.com");
        browserHistory2.visit("kni.com");
        System.out.println(browserHistory2.back(1));
        System.out.println(browserHistory2.back(7));
        System.out.println(browserHistory2.forward(5));
        System.out.println(browserHistory2.forward(1));
        browserHistory2.visit("pwrrbnw.com");
        browserHistory2.visit("mosohif.com");
        System.out.println(browserHistory2.back(9));
    }

}

