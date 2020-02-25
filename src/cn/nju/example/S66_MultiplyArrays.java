package cn.nju.example;

import java.util.Arrays;

public class S66_MultiplyArrays{
    public static void main(String[] args) {
        int[] nums = {2,2,3,4,5};
        int[] res = multiply(nums);
        System.out.println(Arrays.toString(res));
    }

    private static int[] multiply(int[] nums){
        int len = nums.length;
        int[] res = new int[len];

        res[0] = 1;
        for(int i=1;i<len;i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int temp = 1;
        for(int i=len-2;i>=0;i--){
            temp = temp * nums[i+1];
            res[i] = res[i] * temp;
        }

        return res;
    }
}