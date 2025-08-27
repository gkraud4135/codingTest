package DP;

public class 피보나치 {

    public static void main(String[] args) {
        solution(10);
        System.out.println();

    }

    public static void solution(int num) {
        int[] arr = new int[num+1];
        for(int i=0; i<=num; i++) {
            if(i==0){
                arr[i] = 0;
            } else if(i==1){
                arr[i] = 1;
            } else {
                arr[i] = arr[i-2] + arr[i-1];
            }
        }

        System.out.println(arr[10]);
    }

}