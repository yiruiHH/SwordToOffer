package cn.nju.example;

import cn.nju.tool.TreeNode;

public class S55_DepthOfTree{
    /**
     * Tree model
     *       10
     *      /   \
     *     6    14
     *    / \   / \
     *   4   8 12  16
     * 
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        TreeNode head = t1;

        System.out.println(getDepthOfTree(head));
        t5.left = new TreeNode(10);
        System.out.println(getDepthOfTree(head));

        System.out.println(isBalanced(head));
    }

    private static int getDepthOfTree(TreeNode root){
        if(root==null) return 0;

        int left = getDepthOfTree(root.left);
        int right = getDepthOfTree(root.right);

        return Math.max(left,right)+1;
    }

    /**
     * 法2：后序遍历，标上深度
     * @param head
     * @return
     */
    private static boolean isBalanced(TreeNode head){
        int[] depth = new int[]{0};
        return isBalanced(head, depth);
    }

    private static boolean isBalanced(TreeNode head, int[] depth) {
        if (head == null){
            depth[0] = 0;
            return true;
        }
        int[] left = new int[]{0};
        int[] right = new int[]{0};
        if (isBalanced(head.left, left) && isBalanced(head.right, right)){
            int diff = left[0] - right[0];
            if (diff>=-1 && diff<=1){
                depth[0] = 1+ Math.max(left[0], right[0]);
                return true;
            }
        }
        return false;
    }
}