package cn.nju.example;

public class S53_NumOfK{
    public static void main(String[] args) {
        S53_NumOfK s53_NumOfK = new S53_NumOfK();

        int data1[] = {1,2,3,3,3,3,4,5};
        s53_NumOfK.test(data1, 3, 4);

        int data2[] = {3, 3, 3, 3, 4, 5};
        s53_NumOfK.test(data2, 3, 4);

        int data3[] = {1, 2, 3, 3, 3, 3};
        s53_NumOfK.test(data3, 3, 4);

        int data4[] = {1, 3, 3, 3, 3, 4, 5};
        s53_NumOfK.test(data4, 2, 0);

        int data5[] = {1, 3, 3, 3, 3, 4, 5};
        s53_NumOfK.test(data5, 0, 0);

        int data6[] = {1, 3, 3, 3, 3, 4, 5};
        s53_NumOfK.test(data6, 6, 0);

        int data7[] = {3, 3, 3, 3};
        s53_NumOfK.test(data7, 3, 4);

        int data8[] = {3, 3, 3, 3};
        s53_NumOfK.test(data8, 2, 0);

        int data9[] = {3};
        s53_NumOfK.test(data9, 3, 1);

        int data0[] = {3};
        s53_NumOfK.test(data0, 2, 0);

        int nums[] = {0,1,2,4,5,6,7,8};
        System.out.println(s53_NumOfK.getMissingNum(nums, 0, nums.length-1));

        int nums2[] = {1,2,3,4,5,6,7,8};
        System.out.println(s53_NumOfK.getMissingNum(nums2, 0, nums2.length-1));

        int nums3[] = {0,1,2,3,4,5,6,8};
        System.out.println(s53_NumOfK.getMissingNum(nums3, 0, nums3.length-1));

        int nums4[] = {0};
        System.out.println(s53_NumOfK.getMissingNum(nums4, 0, nums4.length-1));
    }

    private int getNumOfK(int[] nums, int k){
        if(nums==null || nums.length==0) return 0;

        int first = getFirstK(nums, k, 0, nums.length-1);
        if(first==-1) return 0;

        int last = getLastK(nums, k, 0, nums.length-1);

        return last-first+1;
    }

    private int getFirstK(int[] nums, int k, int start, int end){
        if(start>end)
            return -1;
        int mid = start + (end-start)/2;
        int midData = nums[mid];

        if(midData==k){
            if(mid==0 || nums[mid-1]!=k){
                return mid;
            }
            else{
                end = mid - 1;
            }
        }
        else if(midData>k){
            end = mid - 1;
        }
        else{
            start = mid + 1;
        }

        return getFirstK(nums, k, start, end);
    }

    private int getLastK(int[] nums, int k, int start, int end){
        if(start>end)
            return 0;
        int mid = start + (end-start)/2;
        int midData = nums[mid];

        if(midData==k){
            if(mid==nums.length-1 || nums[mid+1]!=k){
                return mid;
            }
            else{
                start = mid + 1;
            }
        }
        else if(midData>k){
            end = mid - 1;
        }
        else{
            start = mid + 1;
        }

        return getLastK(nums, k, start, end);
    }

    private void test(int[] data, int k, int expected){
        int n = getNumOfK(data, k);
        if(n==expected){
            System.out.println("test passed...");
        }
        else{
            System.out.println("test failed...");
        }
    }

    private int getMissingNum(int[] nums, int start, int end){
        if(nums==null || nums.length==0) return 0;

        if(start>end)
            return -1;
        int mid = start + (end-start)/2;
        int midData = nums[mid];

        if(midData==mid){
            start = mid + 1;
        }
        else{
            if(mid==0)
                return 0;
            if(nums[mid-1]==mid-1){
                return mid;
            }
            end = mid - 1;
        }

        return getMissingNum(nums, start, end);
    }
}