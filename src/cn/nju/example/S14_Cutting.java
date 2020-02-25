package cn.nju.example;

import cn.nju.tool.Tool;

public class S14_Cutting{
    public static void main(String[] args){
        System.out.println(cutting_dp(8));
        System.out.println(cutting_greedy(8));
    }

    //dynamic programming
    private static int cutting_dp(int length){
        if(length<2) return 0;
        if(length==2) return 1;
        if(length==3) return 2;

        int[] dp = new int[length+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        int max = 0;
        for(int i=4;i<=length;i++){
            max = 0;
            for(int j=1;j<=i/2;j++){
                max = Math.max(max,dp[j]*dp[i-j]);
            }
            dp[i] = max;
        }
        return dp[length];
    }

    private static int cutting_greedy(int length){
        if(length<2) return 0;
        if(length==2) return 1;
        if(length==3) return 2;

        int timesOf3 = length/3;
        if(length-3*timesOf3==1)
            timesOf3--;
        int timesOf2 = (length-3*timesOf3)/2;
        long res = Tool.QuickPow(3,timesOf3)*Tool.QuickPow(2,timesOf2);
        return (int)res;
    }
}