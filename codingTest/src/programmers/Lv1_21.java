package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv1_21 {
    //k번째수
    //20230608
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int h=0;h<commands.length;h++){
            int i = commands[h][0];
            int j = commands[h][1];
            int k = commands[h][2];

            // 1. 각 commans에서 i-1부터 j-1까지 뽑은 후
            int[] arr = Arrays.copyOfRange(array, i-1, j); // 배열에서 특정 인덱스 범위만큼 자르기

            // 2. 오름차순 정렬
            // primitive type인 경우 아래와 같이 배열을 arraylist로 변경할 수 없음. https://dev-j.tistory.com/16
            // ArrayList<Integer> arlist = new ArrayList<>(arr);
            ArrayList<Integer> arlist = new ArrayList<>();
            for(int t : arr){
                arlist.add(t);
            }
            Collections.sort(arlist);

            // 3. k-1 숫자 찾기
            answer[h] = arlist.get(k-1);
        }
        
        return answer;
    }
    
    public static void main(String args[]) throws Exception {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        int[] answer = solution(array,commands);
        for(int i=0;i<answer.length;i++){
            System.out.printf(answer[i]+" ");
        }
    }
}
