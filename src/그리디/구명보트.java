package 그리디;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        solution(new int[]{70, 50, 80, 50}, 100);


    }

    public static void solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0; // 가장 가벼운 사람
        int right = people.length - 1; // 가장 무거운 사람
        int count = 0; // 보트 개수

        while (left <= right) {
            // 가장 가벼운 사람 + 가장 무거운 사람 태울 수 있으면 함께 태움
            if (people[left] + people[right] <= limit) {
                left++;
            }
            // 무거운 사람은 항상 태움
            right--;
            count++;
        }

        System.out.println(count);
    }

}