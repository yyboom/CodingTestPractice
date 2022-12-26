package programmers;

public class Lv1_5 {
    // programmers lv1 명예의 전당(1) 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 3분 코드 작성:90분
    // 20221226 20:30PM~00:37
    // 런타임 에러때문에 시간 다잡아먹음. 짜놓고 보니 왜 라이브러리 안썼지 의문..라이브러리 안써도 충분히
    // 뭐든 구현은 다 가능함. 하지만 이 풀이는 주먹구구식 풀이임. 나중에 다시 풀어봐야 할듯.
    class Solution {
        public int[] solution(int k, int[] score) {
            int[] answer = new int[score.length];
            int tmp = 0;
            int a = 0;
            if (score.length >= k) {
                if (a == 0) {
                    answer[0] = score[0];
                    a = a + 1;
                }

                if (a > 0 && a < k - 1) {
                    for (int h = 1; h < k - 1; h++) { // 작은수부터 정렬
                        for (int t = 0; t < h + 1; t++) {
                            for (int j = t + 1; j < h + 1; j++) {
                                if (score[j] < score[t]) {
                                    tmp = score[j];
                                    score[j] = score[t];
                                    score[t] = tmp;
                                }
                            }
                        }
                        answer[h] = score[0];
                        a = a + 1;

                    }
                }

                if (a >= k - 1) {
                    for (int h = k - 1; h < score.length; h++) { // 큰수부터 정렬
                        for (int t = 0; t < h + 1; t++) {
                            for (int j = t + 1; j < h + 1; j++) {
                                if (score[j] > score[t]) {
                                    tmp = score[t];
                                    score[t] = score[j];
                                    score[j] = tmp;
                                }
                            }
                            answer[h] = score[k - 1];
                        }
                    }
                }
            } else {
                if (a == 0) {
                    answer[0] = score[0];
                    a = a + 1;
                }
                if (a > 0 && a < k - 1) {
                    for (int h = 1; h < score.length; h++) { // 작은수부터 정렬
                        for (int t = 0; t < h + 1; t++) {
                            for (int j = t + 1; j < h + 1; j++) {
                                if (score[j] < score[t]) {
                                    tmp = score[j];
                                    score[j] = score[t];
                                    score[t] = tmp;
                                }
                            }
                        }
                        answer[h] = score[0];
                        a = a + 1;

                    }
                }
            }

            return answer;
        }
    }
}
