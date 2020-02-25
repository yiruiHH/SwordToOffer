package cn.nju.example;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class S59_MaxInWindows{
    public static void main(String[] args) {
        S59_MaxInWindows obj = new S59_MaxInWindows();
        int[] nums = {2,3,4,2,6,2,5,1};
        System.out.println(Arrays.toString(obj.getMaxInWindows(nums, 1)));
        System.out.println(Arrays.toString(obj.getMaxInWindows(nums, 2)));
        System.out.println(Arrays.toString(obj.getMaxInWindows(nums, 3)));
    }

    private int[] getMaxInWindows(int[] nums, int windowsSize){
        if(nums==null || nums.length==0)
            return new int[0];
        int len = nums.length;
        int[] res = new int[len-windowsSize+1];
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < windowsSize; i++) {
            while(!dq.isEmpty() && nums[i]>=nums[dq.getLast()]){
                dq.pollLast();
            }
            dq.push(i);
        }

        for(int i = windowsSize; i<len; i++){
            res[i-windowsSize] = nums[dq.getFirst()];

            if(!dq.isEmpty() && (i-dq.getFirst())>=windowsSize){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[i]>=nums[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }
        res[res.length-1] = nums[dq.getFirst()];

        return res;
    }
}