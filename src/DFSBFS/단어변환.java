package DFSBFS;

/*
https://school.programmers.co.kr/learn/courses/30/lessons/43163
*/

import java.util.*;
import java.io.IOException;

public class 단어변환 {

    public static void main(String[] args) throws IOException {

        solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});

    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int[] visit = new int[words.length];
        Queue<Integer> que = new LinkedList<>();
        int check = 0;

        // words 배열 문자열중 한 알파벳만 다를 경우 begin에 다시 넣고 시작
        for(int i = 0; i<words.length; i++){
            if(visit[i] == 0 && diff(begin, words[i]) == 1){
                que.add(i);
                visit[i] = 1;
            }

            if(target.equals(words[i])){
                check = 1;
            }
        }

        // 변활할 수 없는 경우 0
        if(check == 0) return 0;

        while(!que.isEmpty()){
            int idx = que.poll();
            String str = words[idx];

            if(str.equals(target)){
                answer = visit[idx];
                break;
            }

            for(int i = 0; i<words.length; i++){
                if(visit[i] == 0 && diff(str, words[i]) == 1){
                    que.add(i);
                    visit[i] = visit[idx] + 1;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }

    static int diff(String start, String last){

        int cnt = 0;
        for(int i = 0; i<last.length(); i++){
            if(start.charAt(i) != last.charAt(i)){
                cnt++;
            }
        }

        return cnt;
    }

}