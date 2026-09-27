package src.LeetCode.Iterator;

import java.util.Iterator;

// 284. Peeking Iterator
// https://leetcode.com/problems/peeking-iterator/description/
public class PeekingIterator implements Iterator<Integer> {
    // 그냥 arraylist 로 인덱스로 관리하려고 했더니 모든 값을 다 알고있어야되서 O(n)이 됨
    // 다음값만 체크
    private Integer nextValue;
    private final Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        if(iterator.hasNext()) {
            this.nextValue = iterator.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return this.nextValue;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer current = this.nextValue;
        if (iterator.hasNext()) {
            this.nextValue = iterator.next();
        } else {
            this.nextValue = null;
        }

        return current;
    }

    @Override
    public boolean hasNext() {
        return this.nextValue != null;
    }
}
