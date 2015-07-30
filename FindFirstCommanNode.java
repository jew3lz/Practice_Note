/**
 * Created by JEWELZ on 30/7/15.
 */
public class FindFirstCommanNode {

    /**
     * 还可以用两个辅助桟分别push所有Node再从链表尾开始比较
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        int length1 = GetLength(pHead1);
        int length2 = GetLength(pHead2);

        int DifLength = length1 < length2 ? length2 - length1 : length1 - length2;
        ListNode pListNodeLong = length1 > length2 ? pHead1 : pHead2;
        ListNode pListNodeShort = length1 < length2 ? pHead1 : pHead2;
        for (int i = 0; i < DifLength; i++)
            pListNodeLong = pListNodeLong.next;
        while (pListNodeLong != null && pListNodeShort != null && pListNodeLong.val != pListNodeShort.val) {
            pListNodeLong = pListNodeLong.next;
            pListNodeShort = pListNodeShort.next;
        }

        ListNode pFirstCurrent = pListNodeLong;
        return pFirstCurrent;
    }

    private int GetLength(ListNode pNode) {
        if (pNode == null)
            return 0;
        int length = 1;
        while (pNode != null) {
            pNode = pNode.next;
            length++;
        }

        return length;
    }
}
