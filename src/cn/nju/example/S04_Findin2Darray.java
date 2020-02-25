package cn.nju.example;

import java.util.TreeSet;

public class S04_Findin2Darray{
    public static void main(String[] args){
        int nums[][] = {{1,2,8,9},
                        {2,4,9,12},
                        {4,7,10,13},
                        {6,8,11,15}};
        System.out.println(find(nums, 25));
    }

    public static boolean find(int[][] nums, int target){
        if(nums==null || nums.length==0) return false;

        int row = nums.length;
        int column = nums[0].length;
        int r = 0;
        int c = column-1;
        while(r<row && c>=0){
            if(nums[r][c]==target) return true;
            else if(nums[r][c]>target) c--;
            else r++;
        }
        return false;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int col = matrix[0].length;
        int row = matrix.length;
        int res= Integer.MIN_VALUE;
        for(int i = 0; i < col; i++) {
            int[] rowSum = new int[row];
            for(int j = i; j < col; j++) {
                int sum = 0;
                int max = Integer.MIN_VALUE;
                for(int r = 0; r < row; r++) {
                    rowSum[r] += matrix[r][j];
                    if(sum < 0)
                        sum = 0;
                    sum+= rowSum[r];
                    max = Math.max(max, sum);
                }
                
                if(max <= k) {
                    res = Math.max(res, max);
                } 
                else {
                    max = Integer.MIN_VALUE;
                    for(int m = 0; m < row; m++) {
                        sum = 0;
                        for(int n = m; n < row; n++) {
                            sum += rowSum[n];
                            if(sum <=k)
                                max = Math.max(max, sum);
                        }
                    }
                    res = Math.max(res, max);
                }
                //目标变成找到k，存在k时很快，不存在时退化到正常速度
                if(res == k)
                    return k;
            }
        }
        return res;
    }

    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int left = 0; left < cols; left++) {
            int[] preSum = new int[rows];
            for (int right = left; right < cols; right++) {
                //划分左右边界，并求出在此边界下的行前缀和
                // right从left+1开始,每次循环会全部加到preSum一次(求行前缀和的方式)
                for (int i = 0; i < rows; i++) {
                    preSum[i] += matrix[i][right];
                }
                //找到不大于k的最大子序和
                // 2 第1行(left,right)前缀和
                // 7 第2行(left,right)前缀和
                // 8 第3行(left,right)前缀和
                // 1 第4行(left,right)前缀和
                // 9 第5行(left,right)前缀和
                //求 [2,7,8,1,9] 不大于k的最大子序和
                max = Math.max(maxPreSum(preSum, k), max);
            }
        }
        return max;
    }
    
    //要求sum(i,j)即从i到j的和，可以sum(0,j) - sum(0,i-1)。所以sum(0,j) - sum(0,i-1)<=k。
    //这样的话，我们用一个遍历，求出sum(0,i)，并且把所有的值存入set，然后每一次都求出一个下界，即sum(0,i)-k，
    //然后在之前的结果中找大于等于这个界的最小值，如果存在，就是一个候选值，然后再把sum(0,i)也放入set。
    //不大于k的最大子序和 O(nlgn)
    public int maxPreSum(int[] nums, int k) {
        int sum = 0, max = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int num : nums) {
            sum += num;
            Integer min = set.ceiling(sum - k);
            if (min != null) {
                max = Math.max(max, sum - min);
            }
            set.add(sum);
        }
        return max;
    }
}