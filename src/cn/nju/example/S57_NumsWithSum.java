package cn.nju.example;

import java.util.Arrays;

public class S57_NumsWithSum {
    public static void main(String[] args) {
        /**
         * test 1
         */
        S57_NumsWithSum obj = new S57_NumsWithSum();
        int[] nums = {1,3,4,7,9,11,15};
        System.out.println(Arrays.toString(obj.getNumsWithSum(nums, 15)));

        int[] nums2 = {1};
        try{
            System.out.println(Arrays.toString(obj.getNumsWithSum(nums2, 15)));
        }
        catch(Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        int[] nums3 = {1,3,4,7,9,11,15};
        try{
            System.out.println(Arrays.toString(obj.getNumsWithSum(nums3, 9)));
        }
        catch(Exception e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("---------------------------");

        /**
         * test 2
         */

        obj.getNumsWithSum(15);
        System.out.println("---------------------------");
        obj.getNumsWithSum(100);
    }

    /**
     * 找出递增排序数组中和为 sum 的两个数
     * @param nums
     * @param sum
     * @return
     */
    private int[] getNumsWithSum(int[] nums, int sum) {
        if(nums==null || nums.length<2)
            throw new IllegalArgumentException("invalid input");
        int small = 0;
        int large = nums.length-1;

        int ss;
		while((ss = nums[small]+nums[large])!=sum){
            if(ss<sum){
                small++;
            }
            else{
                large--;
            }

            if(small>=large)
                break;
        }

        if(nums[small]+nums[large] == sum){
            int[] res = {nums[small],nums[large]};
            return res;
        }
        else{
            throw new IllegalArgumentException("not found");
        }
    }

    /**
     * 输入一个正数 Sum， 打印出所有和为 Sum 的连续正数序列
     * @param sum 正数
     */
    private void getNumsWithSum(int sum){
        if(sum<3) return;

        int small = 1;
        int large = 2;
        int mid = (1+sum)/2;
        int curSum = small+large;

        System.out.println(sum+"=");

        while(small<mid){
            if(curSum==sum){
                for (int i = small; i <= large; i++) {
                    System.out.print(i+" ");
                }
                System.out.println();
                large++;
                curSum += large;
            }
            else if(curSum<sum){
                large++;
                curSum += large;
            }
            else{
                curSum -= small;
                small++;
            }
        }
    }
}