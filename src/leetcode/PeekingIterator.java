/**
 * https://leetcode.com/problems/peeking-iterator/description/
 *
 * Output:
 * ------
 * 1
 * 2
 * 2
 * 3
 * false
 */

import java.util.*;

class PeekingIterator implements Iterator<Integer> {
    private List<Integer> list;
    private int idx;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
        idx = -1;
        iterator.forEachRemaining(list::add);
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return list.get(idx+1);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        return list.get(++idx);
    }

    @Override
    public boolean hasNext() {
        return (idx+1) < list.size()? true: false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        PeekingIterator peekingIterator = new PeekingIterator(Arrays.stream(arr).iterator());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }
}
