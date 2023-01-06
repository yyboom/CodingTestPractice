package programmers;
public class Lv1_13 {
    // programmers lv1 [1차] 다트 게임 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 3분 코드 작성: 30분
    // 20230106 21:13PM~21:46
    class Solution {
        public int solution(String dartResult) {
            int answer = 0;

            //점수 저장
            int num[] = new int[3];
            // 횟수
            int b = 0;

            String[] result = dartResult.split("");
            // 앞선 점수
            String temp = "";

            for (int i = 0; i < result.length; i++) {

                if (result[i].equals("S")) {
                    int a = Integer.parseInt(temp);
                    num[b] = a;
                    b++;
                    temp = "";
                    continue;
                }
                if (result[i].equals("D")) {
                    int a = Integer.parseInt(temp);
                    num[b] = a * a;
                    b++;
                    temp = "";
                    continue;
                }
                if (result[i].equals("T")) {
                    int a = Integer.parseInt(temp);
                    num[b] = a * a * a;
                    b++;
                    temp = "";
                    continue;
                }
                if (result[i].equals("*")) {
                    num[b - 1] *= 2;
                    if (b > 1) {
                        num[b - 2] *= 2;
                    }
                    continue;
                }
                if (result[i].equals("#")) {
                    num[b - 1] *= -1;
                    continue;
                }
                temp += result[i];
                continue;
            }

            for (int i = 0; i < num.length; i++) {
                answer += num[i];
            }

            return answer;
        }
    }    
}
