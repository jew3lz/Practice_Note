/**
 * Created by JEWELZ on 28/7/15.
 */
public class ConvertBSTtoList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode pLast = null;
        pLast = Convert(pRootOfTree, pLast);
        while (pLast != null && pLast.left != null)
            pLast = pLast.left;
        TreeNode pBegin = pLast;
        return pBegin;
    }

    private TreeNode Convert(TreeNode pCurrent, TreeNode pLast) {
        //中序遍历
        if (pCurrent == null)
            return null;
        if (pCurrent.left != null)
            pLast = Convert(pCurrent.left, pLast);
        //遍历完到根节点,连接左子树
        pCurrent.left = pLast;
        if (pLast != null)
            pLast.right = pCurrent;
        pLast = pCurrent;

        if (pCurrent.right != null)
            pLast = Convert(pCurrent.right, pLast);
        return pLast;
    }
}
