package cn.nju.example;

import java.util.Arrays;

public class S17_Print1toN{
    public static void main(String[] args){
        print1ton(1);
        print1ton(2);
        print1ton(3);
        print1ton(0);
        print1ton(-1);
    }

    private static void print1ton(int n){
        if(n<=0) return;
        char[] nums = new char[n];
        Arrays.fill(nums,'0');

        
        print1ton_helper(nums,0);
    }

    private static void print1ton_helper(char[] nums,int index){
        if(index==nums.length){
            print(nums);
            return;
        }

        for(int i=0;i<10;i++){
            nums[index] = (char)('0'+i);
            print1ton_helper(nums, index+1);
        }

    }

    private static void print(char[] nums){
        boolean isStart = false;
        StringBuffer b = new StringBuffer();
        for(int i=0;i<nums.length;i++){
            if(isStart){
                b.append(nums[i]);
            }
            else{
                if(nums[i]!='0'){
                    isStart = true;
                    b.append(nums[i]);
                }
                    
            }
        }
        if(isStart)
            System.out.println(b.toString());
    }
}