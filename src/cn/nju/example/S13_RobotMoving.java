package cn.nju.example;

public class S13_RobotMoving{
    public static void main(String[] args){
        
        System.out.println(movingCount(5, 5, 3));
        
    }

    private static int movingCount(int rows, int cols, int k){
        if(rows<=0 || cols<=0 || k<0) return 0;
        boolean[][] used = new boolean[rows][cols];
        return movingCountHelper(rows, cols, k, 0, 0, used);
    }

    private static int movingCountHelper(int rows, int cols, int k, int r, int c, boolean[][] used){
        int count = 0;
        if(check(rows, cols, k, r, c, used)){
            used[r][c] = true;
            count = 1 + movingCountHelper(rows, cols, k, r-1, c, used)
                    + movingCountHelper(rows, cols, k, r+1, c, used)
                    + movingCountHelper(rows, cols, k, r, c-1, used)
                    + movingCountHelper(rows, cols, k, r, c+1, used);
        }
        return count;
    }

    private static boolean check(int rows, int cols, int k, int r, int c, boolean[][] used){
        if(r>=0 && r<rows && c>=0 && c<cols
           && !used[r][c] && getDigitalSum(r)+getDigitalSum(c)<=k) return true;
        return false;
    }

    private static int getDigitalSum(int n){
        int sum = 0;
        while(n>0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}