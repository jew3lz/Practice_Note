public class SerializeBinaryTrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.left.left = new TreeNode(10);
        root.right = new TreeNode(40);
        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(50);
        TreeNode root1 = new SerializeBinaryTrees().Deserialize("8,6,10,5,7,9,11");
        String res = new SerializeBinaryTrees().Serialize(root1);
//        System.out.println(root1);
        System.out.println("sdfsdfd");
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return "$,";
        }
        StringBuffer stream = new StringBuffer();
        SerializeCore(root, stream);
        return String.valueOf(stream).substring(0, stream.length() - 1);
    }

    void SerializeCore(TreeNode pRoot, StringBuffer stream) {
        if (pRoot == null) {
            stream.append("$,");
            return;
        }
        stream.append(pRoot.val + ",");
        SerializeCore(pRoot.left, stream);
        SerializeCore(pRoot.right, stream);
    }

    TreeNode Deserialize(String str) {
        TreeNode root = null;
        StringBuffer stream = new StringBuffer(str);
        return Deserialize(root, stream);
    }

    int number = 0;//计数
    int temp = 0;//作为缓存
    boolean isNum = false;


    TreeNode Deserialize(TreeNode pRoot, StringBuffer stream) {
        if (number == (String.valueOf(stream).split(",")).length)
            return null;
        isNum = false;
        if (!ReadStream(stream, number, isNum)) {
            number++;
//            return null;
        }
        if (isNum) {
            number++;
            pRoot = new TreeNode(0);
            pRoot.val = temp;
            pRoot.left = null;
            pRoot.right = null;
            System.out.println(pRoot);

            Deserialize(pRoot.left, stream);
            Deserialize(pRoot.right, stream);
        }
        return pRoot;
    }

    //每次从流中读出一个数字或者一个字符"$";
    boolean ReadStream(StringBuffer stream, int number, boolean isNum) {
        if (number == (String.valueOf(stream).split(",")).length)
            return false;
        String regex0 = ",";
        String[] split = String.valueOf(stream).split(regex0);

        String regex = "[0-9]+";
        if (split[number].matches(regex)) {
            isNum = true;
            this.isNum = isNum;
            temp = Integer.parseInt(split[number]);
            return true;
        } else {
            return false;
        }
    }

}

