package DFSBFS;

import java.io.IOException;

// https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java

public class 네트워크 {

    static boolean visit[];

    public static void main(String[] args) throws IOException {
        solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}); //2
        solution(3, new int[][]{{1,1,0},{1,1,1},{0,1,1}}); //1

    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];


        for(int i=0; i<n; i++) {
            if(visit[i] == false) {
                answer++;
                DFS(i, computers, n);
            }
        }

        System.out.println(answer);
        return answer;
    } // End of main

    static void DFS(int i, int computers[][], int n) {
        visit[i] = true;

        for(int j=0; j<n; j++) {
            if(visit[j] == false && computers[i][j] == 1) {
                DFS(j, computers, n);
            }
        }

    } // End of DFS

}