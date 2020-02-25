package cn.nju.example;

import cn.nju.tool.TreeNode;

public class S26_SubTree{
    /**
     * Tree1 model
     *        6
     *      /   \
     *     6    14
     *    / \   / \
     *   4   8 12  16
     * 
     * * Tree2 model
     *     6    
     *    / \   
     *   4   8 
     * 
     */
    public static void main(String[] args) {
        // Tree1
        TreeNode t1 = new TreeNode(6);
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

        // Tree2
        TreeNode t8 = new TreeNode(6);
        TreeNode t9 = new TreeNode(4);
        TreeNode t10 = new TreeNode(8);

        t8.left = t9;
        t8.right = t10;

        System.out.println(hasSubTree(t1, t8));
    }

    private static boolean hasSubTree(TreeNode t1, TreeNode t2){
        boolean res = false;
        if(t1!=null && t2!=null){
            if(t1.val==t2.val){
                res = doesTree1HaveTree2(t1, t2);
            }
            if(!res){
                res = hasSubTree(t1.left, t2);
            }
            if(!res){
                res = hasSubTree(t1.right, t2);
            }
        }
        return res;
    }

    private static boolean doesTree1HaveTree2(TreeNode t1, TreeNode t2){
        if(t2==null) return true;
        if(t1==null) return false;
        if(t1.val!=t2.val) return false;
        return doesTree1HaveTree2(t1.left, t2.left) && doesTree1HaveTree2(t1.right, t2.right);
    }
}