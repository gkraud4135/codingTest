package DP;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {

    public static void main(String[] args) {
        solution(5, 12);
        System.out.println();

    }

    public static int solution(int N, int number) {
        if (N == number) return 1;

        // dp[i] : N을 i번 사용해 만들 수 있는 수들의 집합
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 0; i <= 8; i++) dp[i] = new HashSet<>();

        for (int i = 1; i <= 8; i++) {
            int concat = 0;
            for (int k = 0; k < i; k++) {
                concat = concat * 10 + N;
            }
            dp[i].add(concat);

            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                    }
                }
            }

            // 3) 목표 발견하면 바로 반환
            if (dp[i].contains(number)) return i;
        }

        System.out.println();

        return -1; // 8개 안에 못 만들면 실패
    }

}