package leetcode;

import java.util.LinkedList;

/**
 * @Classname MinStack
 * @Description TODO
 * @Date 2020/3/15 15:46
 * @Created by 14241
 */
class MinStack {

    LinkedList<Integer> linkedList = new LinkedList<>();
    int min = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        linkedList.add(x);
        if (x < min) {
            min = x;
        }

    }

    public void pop() {
        //min 不变
        if (linkedList.getLast() < min) {
            linkedList.removeLast();
        }
        linkedList.removeLast();
        min = Integer.MAX_VALUE;
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) < min) {
                min = linkedList.get(i);
            }
        }

    }

    public int top() {
        return linkedList.getLast();

    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
