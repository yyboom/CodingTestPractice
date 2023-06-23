package programmers;

import java.util.PriorityQueue;

public class Lv2_20 {
    // 20230623
    // 더 맵게
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 1. scoville 우선순위 큐에 넣어주기
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i:scoville) heap.offer(i); // add와 offer의 차이점은 add는 이미 다 찬 경우 예외를 발생시키지만 offer은 추가 실패를 의미하는 false를 리턴한다.
        // add일때가 시간상은 덜 걸림. 예외시에 return을 하지 않기 때문임.

        // 2. 스태빌 지수를 K보다 작은게 없을때까지 측정해줌
        while(heap.peek() < K){
            if(heap.size()==1) return -1; // 모든 음식의 스코빌 지수를 K이상으로 만들 수 없는 경우

            int min = heap.poll(); // 제일 작은 수
            int min2 = heap.poll(); // 그다음으로 작은 수

            int result = min+(min2*2);
            heap.offer(result);

            answer++;
        }

        return answer;
    }

    public static void main(String args[]) throws Exception {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int answer = solution(scoville,K);
        System.out.println(answer);
    }
}
