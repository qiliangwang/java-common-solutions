package commonsolutions.algo.leetcode.solutions;

import java.util.LinkedList;
import java.util.Queue;

/**
 225. 用队列实现栈
 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。

 实现 MyStack 类：

 void push(int x) 将元素 x 压入栈顶。
 int pop() 移除并返回栈顶元素。
 int top() 返回栈顶元素。
 boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。


 注意：

 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。


 示例：

 输入：
 ["MyStack", "push", "push", "top", "pop", "empty"]
 [[], [1], [2], [], [], []]
 输出：
 [null, null, null, 2, 2, false]

 解释：
 MyStack myStack = new MyStack();
 myStack.push(1);
 myStack.push(2);
 myStack.top(); // 返回 2
 myStack.pop(); // 返回 2
 myStack.empty(); // 返回 False


 提示：

 1 <= x <= 9
 最多调用100 次 push、pop、top 和 empty
 每次调用 pop 和 top 都保证栈不为空


 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的时间。你可以使用两个以上的队列。
 这个可以用2个队列来解决也可以用一个队列来解决
 2个队列 q1 q2 每次都append到q2上 然后把q1的剩余元素append到q2上
 1个队列 q1先记录size 然后append一个 接着把前size个元素pop出来append到后面（其实和上面的是一样的效果，靠size拆分了2个队列罢了）
 */
class MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int alreadyQueuedSize = queue.size();
        queue.offer(x);
        while (alreadyQueuedSize != 0) {
            queue.offer(queue.poll());
            alreadyQueuedSize --;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}