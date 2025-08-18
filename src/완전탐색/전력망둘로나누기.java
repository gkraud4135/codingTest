package 완전탐색;

import java.util.ArrayList;
import java.util.List;

public class 전력망둘로나누기 {

    public static void main(String[] args) {
        solution(9, new int[][]{
            {1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}
        });
        System.out.println();

        solution(4, new int[][]{
                {1,2},{2,3},{3,4}
        });

        System.out.println();

    }

    static boolean[] isVisited;
    static List<Integer>[] list;

    public static void solution(int num, int[][] arr) {


         list = new ArrayList[num+1];
        // 그래프 ArrayList 초기화. 노드 개수만큼 ArrayList 생성
        for (int i = 1; i <= num; i++) {
            list[i] = new ArrayList<>();
        }

         for(int[] check : arr) {
             list[check[0]].add(check[1]);
             list[check[1]].add(check[0]);
         }

         int answer = Integer.MAX_VALUE;

         for(int i=0; i<arr.length; i++) {
             isVisited = new boolean[num + 1];

             list[arr[i][1]].remove(Integer.valueOf(arr[i][0]));
             list[arr[i][0]].remove(Integer.valueOf(arr[i][1]));

             int cnt = dfs(1, 0);
             int diff = Math.abs(cnt - (num - cnt));
             answer = Math.min(answer, diff);
             System.out.println(cnt);

             list[arr[i][1]].add(arr[i][0]);
             list[arr[i][0]].add(arr[i][1]);
         }

        System.out.println();
        System.out.println(answer);
    }

    public static int dfs(int num, int answer) {
        isVisited[num] = true;
        answer++;

        for(int next : list[num]) {
            if(!isVisited[next]){
                answer = dfs(next, answer);
            }
        }

        return answer;
    }

}