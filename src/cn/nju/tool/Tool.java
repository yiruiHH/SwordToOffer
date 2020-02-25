package cn.nju.tool;

import java.util.Random;
import java.util.Arrays;

public class Tool{
    // 快速幂算法
    public static long QuickPow(int a, int b){
        long res = 1;
        while(b!=0){
            if((b&1)==1) res = res * a;
            a *= a;
            b >>= 1;
        }
        return res;
    }

    //快速排序
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort(int[] array, int start, int end){
        if(start==end)
            return;
        int index = partition(array, start, end);
        if(index>start)
            quickSort(array, start, index-1);
        if(index<end)
            quickSort(array, index+1, end);
    }

    private static int partition(int[] data, int start, int end){
        if(data==null || data.length==0 || start<0 || end>=data.length)
            throw new IllegalArgumentException("Invalid parameters.");
        
        int index = RandomInRange(start, end);
        swap(data, index, end);

        int small = start-1;
        for(index=start;index<end;index++){
            if(data[index]<data[end]){
                small++;
                if(small!=index)
                    swap(data, index, small);
            }
        }
        small++;
        swap(data, small, end);
        return small;
    }

    private static int RandomInRange(int start, int end){
        Random random = new Random();
        int r = random.nextInt(end-start+1);
        return r+start;
    }

    private static void swap(int[] data, int index1, int index2){
        int i1 = data[index1];
        data[index1] = data[index2];
        data[index2] = i1; 
    }

    public static void main(String[] args){
        int[] array = {3,7,2,6,4,5,1,8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}