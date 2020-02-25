package cn.nju.example;

import java.util.*;

public class S03_DuplicateNum{
    public static void main(String[] args){
        int[] nums1 = {2,3,1,0,2,5,3};
        System.out.println(duplicate(nums1));

        int[] nums2 = {2,3,5,4,3,2,6,7};
        System.out.println(getDuplacation(nums2));
        
    }

    public static List<Integer> duplicate(int[] nums){
        List<Integer> ans = new ArrayList<>();

        if(nums==null) return ans;

        for (int i = 0; i < nums.length; i++) {
            while(i< nums.length && nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    ans.add(nums[i]);
                    i++;
                }
                else{
                    int temp = nums[i];
                    nums[i] = nums[temp];
                    nums[temp] = temp; 
                }
                
            }
        }

        return ans;
    }

    public static void change(int nums[]){
        int temp = nums[0];
        nums[0] = nums[1];
        nums[1] = temp;
    }

    public static int getDuplacation(int[] nums){
        if(nums==null || nums.length==0) return -1;
        int start = 1;
        int end = nums.length-1;
        while(start<=end){
            int mid = ((end-start)>>1)+start;
            int count = countnums(nums,start,mid);
            if(end==start){
                if(count>1) return start;
                else break;
            }
            if(count>(mid-start+1))
                end = mid;
            else
                start = mid+1;
        }
        return -1;
    }

    private static int countnums(int[] nums, int start, int end){
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=start && nums[i]<=end){
                count++;
            }
        }
        return count;
    }
}