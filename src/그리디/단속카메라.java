pakage 그리디;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        // 종료 시간 기준으로 오름차순 정렬
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        
        int cameras = 0;
        int cameraPos = Integer.MIN_VALUE; // 아직 설치 안 했음을 나타냄
        
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            // 현재 카메라로 이 차량을 찍을 수 없다면 새로 설치
            if (start > cameraPos) {
                cameras++;
                cameraPos = end; // 카메라는 그 차량의 끝 지점에 설치
            }
            // else 현재 cameraPos가 start <= cameraPos <= end 이므로 이미 찍힘
        }
        return cameras;
    }
}