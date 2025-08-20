package 힙;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {

    public static void main(String[] args) {
        int answer = solution(new int[][]{{0,3},{1,9},{3,5}});
        System.out.println(answer);

    }

    public static int solution(int[][] arr) {
        class Work implements Comparable<Work> {
            int time; // 작업의 소요시간이 짧은 것
            int request; // 작업의 요청 시각이 빠른 것
            int index; //작업의 번호가 작은 것

            Work(int time, int request, int index) {
                this.time = time;
                this.request = request;
                this.index = index;
            }

            @Override
            public int compareTo(Work o) {
                if(this.time == o.time) {
                    if(this.request == o.request) {
                        return this.index - o.index;
                    } else {
                        return this.request - o.request;
                    }
                } else {
                    return this.time - o.time;
                }
            }
        }

        PriorityQueue<Work> list = new PriorityQueue<>();

        int index = 0;
        for(int[] num : arr) {
            Work work = new Work(num[1], num[0], index);
            list.add(work);
            index++;
        }

        List<Integer> answer = new ArrayList<>();
        int count = 0;
        while(!list.isEmpty()) {
            Work work = list.poll();
            count = count + work.time;
            answer.add(count - work.request);
        }

        int ans = 0;
        for(int num : answer) {
            ans = ans + num;
        }

        return ans/answer.size();
    }

}