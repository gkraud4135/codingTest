package 힙;

import java.util.*;

public class 이중우선큐 {

    public static void main(String[] args) {
        //int[] answer = solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
        int[] answer = solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
        System.out.println(answer[0]);
        System.out.println(answer[1]);

    }

    public static int[] solution(String[] arr) {
        PriorityQueue<Integer> list = new PriorityQueue<>();

        for(String str : arr) {
            String act = str.charAt(0) + "";
            Integer num = Integer.valueOf(str.substring(2));
            if(act.equals("I")) {
                list.add(num);
            } else if(act.equals("D")) {
                if(list.size() > 0) {
                    if(num > 0) {
                        list.remove(Collections.max(list));
                    } else {
                        list.poll();
                    }
                }
            }
        }

        if(list.isEmpty()) return new int[]{0, 0};
        return new int[]{Collections.max(list), list.peek()};
    }

}