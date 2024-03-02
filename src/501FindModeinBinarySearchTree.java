import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}


class _501FindModeinBinarySearchTre {
    
    int num;
    int count;
    int max;
    ArrayList<Integer> ans;
    
    _501FindModeinBinarySearchTre(){
        num = 0;
        count = 0;
        max = 0;
        ans = new ArrayList<>();
    }

    public TreeNode constructBinaryTree(int[] bfs) {
        if (bfs == null || bfs.length == 0) {
            return null;
        }

        int index = 0;
        TreeNode root = new TreeNode(bfs[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty() && index < bfs.length) {
            TreeNode current = queue.poll();
            int leftVal = bfs[index++];
            if (leftVal != -1) {
                current.left = new TreeNode(leftVal);
                queue.offer(current.left);
            }

            if (index < bfs.length) {
                int rightVal = bfs[index++];
                if (rightVal != -1) {
                    current.right = new TreeNode(rightVal);
                    queue.offer(current.right);
                }
            }
        }

        return root;
    }
    
    public int[] findMode(TreeNode root) {
        if(root == null){
            return null;
        }

        num = 0;
        count = 0;


        inorder(root);

        if(max == count){
            ans.add(num);
        }
        int[] realans = new int[ans.size()];

        for(int i =0; i< ans.size(); ++i){
            realans[i] = ans.get(i);
        }

        return realans;

    }

    public void inorder(TreeNode root){

        if(root == null){
            return;
        }

        inorder(root.left);
        if(root.val == num){
            ++count;
        } else {
            if(count == max){
                ans.add(num);
            } else if (count > max) {
                max = count;
                ans = new ArrayList<>();
                ans.add(num);
            }
            
            count = 1;
            num = root.val;
        }

        inorder(root.right);
    }

    public static void main(String[] args) {
        
        _501FindModeinBinarySearchTre ob = new _501FindModeinBinarySearchTre();
       // int[] bfs = new int[]{1,-1,2,2,3,-1,-1,3};
        int[] bfs = new int[]{1,-1,2,2};
        TreeNode root = ob.constructBinaryTree(bfs);

        int[] ans = ob.findMode(root);
        for (int i : ans) {
            System.out.print(i + " ");
        }


    }


}
