package chofolder.Baekjoon;
import java.util.*;
public class P2750 {
    	// Baekjoon 2750 문제 정답(baekjoon입출력 테스트)
		// 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 1분 코드 작성: 2분 
		// 20230113 13:55PM~13:58AM
        public void main(String args[]) throws Exception{
			Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            Integer[] new1 = new Integer[T];
			for (int t=0; t < T; t++) {
                new1[t]=sc.nextInt();

            }

            Arrays.sort(new1);

            for(int i=0;i<new1.length;i++){
                System.out.println(new1[i]);
            }
			
	    }
        
}
