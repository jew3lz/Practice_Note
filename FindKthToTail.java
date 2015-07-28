/**
 * Created by JEWELZ on 12/7/15.
 */
public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        ListNode pAhead = head;
        ListNode pBehind = head;

        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null)
                pAhead = pAhead.next;
            else
                return null;
        }

        while (pAhead.next != null) {
            pBehind = pBehind.next;
            pAhead = pAhead.next;
        }
        return pBehind;
    }
}
