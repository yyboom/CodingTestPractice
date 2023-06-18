package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Lv2_15 {
    // 20230618
    // 기능개발
    public static int[] solution(int[] progresses, int[] speeds) {
        // 1. deque에 progress와 speeds넣기
        Deque<Integer> dprogresses = new ArrayDeque<>();
        Deque<Integer> dspeeds = new ArrayDeque<>();
        
        for(int i=0;i<progresses.length;i++){
            dprogresses.add(progresses[i]);
            dspeeds.add(speeds[i]);
        }

        // 2. deque로 앞에서부터 빼주면서 100이 넘으면 출력
        int cnt = 0; // 현재 몇일이 지났는지 판단
        ArrayList<Integer> result = new ArrayList<>();
        while(dprogresses.size()!=0){
            int ds = dspeeds.poll();
            int dp = dprogresses.poll();
            int adp = dp+(cnt*ds);
            if(adp>=100){ // 개발이 완료되었을 때
                int c =1;
                int ad = 100;
                while(ad>=100&&dprogresses.size()!=0){
                    int dds = dspeeds.poll();
                    int ddp = dprogresses.poll();
                    int bdp = ddp+(cnt*dds);

                    if(bdp>=100){
                        c++;
                    }else{
                        dprogresses.addFirst(ddp);
                        dspeeds.addFirst(dds);
                        ad=0;
                    }
                }
                result.add(c);
            }else{ // 개발이 완료되지 않았기 때문에 다시 넣어줌.
                dprogresses.addFirst(dp);
                dspeeds.addFirst(ds);
            }

            cnt++;
        }

        // 3. result를 array로 옮겨줌
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++) answer[i] = result.get(i);
        return answer;
    }

    public static void main(String args[]) throws Exception {
        // int[] progresses = {100, 50, 99, 100};
        // int[] speeds = {1, 1, 1, 1};
        int[] progresses = {20, 99, 93, 30, 55, 10};
        int[] speeds = {5, 10, 1, 1, 30, 5};

        int[] answer = solution(progresses,speeds);
        for(int i: answer) System.out.printf(i+" ");
    }
}
