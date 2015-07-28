import java.util.Arrays;

/**
 * Created by JEWELZ on 4/5/15.
 */
public class JosephuseLoop {
    public static void main(String args[]){
        System.out.println(new JosephuseLoop().LastRemaining(5, 3));
    }

    public int LastRemaining_Solution(int n,int m) {
        if(n==0 || m==0)
            return -1;

        boolean[] isAlive = new boolean[n+1];
        Arrays.fill(isAlive, true);

        int count = 0;
        int res = 0;
        for(int i = 0,j = 0; ;i++)
        {
            if(isAlive[i])
            {
                j++;
                if(j == m)
                {
                    isAlive[i] = false;
                    j = 0;
                    count++;
                }
                if(count == n)
                {
                    res = i;
                    break;
                }
            }
            if(i == n)
                i = 0;
        }
        return res;
    }
    public int LastRemaining(int n,int m) {
        //初始化循环链表,头结点first和尾节点pNode
        ListNode pFirst = new ListNode(1);
        pFirst.next = pFirst;
        ListNode pNode = pFirst;
        for(int i = 2; i <= n; i++){
            pNode = (pNode.next = new ListNode(i));
        }

        pNode.next = pFirst;//尾接头形成循环链表,pNode为尾节点
        while(pNode.next!=null){
            System.out.println(pNode.val);
            pNode = pNode.next;
        }

        while(pNode != pNode.next){
            //下面for循环后,p是第m个节点的前一个节点
            for(int i = 1;i < m; i++)
                pNode = pNode.next;
            //删除第m个节点;
            pNode.next = pNode.next.next;
        }
        return pNode.val-1;
    }
    public int LastRemainingK(int n,int m){
        if(n < 1 || m < 1)
            return -1;

        int last = 0;
        for(int i = 2; i <= n; i++)
            last = (last + m) % i;

        return last;
    }
}


