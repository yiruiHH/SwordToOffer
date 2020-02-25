package cn.nju.example;

import java.util.Stack;

public class S31_StackList {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,4,5};
        int nums2[] = {4,5,3,2,1};
        int nums3[] = {4,3,5,1,2};
        System.out.println(isPopOrder(nums1, nums2));
        System.out.println(isPopOrder(nums1, nums3));
    }

    private static boolean isPopOrder(int[] push, int[] pop){
        if(push.length!=pop.length){
            return false;
        }

        Stack<Integer> s = new Stack<>();

        int nextPushindex = 0;
        int nextPopindex = 0;

        while(nextPopindex<pop.length){
            while(s.empty() || s.peek()!=pop[nextPopindex]){
                if(nextPushindex>=push.length)
                    break;
                s.push(push[nextPushindex]);
                nextPushindex++;
            }

            if(s.peek()!=pop[nextPopindex])
                break;
            
            s.pop();
            nextPopindex++;
        }
        if(s.empty() && nextPopindex==pop.length)
            return true;
        
        return false;
    }
}