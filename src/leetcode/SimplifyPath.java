/**
 * https://leetcode.com/problems/simplify-path/
 * 
 * Output:
 * ------
 * /home
 * /
 * /home/foo
 * /c
 * /a/b/c
 * /
 * /...
 * /..hidden
 * /hello/..world
 * /
 * /hello../world
 * /hello../world/hello../work
 * /hello../world/work
 */

package leetcode;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		Stack<Character> modifiedPath = new Stack<Character>();
		int count = 0;
        boolean isStartedWithSlash = false;

		for (Character c : path.toCharArray()) {
			if (c == '.') {
				if (count >= 2) {
					modifiedPath.add(c);
					count++;
					continue;
				}
                
                modifiedPath.add(c);
                count++;
                if (count == 1) {
                    Character onePeek = modifiedPath.pop();
                    if (modifiedPath.peek() == '/') {
                        isStartedWithSlash = true;
                    } else {
                        isStartedWithSlash = false;
                    }
                    modifiedPath.add(onePeek);
                }
			} else {
				if (count == 1 && c == '/' && isStartedWithSlash) {
					count = 0;
					modifiedPath.pop();
					if (modifiedPath.isEmpty()) {
						modifiedPath.add(c);
						continue;
					} else {
						modifiedPath.pop();
						modifiedPath.add(c);
					}
				} else if (count == 2 && c == '/' && isStartedWithSlash) {
					count = 0;
					modifiedPath.pop();
					modifiedPath.pop();
					modifiedPath.pop();
					if (modifiedPath.isEmpty()) {
						modifiedPath.add(c);
						continue;
					} else {
						Character tmp = modifiedPath.peek();
						while (tmp != '/') {
							modifiedPath.pop();
							tmp = modifiedPath.peek();
						}
						modifiedPath.pop();
						modifiedPath.add(c);
					}
				}
				if (modifiedPath.isEmpty()) {
					modifiedPath.add(c);
				} else {
					Character tmp = modifiedPath.peek();
					if (c == '/') {
						if (tmp == '/') {
							continue;
						}
						modifiedPath.add(c);
						count = 0;
					} else {
						modifiedPath.add(c);
						count = 0;
					}
				}
			}
		}

		if (count == 2) {
			count = 0;
			modifiedPath.pop();
			modifiedPath.pop();
			modifiedPath.pop();
			if (modifiedPath.isEmpty()) {
				modifiedPath.add('/');
			} else {
				Character tmp = modifiedPath.peek();
				while (tmp != '/') {
					modifiedPath.pop();
					tmp = modifiedPath.peek();
				}
				modifiedPath.pop();
				if (modifiedPath.isEmpty()) {
					modifiedPath.add('/');
				}
			}
		} else if (count == 1) {
			count = 0;
			modifiedPath.pop();
			modifiedPath.pop();
			if (modifiedPath.isEmpty()) {
				modifiedPath.add('/');
			}
		}

		String str = "";
		for (Character c : modifiedPath) {
			str += c;
		}

		if (str.charAt(str.length() - 1) == '/' && str.length() != 1) {
			return str.substring(0, str.length() - 1);
		}

		return str;
	}

	public static void main(String[] args) {
		String path = "/home/";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/../";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/home//foo/";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/a/./b/../../c/";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/a//b////c/d//././/..";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/a/./b/../../c/././..//./d/././/..";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/...";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/..hidden";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/hello/..world";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/../";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/hello../world";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/hello../world/hello../work";
		System.out.println(new SimplifyPath().simplifyPath(path));
		path = "/hello../world/hello/../work";
		System.out.println(new SimplifyPath().simplifyPath(path));
	}

}
