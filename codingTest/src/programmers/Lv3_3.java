package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lv3_3 {
    // 20230624
    // 디스크 컨트롤러
    public static int solution(int[][] jobs) {
        int answer = 0;
        int process = 0; // 처리작업개수
        int endtime=0;
        int jobidx =0; // 작업의 위치

        // 1. 작업이 들어오는 순서대로 오름차순 정렬
        Arrays.sort(jobs, ((o1, o2) -> o1[0]-o2[0])); // 시간에 따라 오름차순 배열

        // 2. 작업시간이 끝난지점에서 요청받은 것들 중 가장 시간이 짧은 거부터 처리
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1]-o2[1])); // 처리시간에 따라 오름차순으로 정렬
        while(process < jobs.length){ // 작업이 다 처리될 때까지
            // 하나의 작업이 완료되는 시점까지 들어온 요청들을 pq에 다 넣어줌.
            for(int i=jobidx;i<jobs.length;i++){
                if(jobs[i][0]<=endtime){
                    pq.add(jobs[i]);
                    jobidx++;
                }else break;
            }

            // 들어있는 pq가 없을 때
            if(pq.isEmpty()) endtime = jobs[jobidx][0];
            else{
                int[] temp = pq.poll();
                answer += temp[1] + endtime - temp[0];
                endtime += temp[1];
                process++;
            }
        }

        return (int)Math.floor(answer/jobs.length);
    }
    public static void main(String args[]) throws Exception {
        int[][] jobs = {{0,3},{1,9},{2,6}};

        int answer = solution(jobs);
        System.out.println(answer);
    }
}
