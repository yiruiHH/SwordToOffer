package cn.nju.example;

public class S11_MinOfRotateArray{
    public static void main(String[] args){
        int nums1[] = {3,4,5,1,2};
        int nums2[] = {2,3,4,5,6,1};
        int nums3[] = {1,2,3,4,5,6};
        int nums4[] = {1,1,1,0,1};
        int nums5[] = {1,0,1,1,1};
        System.out.println(min(nums1));
        System.out.println(min(nums2));
        System.out.println(min(nums3));
        System.out.println(min(nums4));
        System.out.println(min(nums5));
    }

    private static int min(int[] array){
        int len = array.length;
        if(len==1) return array[0];
        if(array[0]<array[len-1]) return array[0];
        int left = 0;
        int right = len-1;
        while(left<right){
            if(left+1==right) break;
            int mid = left+(right-left)/2;
            if(array[left]==array[right] && array[left]==array[mid]){
                return minInOrder(array, left, right);
            }

            if(array[mid]>=array[left]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return array[right];
    }

    private static int minInOrder(int[] array, int left, int right){
        int res = array[left];
        for(int i=left;i<=right;i++){
            if(array[i]<res){
                res = array[i];
            }
        }
        return res;
    }
}