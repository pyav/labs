/**
 * https://leetcode.com/problems/first-bad-version/
 *
 * Output:
 * ------
 * 4
 * 2147483647
 * 2
 */

public class FirstBadVersion {

    private boolean isBadVersion(int version) {
        if (version == 2147483647) {
            return true;
        }
        if (version == 4) {
            return true;
        }
        if (version == 2) {
            return true;
        }
        return false;
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid = start + (end - start)/2;
        int firstBadVersion = -1;

        while(start <= end) {
            mid = start + (end - start)/2;
            if (isBadVersion(mid)) {
                firstBadVersion = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return firstBadVersion;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(5));
        //System.out.println(new FirstBadVersion().firstBadVersion(1));
        System.out.println(new FirstBadVersion().firstBadVersion(2147483647));
        System.out.println(new FirstBadVersion().firstBadVersion(2));
    }

}

