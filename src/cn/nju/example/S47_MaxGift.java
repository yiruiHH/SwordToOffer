package cn.nju.example;

public class S47_MaxGift{
    public static void main(String[] args) {
        int values1[][] = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int values2[][] = {
            { 1, 10, 3, 8 },
            { 12, 2, 9, 6 },
            { 5, 7, 4, 11 },
            { 3, 7, 16, 5 }
        };
        int values3[][] = {
            { 1, 10, 3, 8 }
        };
        int values4[][] = {
            { 1 },
            { 12 },
            { 5 },
            { 3 }
        };
        int values5[][] = {
            { 3 }
        };
        System.out.println(getMaxGift(values1)); //29
        System.out.println(getMaxGift(values2)); //53
        System.out.println(getMaxGift(values3)); //22
        System.out.println(getMaxGift(values4)); //21
        System.out.println(getMaxGift(values5)); //3
        System.out.println(getMaxGift(null));    //0

        System.out.println(getMaxGift_2(values1)); //29
        System.out.println(getMaxGift_2(values2)); //53
        System.out.println(getMaxGift_2(values3)); //22
        System.out.println(getMaxGift_2(values4)); //21
        System.out.println(getMaxGift_2(values5)); //3
        System.out.println(getMaxGift_2(null));    //0
    }

    private static int getMaxGift(int[][] gifts){
        if(gifts==null || gifts.length==0 || gifts[0].length==0)
            return 0;
        int row = gifts.length;
        int col = gifts[0].length;
        int[][] max = new int[row][col];

        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = 0;
                int left = 0;

                if(i>0)
                    up = max[i-1][j];
                if(j>0)
                    left = max[i][j-1];
                
                max[i][j] = Math.max(up,left)+gifts[i][j];
            }
        }

        return max[row-1][col-1];
    }
    private static int getMaxGift_2(int[][] gifts){
        if(gifts==null || gifts.length==0 || gifts[0].length==0)
            return 0;
        int row = gifts.length;
        int col = gifts[0].length;
        int[] max = new int[col];

        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = 0;
                int left = 0;

                if(i>0)
                    up = max[j];
                if(j>0)
                    left = max[j-1];
                
                max[j] = Math.max(up,left)+gifts[i][j];
            }
        }

        return max[col-1];
    }
}