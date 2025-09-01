import java.util.*;

public class CombinationExample {
    static int n = 5;       // 전체 원소 개수
    static int r = 3;       // 뽑을 개수
    static int[] arr = {1, 2, 3, 4, 5};
    static int[] result = new int[r];

    public static void main(String[] args) {
        combination(0, 0);
    }

    
    static void combination(int depth, int start) {
       
        if (depth == r) {
            System.out.println(Arrays.toString(result));
            return;
        }

       
        for (int i = start; i < n; i++) {
            result[depth] = arr[i];        
            combination(depth + 1, i + 1);  
        }
    }
}