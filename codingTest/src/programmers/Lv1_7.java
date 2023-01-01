package programmers;

public class Lv1_7 {
    // programmers lv1 기사단원의 무기 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 7분 코드 작성:28분
    // 20230101 13:55PM~14:30
    class Solution {
        // 약수의 개수 구하는 함수
        public long divisor(int number) {
            int an = 0;
            //N의 가장 큰 약수는 N을 제외하면 최대 N의 절반임!!
            //https://mygumi.tistory.com/122
            for (int i = 1; i * i < number + 1; i++) {
                if (number % i == 0) {
                    an++;
                    if (i * i < number) {
                        an++;
                    }
                }
            }
            return an;
        }

        public int solution(int number, int limit, int power) {
            int answer = 0;
            for (int i = 1; i < number + 1; i++) {
                long a = divisor(i);
                if (a > limit) {
                    answer += power;
                } else {
                    answer += a;
                }
            }

            return answer;
        }
    }
}
