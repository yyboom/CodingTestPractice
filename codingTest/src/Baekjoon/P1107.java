package chofolder.Baekjoon;

import java.io.FileInputStream;
import java.util.Scanner;

// 풀이 날짜: 20230306
// 풀이 시간: 17:00~17:40
public class P1107 {

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("/vsworkspace/team3CotePrac/choCodingTest/src/chofolder/input/p1107.txt"));
        Scanner sc = new Scanner(System.in);

        // 1.입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] broken = new int[10];
        for (int j = 0; j < M; j++) {
            broken[sc.nextInt()] = 1; // 고장난 버튼이 1
        }

        // 2. 최대한 가까운 채널로 이동하기;
        int result = Math.abs(100 - N);
        for (int j = 0; j <= 999999; j++) { // 진짜 전체 탐색을 함..........홀리....
            String str = String.valueOf(j);

            int breakok = 0;
            for (int h = 0; h < str.length(); h++) {
                if (broken[str.charAt(h) - '0'] == 1) { // 고장난 버튼 눌렀을 때
                    breakok=1;
                    break;
                }
            }
            // 전부다 고장난 버튼이 아니었을 때
            // 3. +,-로 맞춰주기
            // 최소값으로 반환
            if(breakok==0)result = Math.min(result, str.length() + Math.abs(j - N));
        }

        System.out.println(result);
    }
}
