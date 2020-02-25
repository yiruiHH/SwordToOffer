package cn.nju.example;

public class S51_InversePairs{
    public static void main(String[] args) {
        int[] nums = {7,6,5,4,3,2,1}; 
        System.out.println(getNumOfInversePairs(nums));
    }

    private static int getNumOfInversePairs(int[] nums){
        if(nums==null || nums.length<=1) return 0;
        
        int len = nums.length;
        int[] copy = new int[len];

        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        return getNumOfInversePairs_Core(nums,copy,0,len-1);
    }

    private static int getNumOfInversePairs_Core(int[] nums,int[] copy,int start,int end){
        if(start==end){
            copy[start] = nums[start];
            return 0;
        }

        int mid = start + (end-start)/2;
        int leftNum = getNumOfInversePairs_Core(copy, nums, start, mid);
        int rightNUm = getNumOfInversePairs_Core(copy, nums, mid+1, end);

        int p1 = mid;
        int p2 = end;
        int p3 = end;

        int count = 0;
        while(p1>=start && p2>=mid+1){
            if(nums[p1]>nums[p2]){
                copy[p3--] = nums[p1--];
                count += p2-mid;
            }
            else{
                copy[p3--] = nums[p2--];
            }
        }

        for(;p1>=start;p1--){
            copy[p3--] = nums[p1];
        }
        for(;p2>=mid+1;p2--){
            copy[p3--] = nums[p2];
        }

        return leftNum+rightNUm+count;
    }
}