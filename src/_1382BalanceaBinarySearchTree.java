import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leetcode.TreeNode; 

public class _1382BalanceaBinarySearchTree {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        Collections.sort(arr);

        return solve(arr, 0, arr.size() - 1);

    }

    public TreeNode solve(List<Integer> A, int l, int r){
        if(l > r){
            return null;
        }

        int mid = l + (r-l)/2;

        TreeNode node = new TreeNode(A.get(mid));

        node.left = solve(A, l, mid - 1);
        node.right = solve(A, mid + 1, r);

        return node;

    }

    public void inorder(TreeNode root, List<Integer> A){
        if(root == null){
            return;
        }

        A.add(root.val);
        inorder(root.left, A);
        inorder(root.right, A);
    }

    public TreeNode balanceBST2(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        inorder2(root, arr);
        Collections.sort(arr, (tnode1, tnode2) -> tnode1.val - tnode2.val);

        return solve2(arr, 0, arr.size() - 1);
    }

    public TreeNode solve2(List<TreeNode> A, int l, int r){
        if(l > r){
            return null;
        }

        int mid = l + (r-l)/2;

        TreeNode node = A.get(mid);

        node.left = solve2(A, l, mid - 1);
        node.right = solve2(A, mid + 1, r);

        return node;

    }

    public void inorder2(TreeNode root, List<TreeNode> A){
        if(root == null){
            return;
        }

        inorder2(root.left, A);
        inorder2(root.right, A);
        root.left = null;
        root.right = null;
        A.add(root);
    }

    public static void main(String[] args) {
        _1382BalanceaBinarySearchTree ob = new _1382BalanceaBinarySearchTree();

        TreeNode root = TreeNode.buildBSTFromInorder(new int[]{2,1,3});
        
        TreeNode.inorderTraversal(root);
        
    }
}
