package cn.nju.example;

public class S46_Translate{
    public static void main(String[] args) {
        translateNumstoString_2(101);
        test(-100, 0);
        test(0, 1);
        test(10, 2);
        test(125, 3);
        test(126, 2);
        test(426, 1);
        test(100, 2);
        test(101, 2);
        test(10000, 2);
        test(12258, 5);
        test(122581351, 10);
    }

    private static int translateNumstoString_1(int n){
        if(n<0) return 0;
        if(n<10) return 1;
        if(n<26) return 2;
        if(n<100) return 1;

        String s = String.valueOf(n);
        int numOftwo = 0;
        if(Integer.valueOf(s.substring(0,2))<26){
            numOftwo = translateNumstoString_1(Integer.valueOf(s.substring(2)));
        }
        return translateNumstoString_1(Integer.valueOf(s.substring(1)))
                + numOftwo;
    }

    private static int translateNumstoString_2(int n){
        if(n<0) return 0;
        if(n<10) return 1;
        if(n<26) return 2;
        if(n<100) return 1;

        String s = String.valueOf(n);

        int[] dp = new int[s.length()];

        dp[s.length()-1] = 1;
        dp[s.length()-2] = 1;
        int numOftwo = Integer.valueOf(s.substring(s.length()-2));
        if(numOftwo<26){
            if(s.charAt(s.length()-2)!='0')
                dp[s.length()-2] = 2;
        }

        for (int i = s.length()-3; i>=0; i--) {
            int numOfLast2 = Integer.valueOf(s.substring(i, i+2));
            if(numOfLast2<26 && numOfLast2!=0 && s.charAt(i)!='0'){
                dp[i] = dp[i+1]+dp[i+2];
            }
            else{
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }

    private static void test(int n, int expected){
        System.out.println("num="+n+" expected="+expected);
        long starttime = System.currentTimeMillis();
        int res1 = translateNumstoString_1(n);
        long time1 = System.currentTimeMillis();
        int res2 = translateNumstoString_2(n);
        long time2 = System.currentTimeMillis();
        if(res1==expected && res2==expected){
            System.out.println("test passed");
        }
        else{
            System.out.println("test failed,res1="+res1+" res2="+res2);
        }

        System.out.println("method 1 used "+(time1-starttime)+" ms");
        System.out.println("method 2 used "+(time2-time1)+" ms");
        System.out.println("------------------------------------------");
    }
}