package cn.nju.example;

import java.util.Arrays;

public class S48_LongestSubstring {
    public static void main(String[] args) {
        S48_LongestSubstring s48 = new S48_LongestSubstring();
        s48.test1();
        s48.test2();
        s48.test3();
        s48.test4();
        s48.test5();
        s48.test6();
        s48.test7();
        s48.test8();
        s48.test9();
        s48.test10();
    }

    private static int longestSubString(String s){
        if(s==null || s.length()==0)
            return 0;
        int[] position = new int[26];
        Arrays.fill(position,-1);
        int maxLength = 1;
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        position[s.charAt(0)-'a'] = 0;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            if(position[c-'a']==-1){
                dp[i] = dp[i-1]+1;
            }
            else{
                int d = i-position[c-'a'];
                if(dp[i-1]<d){
                    dp[i] = dp[i-1]+1;
                }
                else{
                    dp[i] = d;
                }
            }
            position[c-'a'] = i;
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    void test1(){
        String input = "abcacfrar";
        int expected = 4;
        test(input, expected);
    }

    void test2(){
        String input = "acfrarabc";
        int expected = 4;
        test(input, expected);
    }

    void test3(){
        String input = "arabcacfr";
        int expected = 4;
        test(input, expected);
    }

    void test4(){
        String input = "aaaa";
        int expected = 1;
        test(input, expected);
    }

    void test5(){
        String input = "abcdefg";
        int expected = 7;
        test(input, expected);
    }

    void test6(){
        String input = "aaabbbccc";
        int expected = 2;
        test(input, expected);
    }

    void test7(){
        String input = "abcdcba";
        int expected = 4;
        test(input, expected);
    }

    void test8(){
        String input = "abcdaef";
        int expected = 6;
        test(input, expected);
    }

    void test9(){
        String input = "a";
        int expected = 1;
        test(input, expected);
    }

    void test10(){
        String input = "";
        int expected = 0;
        test(input, expected);
    }

    private void test(String input, int expected){
        int res = longestSubString(input);
        if(res==expected){
            System.out.println(input+" test passed.");
        }
        else{
            System.out.println(input+" test failed, output="+res+" but expected="+expected);
        }
    }
}