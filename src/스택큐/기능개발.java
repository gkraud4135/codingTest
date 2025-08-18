package 스택큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {

    public static void main(String[] args) {
        solution(new int[]{93,30,55}, new int[]{1,30,5});
        System.out.println();

    }

    public static void solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();

        for(int i=0; i<progresses.length; i++){
            queue.add((int)Math.ceil((100.0-progresses[i])/speeds[i]));
        }

        while(!queue.isEmpty()){
            int minDays = queue.poll();
            int count = 1;

            while(!queue.isEmpty() && queue.peek() <= minDays){
                queue.poll();
                count++;
            }
            answer.add(count);
        }

    }

}