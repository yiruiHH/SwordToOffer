package cn.nju.example;

import java.util.Arrays;

public class S33_VerifySeqOfBST{
    public static void main(String[] args) {
        int nums1[] = {5,7,6,9,11,10,8};
        int nums2[] = {7,5,6,5};
        System.out.println(verify(nums1));
        System.out.println(verify(nums2));
    }

    private static boolean verify(int[] postOrder){
        if(postOrder==null || postOrder.length<=0) return false;

        int len = postOrder.length;
        int root = postOrder[len-1];
        int i=0;
        for(;i<len-1;i++){
            if(postOrder[i]>root){
                break;
            }
        }
        int j=i;
        for(;j<len-1;j++){
            if(postOrder[j]<root) return false;
        }
        boolean left = true;
        if(i>0)
            left = verify(Arrays.copyOfRange(postOrder, 0, i));
        boolean right = true;
        if(i<len-1)
            right = verify(Arrays.copyOfRange(postOrder, i, len-1));
        return left&&right;
    }
}