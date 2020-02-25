package cn.nju.example;

import cn.nju.tool.TreeNodeWithParent;

public class S08_NextNodeOfBinaryTree{

    /**
     * Tree model
     *              1
     *           /     \
     *          2       3
     *         / \     / \
     *        4   5   6   7
     *           / \
     *          8   9
     */
    public static void main(String[] args){

        TreeNodeWithParent t1 = new TreeNodeWithParent(1);
        TreeNodeWithParent t2 = new TreeNodeWithParent(2);
        TreeNodeWithParent t3 = new TreeNodeWithParent(3);
        TreeNodeWithParent t4 = new TreeNodeWithParent(4);
        TreeNodeWithParent t5 = new TreeNodeWithParent(5);
        TreeNodeWithParent t6 = new TreeNodeWithParent(6);
        TreeNodeWithParent t7 = new TreeNodeWithParent(7);
        TreeNodeWithParent t8 = new TreeNodeWithParent(8);
        TreeNodeWithParent t9 = new TreeNodeWithParent(9);

        t1.left = t2;
        t1.right = t3;
        t2.parent = t1;
        t3.parent = t1;

        t2.left = t4;
        t2.right = t5;
        t4.parent = t2;
        t5.parent = t2;

        t3.left = t6;
        t3.right = t7;
        t6.parent = t3;
        t7.parent = t3;

        t5.left = t8;
        t5.right = t9;
        t8.parent = t5;
        t9.parent = t5;

        //System.out.println("inorder:");
        //TreeNode.inorder_loop(t1);
        //System.out.println();

        System.out.println("next inorder:");
        System.out.println(getNext(t1).val);
        System.out.println(getNext(t2).val);
        System.out.println(getNext(t3).val);
        System.out.println(getNext(t4).val);
        System.out.println(getNext(t5).val);
        System.out.println(getNext(t6).val);
        System.out.println(getNext(t7));
        System.out.println(getNext(t8).val);
        System.out.println(getNext(t9).val);
    }

    /**
     * Tree model
     *              1
     *           /     \
     *          2       3
     *         / \     / \
     *        4   5   6   7
     *           / \
     *          8   9
     */

    private static TreeNodeWithParent getNext(TreeNodeWithParent node){
        if(node==null) return null;

        TreeNodeWithParent res = null;
        if(node.right!=null){
            res = node.right;
            while(res.left!=null){
                res = res.left;
            }
        }
        else{
            if(node==node.parent.left){
                res = node.parent;
            }
            else if(node==node.parent.right){
                res = node.parent;
                while(res!=null && res.parent!=null && res==res.parent.right){
                    res = res.parent;
                }
                if(res!=null)
                    res = res.parent;
            }
        }
        //if(res==null) return new TreeNodeWithParent(-1);
        return res;
    }
}