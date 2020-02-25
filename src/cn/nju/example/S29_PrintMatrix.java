package cn.nju.example;

public class S29_PrintMatrix{
    public static void main(String[] args) {
        int[][] matrix = {
                        {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}
                        }; 
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix){
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;
        int start = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        while(col>start*2 && row>start*2){
            printCircle(matrix, start);
            start++;
        }
    }

    private static void printCircle(int[][] matrix, int start){
        int row = matrix.length;
        int col = matrix[0].length;
        int endX = col-1-start;
        int endY = row-1-start;

        for (int i = start; i <= endX; i++) {
            System.out.print(matrix[start][i]+" ");
        }

        if(start<endY){
            for (int i = start+1; i <= endY; i++) {
                System.out.print(matrix[i][endX]+" ");
            }
        }

        if(start<endX && start<endY){
            for (int i = endX-1; i >= start; i--) {
                System.out.print(matrix[endY][i]+" ");
            }
        }

        if(start<endX && start<endY-1){
            for (int i = endY-1; i >= start+1; i--) {
                System.out.print(matrix[i][start]+" ");
            }
        }
    }
}