
/**
 * 反转链表
 * keys:保存顺序下的next
 * Created by JEWELZ on 20/4/15.
 */

public class ReverseList {
    public ListNode reverseList(ListNode head){
        {
            if(head==null)
                return null;
            ListNode preListNode=null;
            ListNode nowListNode=head;
            while(nowListNode.next!=null)
            {
                ListNode nextListNode=nowListNode.next;
                nowListNode.next=preListNode;
                preListNode=nowListNode;
                nowListNode=nextListNode;
                nowListNode.next = preListNode;//自加的
            }
            return nowListNode;
        }
    }
}
