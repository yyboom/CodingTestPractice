package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv2_18 {
    // 20230621
    // 다리를 지나는 트럭
    public  static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = bridge_length;

        // 1. 다리를 queue로 생각하여 현재 다리 위에 있는 트럭들을 넣어주기
        Queue<Integer> queue = new LinkedList<>();
        int sum =0; // 다리 위에 있는 트럭 수
        int time =0; // 트럭들이 지나가는 시간

        for(int i=0;i<truck_weights.length;i++){
            int truck = truck_weights[i];
            while(true){
                if(queue.isEmpty()){ // 2. 다리 위에 아무 트럭도 없는 경우
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                }else if(queue.size()==bridge_length){
                    sum -= queue.poll();
                }else{
                    
                }
            }
        }
        return answer;
    }

    public static void main(String args[]) throws Exception {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        // int bridge_length = 100;
        // int weight = 100;
        // int[] truck_weights = {10};
        // int bridge_length = 100;
        // int weight = 100;
        // int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};

        int answer = solution(bridge_length,weigh,truck_weights);
        System.out.println(answer);
    }
}
