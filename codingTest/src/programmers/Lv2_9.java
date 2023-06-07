package programmers;

import java.util.ArrayList;

public class Lv2_9 {
    // 전력망을 둘로 나누기
    // 20230606
    static ArrayList<Integer>[] graph; // arraylist에 배열 넣어주는 방법
    static boolean[] visited;
    static int answer;
    public static int solution(int n, int[][] wires) {
        answer = 10000;

        // 1. 방향이 없는 그래프에 넣어주기
        // 그래프를 형성하는 방법: 인접행렬, 인접리스트(배열의 크기가 크면 사용)
        graph = new ArrayList[n+1]; // arraylist에 배열 넣어주는 방법
        visited = new boolean[n+1]; // 0은 언제나 false라는 것을 기억
        for(int i=1;i<n+1;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<wires.length;i++){
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }

        // 2. 연결된 것을 끊어가면서 차이를 계산
        for(int i=0;i<wires.length;i++){
            graph[wires[i][0]].remove(Integer.valueOf(wires[i][1])); // index가 아닌 특정 value값을 삭제
            graph[wires[i][1]].remove(Integer.valueOf(wires[i][0]));
            visited[wires[i][0]] = true;
            int cnt1=1;

            // 탐색
            int cnt = bfs(wires[i][0],cnt1);

            // 3. min값을 계속해서 갱신해줌
            int abs = Math.abs(cnt-(n-cnt));
            answer = Math.min(answer, abs);

            // 다시 원래대로 연결
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
            for(int j=0;j<n+1;j++) visited[j] = false;
            cnt=0;
        }

        return answer;
    }

    public static int bfs(int h,int cnt){
            for(int i:graph[h]){
                if(!visited[i]){
                    visited[i]=true;
                    cnt = bfs(i,++cnt);
                }    
            
        }
        return cnt;
    }

    public static void main(String args[]) throws Exception {
        int n = 4;
        int[][] wires = {{1,2},{2,3},{3,4}};
        //int n = 9;
        //int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int answer = solution(n,wires);
        System.out.println("answer"+answer);
    }
}
