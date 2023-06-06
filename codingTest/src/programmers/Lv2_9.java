package programmers;

import java.util.ArrayList;

public class Lv2_9 {
    // 전력망을 둘로 나누기
    // 20230606
    static ArrayList<Integer>[] graph; // arraylist에 배열 넣어주는 방법
    public static int solution(int n, int[][] wires) {
        int answer = 10000;

        // 1. 방향이 없는 그래프에 넣어주기
        // 그래프를 형성하는 방법: 인접행렬, 인접리스트(배열의 크기가 크면 사용)
        graph = new ArrayList[n+1]; // arraylist에 배열 넣어주는 방법
        for(int i=1;i<n+1;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(int i=0;i<wires.length;i++){
            graph[wires[i][0]].add(wires[i][1]);
        }

        // 2. 연결된 것을 끊어가면서 차이를 계산
        for(int i=0;i<wires.length;i++){
            graph[wires[i][0]].remove(Integer.valueOf(wires[i][1])); // index가 아닌 특정 value값을 삭제
            boolean[] visited = new boolean[n+1]; // 0은 언제나 false라는 것을 기억

            // 탐색
            for(int j=1;j<graph.length;j++){
                for(int h : graph[j]){
                    if(!visited[h]) visited[h] = true;
                }
            }

            // true인 노드끼리 연결, 0을 제외한 false인 노드끼리 연결되어있음.
            int result = 0;
            for(int j=1;j<visited.length;j++){
                if(visited[j]) result++;
            }

            // 3. min값을 계속해서 갱신해줌
            System.out.println("result"+result);
            System.out.println("an"+(n-result));
            int abs = Math.abs(result-(n-result));
            answer = Math.min(answer, abs);

            // 다시 원래대로 연결
            graph[wires[i][0]].add(wires[i][1]);
        }

        return answer;
    }

    public static void main(String args[]) throws Exception {
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        int answer = solution(n,wires);
        System.out.println("answer"+answer);
    }
}
