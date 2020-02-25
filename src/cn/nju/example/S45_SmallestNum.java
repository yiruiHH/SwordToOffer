package cn.nju.example;

import java.util.Arrays;
import java.util.Comparator;

public class S45_SmallestNum {
    public static void main(String[] args) {
        Integer[] nums1 = {3,32,321};
        minNum(nums1);
        Integer nums2[] = {3, 5, 1, 4, 2};
        minNum(nums2);
        Integer nums3[] = {3, 323, 32123};
        minNum(nums3);
        Integer nums4[] = {1, 11, 111};
        minNum(nums4);
        Integer nums5[] = {321};
        minNum(nums5);
    }

    private static void minNum(Integer[] nums){
        if(nums==null || nums.length==0) return;

        Arrays.sort(nums,new MinNumComparator());

        for (int i = 0; i < nums.length;i++) {
            System.out.print(nums[i]);
        }

        System.out.println();
    }

    
}

class MinNumComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b){
        String str_a = String.valueOf(a);
        String str_b = String.valueOf(b);

        String ab = str_a+str_b;
        String ba = str_b+str_a;

        for (int i = 0; i < ab.length(); i++) {
            if(ab.charAt(i)<ba.charAt(i)){
                return -1;
            }
            else if(ab.charAt(i)>ba.charAt(i)){
                return 1;
            }
            else{
                continue;
            }
        }
        return 0;
    }
}