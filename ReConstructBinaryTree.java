import java.util.Arrays;

/**
 * Created by JEWELZ on 7/7/15.
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        boolean didHave = false;
        if (pre == null || in == null || pre.length != in.length)
            return null;
        TreeNode root = new TreeNode(0);
        for (int i = 0; i < pre.length; i++) {
            if (in[i] == pre[0]) {
                didHave = true;
                root.val = pre[0];
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        if (!didHave)
            return null;
        return root;
    }
}
