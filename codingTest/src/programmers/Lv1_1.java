package programmers;
public class Lv1_1 {
    // programmers lv1 과일장수 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 8분 코드 작성: 42분
    // 20221221 13:16PM~14:10PM

    //시간복잡도 생각해야함. for문을 많이쓰는 것이 좋지 않음. bigO Notation을 항상 생각해야함.
    class Solution {

        public int solution(int k, int m, int[] score) {
            int answer = 0;

            int a = score.length % m;
            int b = score.length / m;
            
            int g=0;
            
            int[] newscore = new int[score.length - a];

            for (int t = k; t > 0; t--) {
                for (int j = 0; j < score.length; j++) {
                    if (g< m*b) {
                        if (t == score[j]) {
                            newscore[g] = score[j];
                            g=g+1;
                        }
                    }
                }
            }

            for (int i = 1; i < b + 1; i++) {
                answer = answer + newscore[i * m - 1] * m;
            }
            return answer;
        }
    }
}
