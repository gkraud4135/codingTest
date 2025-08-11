package 그리디;

public class 큰수구하기 {

    public static void main(String[] args) {
        String num = solution("1924", 2);
        System.out.println(num);

    }

    public static String solution(String number, int k) {
        int size = number.length() - k;  // 최종적으로 만들 숫자의 길이
        StringBuilder sb = new StringBuilder(); // 결과를 담을 StringBuilder

        int index = 0; // 다음 탐색 시작 위치
        for(int i = 0; i < size; i++) { // size 길이만큼 반복
            int max = 0; // 이번 자리에서 뽑을 최대 숫자

            // j는 현재 자리에서 선택 가능한 범위 중 최대 숫자 찾기
            for(int j = index; j <= i + k; j++) {
                if(max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0'; // 최대값 갱신
                    index = j + 1; // 다음 탐색 시작 위치 (그 이후부터 탐색)
                }
            }
            sb.append(max); // 선택된 숫자를 결과에 추가
        }
        return sb.toString(); // 최종 문자열 반환
    }

}