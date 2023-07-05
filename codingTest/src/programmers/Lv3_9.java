package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Lv3_9 {
    // 20230705
    // 단속카메라

    public static int solution(int[][] routes) {
        int answer = 0;

        // 1. 끝나는 지점 별로 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1]-o2[1];
            }
        });

        // 2. 카메라 위치를 바꿔줌
        int camera = Integer.MIN_VALUE;

        for(int[] i: routes){
            if(camera<i[0]){
                answer++;
                camera=i[1]; // 카메라 위치 바꿔줌(제일 끝지점에 놓아서 최소의 카메라 개수만 쓰게 함.)
            }
        }
        
        return answer;
    }
    public static void main(String args[]) throws Exception {
        int[][] routes = {{-20,-15},{-14,-5},{-18,-13},{-5,-3}};

        int answer = solution(routes);
        System.out.println("answer"+answer);
    }  
}
