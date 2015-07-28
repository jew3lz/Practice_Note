import java.util.Stack;

/**
 * Created by JEWELZ on 27/7/15.
 */
public class isPreOrder {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {4, 5, 3, 2, 1};
        boolean a = new isPreOrder().IsPopOrder(a1, a2);
        System.out.println(a);
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length)
            return false;
        Stack<Integer> stack = new Stack<>();
        int point = 0;

        for (int i = 0; i < pushA.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popA[i])
                stack.pop();
            else {
                if (point == popA.length)
                    return false;
                else {
                    do
                        stack.push(pushA[point++]);
                    while (stack.peek() != popA[i] && point != pushA.length);
                    if (stack.peek() == popA[i])
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return true;
    }

    public boolean IsPopOrder1(int[] pushA, int[] popA) {
        if (pushA == null || popA == null)
            return false;
        int point = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < popA.length - 1; i++) {
            if (!stack.isEmpty() && stack.peek() == popA.length - 1) {
                stack.pop();
            } else {
                if (point == pushA.length - 1)
                    return false;
                else {
                    do
                        stack.push(pushA[point++]);
                    while (stack.peek() != popA[i] && point != pushA.length - 1);
                    if (stack.peek() == popA[i])
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return true;
    }
}
