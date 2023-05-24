package programmers;

public class Lv1_16 {
    // 공원 산책
    // 20230524
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        // 1. S지점 파악 및 지도 배열 2차원으로 넣어주기
        for (int i = 0; i < park.length; i++) {
            String sen = park[i];
            for (int j = 0; j < sen.length(); j++) {
                // 시작 지점 파악
                if (sen.charAt(j) == 'S') {
                    answer[0] = i; // 세로
                    answer[1] = j; // 가로
                    break;
                }
            }
        }

        // 2. 루트 파악
        for (int i = 0; i < routes.length; i++) {
            String[] sen = routes[i].split(" ");
            if (sen[0].equals("N")) { // 북
                int num = answer[0] - Integer.parseInt(sen[1]);
                if (num < 0) { // map을 벗어나는지 파악
                    continue;
                } else {
                    int y = answer[0];
                    for (int j = 1; j <= Integer.parseInt(sen[1]); j++) { // 장애물이 있는지 파악
                        if (park[y - j].charAt(answer[1]) == 'X') {
                            answer[0]=y;
                            break;
                        } else {
                            answer[0] = answer[0] - 1;
                        }
                    }
                }
            }
            if (sen[0].equals("S")) { // 남
                int num = answer[0] + Integer.parseInt(sen[1]);
                if (num >= park.length) {
                    continue;
                } else {
                    int y = answer[0];
                    for (int j = 1; j <= Integer.parseInt(sen[1]); j++) { // 장애물이 있는지 파악
                        if (park[y+j].charAt(answer[1]) == 'X') {
                            answer[0]=y;
                            break;
                        } else {
                            answer[0] = answer[0] + 1;
                        }
                    }
                }
            }
            if (sen[0].equals("W")) { // 서
                int num = answer[1] - Integer.parseInt(sen[1]);
                if (num < 0) {
                    continue;
                } else {
                    int x = answer[1];
                    for (int j = 1; j <= Integer.parseInt(sen[1]); j++) { // 장애물이 있는지 파악
                        if (park[answer[0]].charAt(x - j) == 'X') {
                            answer[1]=x;
                            break;
                        } else {
                            answer[1] = answer[1] - 1;
                        }
                    }
                }
            }
            if (sen[0].equals("E")) { // 동
                int num = answer[1] + Integer.parseInt(sen[1]);
                if (num >= park[0].length()) {
                    continue;
                } else {
                    int x = answer[1];
                    for (int j = 1; j <= Integer.parseInt(sen[1]); j++) { // 장애물이 있는지 파악
                        if (park[answer[0]].charAt(x+j) == 'X') {
                            answer[1]=x;
                            break;
                        } else {
                            answer[1] = answer[1] + 1;
                        }
                    }
                }
            }
        }
        return answer;
    }
}
