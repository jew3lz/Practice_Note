/**
 * Created by JEWELZ on 12/7/15.
 */
public class MergeTwoSortedList {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        else if (list2 == null)
            return list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode pMergedHead = null;

        if (p1.val < p2.val) {
            pMergedHead = p1;
            pMergedHead.next = Merge(p1.next, p2);
        } else {
            pMergedHead = p2;
            pMergedHead.next = Merge(p2.next, p1);
        }

        return pMergedHead;
    }
}
