package 스택큐;

import java.util.*;

public class 주식가격 {

    public static void main(String[] args) {
        solution(new Integer[]{1,2,3,2,3});
        System.out.println();

    }

    public static void solution(Integer[] arr) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(arr));
        List<Integer> answer = new ArrayList<>();

        while(!queue.isEmpty()) {
            int num = queue.poll();
            int count = 0;

            for(Integer target : queue) {
                if(num <= target) count++;
            }

            answer.add(count);
        }

        for(Integer target : answer) {
            System.out.println(target);
        }
    }

}