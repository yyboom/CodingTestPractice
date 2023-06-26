package programmers;
public class Lv3_2 {
    // 20230626
    // 네트워크
    static boolean[] visited;
    static int[][] graph;
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        // 1. dfs롷 노드 탐색
        graph = computers;
        visited = new boolean[n];
        for(int i=0;i<computers.length;i++){
            if(!visited[i]){
                dfs(i,n);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int node, int length){
        visited[node] = true;
        for(int i=0;i<length;i++){
            if(!visited[i] && (graph[node][i]==1)){
                dfs(i,length);
            }
        }

    }
    public static void main(String args[]) throws Exception {
        // int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
         int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
        int n =3;
        int answer = solution(n,computers);
        System.out.println(answer);
    }
}
