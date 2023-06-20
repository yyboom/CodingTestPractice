package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class Lv2_17 {
    // 20230620
    // 프로세스
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        // 1. 우선순위 큐를 써서 내림차순 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // pq내림차순 정렬
        for(int i:priorities) pq.add(i);

        // 2. 하나씩 같은 값과 인덱스가 같은 경우를 반환
        while(!pq.isEmpty()){
            for(int i=0;i<priorities.length;i++){
                if(priorities[i]==pq.peek()){
                    pq.poll();
                    answer++; // 앞에서부터 나오는 것이기 때문에 자리값을 더해줌.
                    if(i==location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
    
    public static void main(String args[]) throws Exception {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        // int[] priorities = {1, 1, 9, 1, 1, 1};
        // int location = 0;

        int answer = solution(priorities,location);
        System.out.println(answer);
    }
}
