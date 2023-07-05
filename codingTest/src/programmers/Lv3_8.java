package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lv3_8 {
    // 20230705
    // 섬 연결하기

    public static int findParent(int[] parent, int node){
        if(parent[node]==node) return node;
        return findParent(parent,parent[node]);
    }

    public static void union(int[] parent, int node1, int node2){
        int p1 = findParent(parent, node1);
        int p2 =findParent(parent, node2);

        if(p1<p2) parent[p2]=p1;
        else parent[p1]=p2;
    }
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        // 크루스칼 알고리즘으로 엄청 쉽게 풀 수 있음.
        // cost가 낮은 순서대로 정렬 후 노드의 부모가 다를때만 다리를 건설함!
        for(int i=0;i<parent.length;i++) parent[i]=i;

        // 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[2]-o2[2];
            }
        });

        for(int i=0;i<costs.length;i++){
            if(findParent(parent, costs[i][0])!=findParent(parent, costs[i][1])){ // parent여부 같은지 판별 과정
                answer+=costs[i][2];
                union(parent, costs[i][0], costs[i][1]);
            }
        }

        return answer;
    }
    public static void main(String args[]) throws Exception {
        // int n = 4;
        // int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};

        int n=5;
        int[][] costs = {{0,1,5},{1,2,3},{2,3,3},{3,1,2},{3,0,4},{2,4,6},{4,0,7}};

        int answer = solution(n,costs);
        System.out.println("answer"+answer);
    }    
}
