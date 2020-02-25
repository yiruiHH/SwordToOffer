package cn.nju.example;

import java.util.Arrays;

public class S61_Continuous {
    public static void main(String[] args) {
        S61_Continuous obj = new S61_Continuous();

        int[] nums = {1,2,3,4,5};
        System.out.println(obj.isContinuous(nums));

        int[] nums2 = {1,2,2,4,5};
        System.out.println(obj.isContinuous(nums2));

        int[] nums3 = {0,2,3,4,6};
        System.out.println(obj.isContinuous(nums3));

        int[] nums4 = {1,2,0,4,5};
        System.out.println(obj.isContinuous(nums4));

        int[] nums5 = {1,2,0,0,5};
        System.out.println(obj.isContinuous(nums5));

        int[] nums6 = {1,2,0,4,6};
        System.out.println(obj.isContinuous(nums6));
    }

    private boolean isContinuous(int[] nums){
        if(nums==null || nums.length!=5){
            return false;
        }

        Arrays.sort(nums);
        int numsOf0 = 0;
        int numsOfGap = 0;

        for (int i : nums) {
            if(i==0)
                numsOf0++;
        }

        int small = numsOf0;
        int big = small+1;
        while(big<5){
            if(nums[small]==nums[big]) return false;

            numsOfGap += (nums[big]-nums[small]-1);
            small = big;
            big++;
        }

        return numsOf0>=numsOfGap;
    }
}