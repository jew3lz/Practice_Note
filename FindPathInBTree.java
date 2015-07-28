import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by JEWELZ on 27/7/15.
 */
public class FindPathInBTree {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return res;
        Stack<Integer> path = new Stack<Integer>();
        findPath(root, target, path, res);
        return res;
    }


    private void findPath(TreeNode root, int target, Stack<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i : path) {
                    list.add(new Integer(i));
                }
                list.add(root.val);
                res.add(list);
            }
        } else {
            path.push(root.val);
            findPath(root.left, target - root.val, path, res);
            findPath(root.right, target - root.val, path, res);
            //在返回父节点之前,在路径上删除掉当前结点
            path.pop();
        }
    }
}
