package programmers;

import java.util.Stack;

public class Pccp1_3 {
    // 20230710
    // Pccp 모의고사 1회 3번
    // 유전법칙
    public static String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];
        // 1. 4의 n승 -1
        for(int i=0;i<queries.length;i++){
            int n = queries[i][0];
            int p = queries[i][1]-1;
            String result = "Rr";
            Stack<Integer> stack = new Stack<>();
            for(int j=0;j<n-1;j++){
                int c = p%4;
                stack.add(c);
                p=p/4;
            }
            for(int j=0;j<n-1;j++){
                int c = stack.pop();
                if(result.equals("Rr")){
                    if(c==0) result="RR";
                    if(c==1||c==2) result="Rr";
                    if(c==3) result="rr";
                }
            }
            answer[i]=result;
        }
        return answer;
    }
}
