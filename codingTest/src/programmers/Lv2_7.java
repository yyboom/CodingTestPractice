package programmers;

public class Lv2_7 {
    // 카펫
    // 20230604
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // 1. 면적의 넓이가 큰 순서대로 탐색함.
        int s = brown + yellow; // 전체 면적

        for (int i = 3; i < s; i++) { // 격자를 가지기 위해선 가로 세로가 길이가 3이상이 되어야 함.
            int j = s / i;

            if (s % i == 0 && j >= 3) {
                int sero = Math.min(j, i);
                int garo = Math.max(i, j); // 가로가 세로보다 길거나 같음

                int yy = (sero - 2) * (garo - 2);

                // 찾았을 때
                if (yellow == yy) {
                    answer[0] = garo;
                    answer[1] = sero;
                }
            }
        }
        return answer;
    }
}
