package programmers;

public class Lv2_8 {
    // 피로도
    // 20230605
    boolean[] visited;
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        // 최소 피로도랑 소모 피로도 둘중 어느쪽을 기준으로 잡고 찾을 수 없음. => 완전 탐색이 필요
        // dfs사용
        visited = new boolean[dungeons.length];
        for(int i=0;i<dungeons.length;i++){
            if(k>=dungeons[i][0]){
                dfs(i,k,1,dungeons);
            }
        }        
        return answer;
    }

    // dfs
    public void dfs(int cur, int kt, int depth, int[][] dungeons){
        visited[cur]=true;
        kt -= dungeons[cur][1]; // 소모한 피로도 빼주기
        for(int i=0;i<dungeons.length;i++){
            if(!visited[i] && dungeons[i][0] <= kt){
                dfs(i, kt, depth+1, dungeons); // 피로도가 남아있다면 다시 돌아감.
            }
        }
        answer = Math.max(answer, depth); // 큰 번수 찾기
        visited[cur] = false;
    }
}
