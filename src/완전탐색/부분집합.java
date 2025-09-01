import java.util.*;

public class AllSubsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        subset(arr, 0, new ArrayList<>());
    }

    static void subset(int[] arr, int idx, List<Integer> path) {
        if (idx == arr.length) {
            System.out.println(path);
            return;
        }

        // 포함
        path.add(arr[idx]);
        subset(arr, idx + 1, path);
        path.remove(path.size() - 1);

        // 미포함
        subset(arr, idx + 1, path);
    }
}