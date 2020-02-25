package cn.nju.example;

public class S60_Probability{
    private int dice = 6;
    public static void main(String[] args) {
        S60_Probability obj = new S60_Probability();
        obj.printProbability(2);
        obj.printProbability_2(2);
    }

    private void printProbability(int n){
        int maxSum = dice * n;
        int[] probability = new int[maxSum-n+1];
        probability(n,probability);
        int total = (int)Math.pow(dice,n);
        for(int i=0;i<maxSum-n+1;i++){
            System.out.println((i+n)+"--->"+((double)probability[i]/(double)total));
        }
    }

    private void probability(int n, int[] probability){
        for(int i=1;i<=dice;i++){
            probability(n,n-1,i,probability);
        }
    }

    private void probability(int ori, int cur, int sum, int[] probability){
        if(cur==0){
            probability[sum-ori]++;
        }
        else{
            for(int i=1;i<=dice;i++){
                probability(ori,cur-1,sum+i,probability);
            }
        }
    }

    private void printProbability_2(int n){
        int maxSum = dice * n;
        int[][] probability = new int[2][maxSum+1];

        int flag = 0;
        for (int i = 1; i <= dice; i++) {
            probability[flag][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for(int j=i;j<=dice*i;j++){
                for(int k=1;k<=j && k<=dice;k++){
                    probability[1-flag][j] += probability[flag][j-k];
                }
            }
            flag = 1-flag;
        }

        int total = (int)Math.pow(dice,n);
        for(int i=n;i<maxSum+1;i++){
            System.out.println((i)+"--->"+((double)probability[flag][i]/(double)total));
        }
    }
}