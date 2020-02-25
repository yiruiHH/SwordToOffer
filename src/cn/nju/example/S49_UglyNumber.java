package cn.nju.example;

public class S49_UglyNumber{
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(getUglyNumber(1500));
        long end = System.currentTimeMillis();
        System.out.println("time= "+(end-start)+" ms");
        System.out.println(getUglyNumber_2(1500));
        long end2 = System.currentTimeMillis();
        System.out.println("time= "+(end2-end)+" ms");
    }

    private static boolean isUglyNumber(int n){
        if(n<=0) return false;
        while(n%2==0)
            n = n/2;
        while(n%3==0)
            n = n/3;
        while(n%5==0)
            n = n/5;

        return n==1;
    }

    private static int getUglyNumber(int index){
        if(index<=0)
            return 0;
        
        int uglyNum = 0;
        int nums = 0;
        while(nums<index){
            uglyNum++;
            if(isUglyNumber(uglyNum)){
                nums++;
            }
        }

        return uglyNum;
    }

    private static int getUglyNumber_2(int index){
        if(index<=0) return 0;

        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;
        int nextUglyindex = 1;
        while(nextUglyindex<index){
            uglyNum[nextUglyindex] = 
                Math.min(Math.min(2*uglyNum[index_2],3*uglyNum[index_3]), 5*uglyNum[index_5]);

            while(2*uglyNum[index_2]<=uglyNum[nextUglyindex])
                index_2++;
            while(3*uglyNum[index_3]<=uglyNum[nextUglyindex])
                index_3++;
            while(5*uglyNum[index_5]<=uglyNum[nextUglyindex])
                index_5++;

            nextUglyindex++;
        }
        return uglyNum[index-1];
    }
}