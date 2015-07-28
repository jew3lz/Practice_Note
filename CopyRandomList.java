/**
 * Created by JEWELZ on 27/7/15.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CopyRandomList {
    public RandomListNode Clone(RandomListNode pHead) {
        ClonedNodes(pHead);
        ConnectRandomNodes(pHead);
        return ReconnectNodes(pHead);
    }

    void ClonedNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = new RandomListNode(pNode.label);
            pCloned.next = pNode.next;
            pCloned.random = null;

            pNode.next = pCloned;
            pNode = pCloned.next;
        }
    }

    void ConnectRandomNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        while (pNode != null) {
            RandomListNode pCloned = pNode.next;
            if (pNode.random != null)
                pCloned.random = pNode.random.next;
            pNode = pCloned.next;
        }
    }

    RandomListNode ReconnectNodes(RandomListNode pHead) {
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pClonedNode = null;

        if (pNode != null) {
            pClonedHead = pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }

        return pClonedHead;
    }
}
