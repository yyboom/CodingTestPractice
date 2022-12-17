package programmers;
public class Lv0_2 {
	// programmers lv0 평행 문제 정답
	// 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 10분 코드 작성: 39분
	// 20221216 23:05PM~23:54PM 
	class Solution {
			
		public int solution(int[][] dots) {
			int answer = 0;

			int R1 = 0;
			int R2 = 0;
			int R3 = 0;
			int R4 = 0;

			int H1 = 0;
			int H2 = 0;
			int H3 = 0;
			int H4 = 0;

			for (int i = 3; i >-1 ; i = i - 1) {
				int a1 = dots[0][0];
				int b1 = dots[0][1];
				int a2 = dots[1][0];
				int b2 = dots[1][1];
				int a3 = dots[2][0];
				int b3 = dots[2][1];
				int a4 = dots[3][0];
				int b4 = dots[3][1];
				
				//1차이 날 때
				R1 = a2-a1;
				R2 = b2-b1;
				R3=a4-a3;
				R4=b4-b3;

				//2차이 날 때
				H1 = a3-a1;
				H2 = b3-b1;
				H3 = a4-a2;
				H4 = b4-b2;

			}
				if(R2*R3-R4*R1 ==0 || H2*H3-H4*H1==0){
					answer =1;
				}else{
					answer = 0;
				}
				return answer;
			}
	}

    
}
