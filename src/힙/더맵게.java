package 힙;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 더맵게 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {

        PriorityQueue<Integer> list = new PriorityQueue<>(Arrays.stream(scoville).boxed().toList());

        int answer = 0;
        while(list.size() > 1 &&  list.peek() < K){
            int num = list.poll();
            int num2 = list.poll();

            if(num >= K) {
                break;
            }

            list.add(num + (num2 * 2));
            answer++;
        }

        return list.peek() >= K ? answer : -1;
    }

}