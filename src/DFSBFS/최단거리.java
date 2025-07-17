package DFSBFS;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844
import java.util.*;
import java.io.IOException;

public class 최단거리 {

    public static void main(String[] args) throws IOException {

        int answer = solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}});
        System.out.println(answer);
    }

    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()){ // bfs
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];

            if(x == n-1 && y == m-1){
                return cnt; // 최단 거리 반환 (bfs: 가장 처음 return 되는게 최단 거리)
            }

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >=0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, cnt+1});
                }
            }
        }

        return -1;
    }

}