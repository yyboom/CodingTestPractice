package chofolder.Baekjoon;

import java.io.FileInputStream;
import java.util.Scanner;

// 풀이 날짜: 20230304
// 풀이 시간: 16:58~17:15
public class P4375 {
    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("/vsworkspace/team3CotePrac/choCodingTest/src/chofolder/input/p4375.txt"));
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) { // input이 있을 때까지 돌아감.(평소 쓰던 input체계랑 다르니 조심.)
            int n = sc.nextInt();
            int ten = 1;
            int num = 1;

            for (int i = 0;; i++) { // 제한 없이 돌아감.
                if (ten % n == 0) {
                    System.out.println(num);
                    break;
                } else {
                    ten = ten * 10 + 1;
                    ten %= n; // 나눠준 뒤 판단해줌으로써 시간을 1/2로 줄여줌.
                    num++;
                }
            }
        }
    }
}