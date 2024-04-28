public class _988SmallestStringStartingFromLeaf {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String lexiSamll(String a, String b) {
        return a.compareTo(b) < 0 ? a : b;
    }

    public String smallestFromLeaf(TreeNode root) {
        return helper(root, new StringBuilder());
    }

    public String helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return new StringBuilder(sb).reverse().toString();
        }

        sb.append((char) (root.val + 97));
        //System.out.println(sb.toString());
        String result;
        if(root.left == null && root.right != null) {
            result = helper(root.right, sb);
        } else if (root.left != null && root.right == null) {
            result = helper(root.left, sb);
        } else {
            String left = helper(root.left, sb);
            String right = helper(root.right, sb);        
            result = lexiSamll(left, right);
        }
        sb.deleteCharAt(sb.length() - 1);

        return result;
    }


    public TreeNode buildTree(int[] inorder) {
        if (inorder == null || inorder.length == 0)
            return null;
        return buildTreeHelper(inorder, 0);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int index) {
        if (index >= inorder.length || inorder[index] == -1)
            return null;
        
        TreeNode node = new TreeNode(inorder[index]);
        node.left = buildTreeHelper(inorder, 2 * index + 1);
        node.right = buildTreeHelper(inorder, 2 * index + 2);
        return node;
    }

    public static void main(String[] args) {
        _988SmallestStringStartingFromLeaf ob = new _988SmallestStringStartingFromLeaf();

        int[] inorder = new int[] { 25,1,3,1,3,0,2 };
        //int[] inorder = new int[] {0,-1,1};
        TreeNode root = ob.buildTree(inorder);
        System.out.println(ob.smallestFromLeaf(root));

    }
}
