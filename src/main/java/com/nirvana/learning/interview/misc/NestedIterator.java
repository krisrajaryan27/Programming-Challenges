package com.nirvana.learning.interview.misc;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

/**
 * Date 04/17/2019
 *
 * @author Krishna Verma
 * <p>
 * Given a nested list of integers, implement an iterator to flatten it.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * <p>
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack = new Stack<>();
    Integer nextVal = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalArgumentException();
        }
        Integer val = nextVal;
        nextVal = null;
        return val;
    }

    @Override
    public boolean hasNext() {
        if (nextVal != null) {
            return true;
        }
        while (!stack.isEmpty()) {
            boolean pushedIntoStack = false;
            Iterator<NestedInteger> itr = stack.peek();
            if (itr.hasNext()) {
                NestedInteger ni = itr.next();
                if (ni.isInteger()) {
                    nextVal = ni.getInteger();
                    return true;
                } else {
                    pushedIntoStack = true;
                    stack.push(ni.getList().iterator());
                }
            }
            if (!pushedIntoStack) {
                stack.pop();
            }
        }
        return false;
    }
}