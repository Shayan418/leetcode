package com.leetcode;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode buildBSTFromInorder(int[] inorder) {
        return constructBST(inorder, 0, inorder.length - 1);
    }

    // Helper function to construct the BST recursively
    private static TreeNode constructBST(int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // Find the middle element
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(inorder[mid]);

        // Recursively construct the left and right subtrees
        node.left = constructBST(inorder, start, mid - 1);
        node.right = constructBST(inorder, mid + 1, end);

        return node;
    }


    public static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }


}