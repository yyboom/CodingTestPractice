package chofolder.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

// 풀이 날짜: 20230309
// 풀이 시간: 22:31~22:50(pro시험 대비 동계 알고리즘 수업 복습용)
public class p10726 {
    public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("/vsworkspace/team3CotePrac/choCodingTest/src/chofolder/SWEA/input/num2.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();	
			int M = sc.nextInt();			
			// default를 true로 만들고 N개의 bit에서 1이 아닐때 바로 false로 바꾸면 됨.
			boolean switc = true;
			for (int i = 0; i < N; i++) {
				// 1을 오른쪽으로 보내면서 둘다 1이 아닐때 false가 되게함
				// 강의에서 A,B모두 친구인 사람은?에서 참고하면 됨.
				if ((M &(1 << i)) == 0) {
					switc = false;
					break;
				}
			}
			if(!switc) {
				System.out.println("#"+test_case+" OFF");
			}else {
				System.out.println("#"+test_case+" ON");
			}
		}
	}
}
