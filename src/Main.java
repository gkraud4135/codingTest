import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] nodeType; // 노드의 집합은 0과 1로 구분
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            list = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            nodeType = new int[V + 1];
            isBipartite = true;

            for (int j = 1; j <= V; j++) {
                list[j] = new ArrayList<Integer>();
            }
            for (int j = 0; j < E; j++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                list[start].add(end);
                list[end].add(start);
            }

            for (int j = 1; j <= V; j++) {
                if (isBipartite) {
                    DFS(j);
                } else {
                    break;
                }
            }

            if (isBipartite) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    private static void DFS(int start){
        visited[start] = true;
        for (int adj : list[start]) {
            if(!visited[adj]){
                nodeType[adj] = (nodeType[start] + 1) % 2;
                DFS(adj);
            } else if (nodeType[start] == nodeType[adj]) {
                isBipartite = false;
            }
        }
    }
}