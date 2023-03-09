package chofolder.SWEA;

import java.io.FileInputStream;
import java.util.Scanner;

// 풀이 날짜: 20230309
// 풀이 시간: 16:55~17:20(pro시험 대비 동계 알고리즘 수업 복습용)
public class p1288 {
   	// 전체 숫자를 다 봤는지 체크
	private static boolean checknum(boolean[] numcheck) {
		for (int i = 0; i < 10; i++) {
			if (!numcheck[i]) {
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("/vsworkspace/team3CotePrac/choCodingTest/src/chofolder/SWEA/input/num1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			
			// boolean형으로 check
			boolean[] numcheck = new boolean[10];
			int k = 0;
			
			// 전체 숫자를 다 볼 때까지 양 세기 반복
			while (!checknum(numcheck)) {
				char[] number = String.valueOf(N * (k+1)).toCharArray();
				// 숫자 봤는지 체크
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < number.length; j++) {
						// XOR를 사용해서 일치여부 check
						if ((i ^ (number[j] - '0')) == 0) {
							numcheck[i] = true;
							break;
						}
					}
				}
				k++;
			}
			System.out.println("#"+test_case+" "+N * k);
		}
	} 
}
