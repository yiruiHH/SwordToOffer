package cn.nju.example;

public class S63_MaxDiff{
    public static void main(String[] args) {
        int[] nums = {9,11,8,5,7,12,16,14};
        System.out.println(getMaxDiff(nums));
    }

    private static int getMaxDiff(int[] nums){
        if(nums==null || nums.length<2) return 0;

        int min = nums[0];
        int maxDiff = nums[1]-min;

        for(int i=1;i<nums.length;i++){
            maxDiff = Math.max(maxDiff,nums[i]-min);
            min = Math.min(nums[i],min);
        }
        return maxDiff;
    }
}