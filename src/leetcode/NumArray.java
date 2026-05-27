/**
 * https://leetcode.com/problems/range-sum-query-mutable/?envType=problem-list-v2&envId=segment-tree
 *
 * Output:
 * ------
 * 9
 * 8
 */

public class NumArray {
    private int[] nums = null;
    private int[] st = null;

    public NumArray(int[] nums) {
        this.nums = nums;
        st = new int[4*nums.length];
        build(0, 0, this.nums.length-1);
    }

    private void build(int node, int l, int r) {
        if (l == r) {
            st[node] = nums[l];
            return;
        } else {
            int mid = l + (r-l)/2;
            build(2 * node + 1, l, mid);
            build(2 * node + 2, mid + 1, r);
            st[node] = st[2 * node + 1] + st[2 * node + 2];
        }
    }

    private void update(int node, int l, int r, int idx, int diff) {
        if (idx < l || idx > r) {
            return;
        }

        st[node] += diff;

        if (l != r) {
            int mid = l + (r-l)/2;
            if (l <= idx && idx <= mid) {
                update(2 * node + 1, l, mid, idx, diff);
            } else {
                update(2 * node + 2, mid+1, r, idx, diff);
            }
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        this.nums[index] = val;
        update(0, 0, this.nums.length-1, index, diff);
    }

    private int query(int node, int tl, int tr, int l, int r) {
        if (r < tl || l > tr) {
            return 0;
        }
        if (l <= tl && r >= tr) {
            return st[node];
        }
        int mid = tl + (tr - tl)/2;
        return query(2 * node + 1, tl, mid, l, r) + query(2 * node + 2, mid + 1, tr, l, r);
    }

    public int sumRange(int left, int right) {
        return query(0, 0, this.nums.length-1, left, right);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0,2));
        obj.update(1,2);
        System.out.println(obj.sumRange(0,2));
    }
}

