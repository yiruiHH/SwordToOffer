package cn.nju.example;

import cn.nju.tool.TreeNode;

public class S07_RebuildBinaryTree{

    
    public static void main(String[] args){
        System.out.println("rebuild:");
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        TreeNode ans = rebuild(preorder, inorder);
        TreeNode.preorder_loop(ans);
        System.out.println();
        TreeNode.inorder_loop(ans);
        System.out.println();
    }

    private static TreeNode rebuild(int[] preorder, int[] inorder){
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0) return null;
        if(preorder.length != inorder.length)
            throw new IllegalArgumentException("Wrong order length.");
        return rebuild_helper(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
    }

    private static TreeNode rebuild_helper(int pre_srart, int pre_end, int in_start, int in_end, int[] preorder, int[] inorder){
        int rootValue = preorder[pre_srart];
        System.out.println(pre_srart+"+"+pre_end+"+"+in_start+"+"+in_end);
        System.out.println("rootValue:"+rootValue);
        TreeNode root = new TreeNode(rootValue);
        if(pre_srart==pre_end && in_start==in_end){
            if(inorder[in_start]==rootValue)
                return root;
            else{
                throw new IllegalArgumentException("Invalid input.");
            }
        }
        int rootInorder = -1;
        for(int i=in_start;i<=in_end;i++){
            if(inorder[i]==rootValue)
                rootInorder = i;
        }
        if(rootInorder==-1)
            throw new IllegalArgumentException("Invalid input.");

        System.out.println("rootInorder:"+rootInorder);
        
        int leftLength = rootInorder - in_start;
        System.out.println("left:"+leftLength);
        int rightLength = in_end - rootInorder;
        System.out.println("right:"+rightLength);
        if(leftLength>0){
            root.left = rebuild_helper(pre_srart+1, pre_end-rightLength, in_start, rootInorder-1, preorder, inorder);
        }
        if(rightLength>0){
            root.right = rebuild_helper(pre_srart+1+leftLength, pre_end, rootInorder+1, in_end, preorder, inorder);
        }
        return root;
    }

    
}