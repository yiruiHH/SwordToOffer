package cn.nju.example;

import java.util.Arrays;

public class S56_FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] data1 = {2,3,3,2,4,6,5,5};
        System.out.println(Arrays.toString(new S56_FindNumsAppearOnce().find(data1)));
        int[] data2 = {4, 6};
        System.out.println(Arrays.toString(new S56_FindNumsAppearOnce().find(data2)));
        int[] data3 = {4, 6, 1, 1, 1, 1};
        System.out.println(Arrays.toString(new S56_FindNumsAppearOnce().find(data3)));

        //////////////////////////////////////////////////////////////////////////////
        int[] nums1 = {1};
        int[] nums2 = {1,2,2,2};
        int[] nums3 = {2,3,4,3,4,3,4,5,5,5};
        System.out.println(new S56_FindNumsAppearOnce().find_2(nums1));
        System.out.println(new S56_FindNumsAppearOnce().find_2(nums2));
        System.out.println(new S56_FindNumsAppearOnce().find_2(nums3));
    }

    private int[] find(int[] nums){
        if(nums==null || nums.length<=2)
            return nums;
        
        int resultExclusiveOR = 0;
        for (int var : nums) {
            resultExclusiveOR ^= var;
        }

        int indexOf1 = 0;
        for(;indexOf1<32;indexOf1++){
            if(((resultExclusiveOR>>indexOf1)&1) == 1)
                break;
        }

        int[] res = new int[2];
        for (int i : nums) {
            if(((i>>indexOf1)&1)==1){
                res[0] ^= i;
            }
            else{
                res[1] ^= i;
            }
        }

        return res;
    }

    private int find_2(int[] nums){
        if(nums==null || nums.length==0)
            throw new IllegalArgumentException("invalid input");
        
        int[] bitSum = new int[32];
        for (int i : nums) {
            int bitMask = 1;
            for(int j=31;j>=0;j--){
                if((i&bitMask)!=0){
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }

        int res = 0;
        for(int i=0;i<32;i++){
            res = res << 1;
            res += bitSum[i]%3;
        }

        return res;
    }
}