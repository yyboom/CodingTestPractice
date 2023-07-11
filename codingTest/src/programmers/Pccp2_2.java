package programmers;
import java.util.*;
public class Pccp2_2 {
    // 20230712
    // Pccp 모의고사 2회 2번
    // 신입사원 교육
    public static int solution(int[] ability, int number) {
        int answer = 0;
        // 시간이 오래걸림
//         // 1. number에 따라서 오름차순 정렬을 하여 앞에 두개 값을 바꿔줌
//         Arrays.sort(ability);
//         for(int i=0;i<number;i++){
//             int sum = ability[0]+ability[1];
//             ability[0]=ability[1]=sum;
//         }
        
//         // 2. 전체 다 더해줌
//         for(int i=0;i<ability.length;i++){
//             answer+=ability[i];
//         }
        
        // 최소힙 사용
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for(int i=0;i<ability.length;i++){
            qu.add(ability[i]);
        }
        
        for(int i=0;i<number;i++){
            int sum = qu.poll()+qu.poll();
            // 자동정렬 될것
            qu.add(sum);
            qu.add(sum);
        }
        
        for(int i=0;i<ability.length;i++){
            answer+=qu.poll();
        }
        
        return answer;
    }
}
