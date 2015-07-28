import java.util.Stack;

/**
 * Created by JEWELZ on 27/7/15.
 */
public class IsPopOrder {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length || pushA.length < 1 || popA.length < 1)
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

}
