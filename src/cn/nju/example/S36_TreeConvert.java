package cn.nju.example;

import cn.nju.tool.TreeNode;

public class S36_TreeConvert{
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

        TreeNode Dueue = convert(head);

        while(Dueue!=null){
            System.out.println(Dueue.val);
            Dueue = Dueue.right;
        }
    }
    private static TreeNode last = null;
    private static TreeNode convert(TreeNode head){
        if(head==null) return null;
        convert2(head);
        while(last.left!=null){
            last = last.left;
        }
        return last;
    } 

    private static TreeNode convert2(TreeNode head){
        if(head==null) return null;

        TreeNode cur = head;
        if(cur.left!=null){
            last = convert2(cur.left);
        }
        cur.left = last;
        if(last!=null)
            last.right = cur;
        last = cur;
        if(cur.right!=null){
            convert2(cur.right);
        }
        return last;
    }
}