package cn.nju.example;

import java.lang.reflect.Method;
import java.util.Arrays;

public class S21_MoveEven{
    public static void main(String[] args) {    
        int[] nums = {1,-1,-2,2,-3,3,-4,4,5,-5};
        try{
            Method method = S21_MoveEven.class.getMethod("isPositive", int.class);
            //Method method = S21_MoveEven.class.getMethod("isEven", int.class);
            ReorderOddEven(nums,method);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void ReorderOddEven(int[] nums, Method method) throws Exception{
        if(nums==null ||nums.length<2) return;

        int left = 0;
        int right = nums.length-1;
        while(left<right){
            while(left<right && (Boolean)(method.invoke(null, nums[left]))){
                left++;
            }
            while(left<right && !(Boolean)(method.invoke(null, nums[right]))){
                right--;
            }
            if(left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }

    public static boolean isEven(int n){
        return (n&1)==1;
    }
    public static boolean isPositive(int n){
        return n>0;
    }
}