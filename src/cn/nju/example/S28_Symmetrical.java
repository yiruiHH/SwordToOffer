package cn.nju.example;

import cn.nju.tool.TreeNode;

public class S28_Symmetrical{
    /**
     * Tree model
     *        8
     *      /   \
     *     6     6
     *    / \   / \
     *   5   7 7   5
     * 
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(6);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(isSymmetrical(t1));
        t3.val = 9;
        System.out.println(isSymmetrical(t1));
    }

    private static boolean isSymmetrical(TreeNode root){
        return isSymmetrical(root, root);
    }

    private static boolean isSymmetrical(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;
        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}