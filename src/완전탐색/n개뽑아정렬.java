import java.util.*;

public class PartialPermutation {
    static boolean[] visited;
    static List<Integer> path = new ArrayList<>();
    static int n, r;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4}; // 원소
        n = arr.length;
        r = 2; // 뽑을 개수

        visited = new boolean[n];
        permute(arr, 0);
    }

    static void permute(int[] arr, int depth) {
        if (path.size() == r) { // r개 뽑으면 출력
            System.out.println(path);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.add(arr[i]);

                permute(arr, depth + 1);

                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}