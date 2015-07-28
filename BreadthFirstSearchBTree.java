import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by JEWELZ on 27/7/15.
 */
public class BreadthFirstSearchBTree {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null)
            return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return list;
    }
}
