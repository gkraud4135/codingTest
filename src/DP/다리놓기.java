
package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 다리놓기 {
    static int n = 5; // 전체 원소 개수
    static int r = 3; // 뽑을 개수
    static int[] arr = {1, 2, 3, 4, 5}; // 원소
    static int[] result; // 선택된 원소 저장


    public static void main(String[] args) {
        result = new int[r];
        combination(0, 0);
    }


    public static void combination(int idx, int depth) {
        if(depth == r) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i=idx; i<n; i++) {
            result[depth] = arr[i];
            combination(i+1, depth+1);
        }

    }


}