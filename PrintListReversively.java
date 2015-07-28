import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by JEWELZ on 7/7/15.
 */
public class PrintListReversively {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode == null)
            return list;
        Stack<Integer> stack = new Stack<>();
        if(listNode.next != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while(stack.size()!=0){
            list.add(stack.pop());
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHeadRecursively(ListNode listNode) {
        if(listNode == null)
            return list;
        execute(listNode);
        return list;
    }

    public void execute(ListNode listNode){
        if(listNode!=null){
            if(listNode.next!=null)
                printListFromTailToHead(listNode.next);
        }
        list.add(listNode.val);
    }
}
