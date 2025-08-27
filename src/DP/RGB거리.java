package DP;

public class RGB거리 {

    public static void main(String[] args) {
        solution(new int[][]{{26,40,83},{49,60,57},{13,89,99}});
        System.out.println();

    }

    public static void solution(int[][] arr) {
        int len = arr.length;
        int[][] dp = new int[len][3];

        for(int i=0; i<len; i++) {
            if(i==0) {
                dp[i][0] = arr[i][0];
                dp[i][1] = arr[i][1];
                dp[i][2] = arr[i][2];
            } else {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }
        }

        int answer = Math.min(Math.min(dp[len-1][0], dp[len-1][1]), dp[len-1][2]);
        System.out.println(answer);

    }

}