package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Lv3_5 {
    // 20230627
    // 게임 맵 최단거리
    static int[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    
    public static int solution(int[][] maps) {
        int answer = 0;
        // 1. dfs로 map탐색
        visited = new int[maps.length][maps[0].length];
        bfs(maps,visited);
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer == 0){
            answer = -1;
        }
        
        // dfs(0,0,1); // 시간이 길어짐

        return answer;
    }

    // public static void dfs(int x, int y, int distance){
    //     if(x==graph[0].length-1 && y==graph.length-1){ // 끝지점에 도달했다는 뜻
    //         if(answer == -1) answer = distance;
    //         else answer = answer>distance ? distance : answer;
    //     }
    //         for(int i=0;i<4;i++){
    //             int ddx = x+dx[i]; // 앞으로 걸어갈 지점의 x위치
    //             int ddy = y+dy[i]; // 앞으로 걸어갈 지점의 y위치

    //             if(ddx>=0 && ddx<graph[i].length && ddy>=0 && ddy<graph.length){ // map의 크기를 넣어가지 않을 때
    //                 if(!visited[ddx][ddy] && graph[ddx][ddy] == 1){ // 아직 안들린 곳인데 지나갈 수 있을 때
    //                     visited[ddx][ddy] = true;
    //                     dfs(ddx, ddy, distance+1);
    //                     visited[ddx][ddy]=false; // 최단거리를 구하기 위해 방문했던 것들 다시 바꿔줌
    //                 }
    //             }
    //     }
    // }

    public static void bfs(int[][]maps, int[][]visited){
        int x=0;
        int y=0;
        visited[x][y]=1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y}); // x,y값의 좌표 정보를 넣어줌

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int xx = curr[0];
            int yy = curr[1];
            
            for(int i=0;i<4;i++){
                int ddx = xx+dx[i]; // 앞으로 걸어갈 지점의 x위치
                int ddy = yy+dy[i]; // 앞으로 걸어갈 지점의 y위치

                // 지금까지 온 거리를 바로 더해줌
                if(ddx>=0 && ddx<maps.length && ddy>=0 && ddy<maps[0].length){
                    if(visited[ddx][ddy]==0 && maps[ddx][ddy]==1){ // 안가본 곳일 때
                        queue.add(new int[]{ddx,ddy});
                        visited[ddx][ddy] = visited[xx][yy]+1;
                    }
                }
            }
        }
    }

    public static void main(String args[]) throws Exception {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        //int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        int answer = solution(maps);
        System.out.println(answer);
    }
}
