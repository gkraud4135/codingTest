package 스택큐;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

    public static void main(String[] args) {
        solution(new Integer[]{7,4,5,6}, 2, 10);
        solution(new Integer[]{10}, 100, 100);
        solution(new Integer[]{10,10,10,10,10,10,10,10,10,10}, 100, 100);
        System.out.println();

    }

    public static void solution(Integer[] arr, int len, int weight) {

        int cnt = 0;
        int total = 0;
        Queue<Integer> arr1 = new LinkedList<>(Arrays.asList(arr));
        Queue<Integer> inQue = new LinkedList<>();
        while(!arr1.isEmpty()) {
            if(inQue.size() == len) {
                int num = inQue.poll();
                total -= num;
            }

            if(total + arr1.peek() <= weight) {
                int num = arr1.poll();
                inQue.add(num);
                total += num;
            } else {
                inQue.add(0);
            }


            cnt++;
        }

        System.out.println(cnt + len);

    }

}