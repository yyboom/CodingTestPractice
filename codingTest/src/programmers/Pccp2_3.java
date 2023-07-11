package programmers;

import java.util.ArrayList;

public class Pccp2_3 {
    // 20230712
    // Pccp 모의고사 2회 3번
    // 카페 확장
    public static int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        int time = 0;
        
        for(int i = 0; i < k*order.length; i++){
                        
            if(time<i) time=i;
            if(arr.size()!=0 && i==arr.get(0)){
                arr.remove(0);
            }
            
            if(i%k==0){
                time += menu[order[i/k]];
                arr.add(time);
            }

            answer=Math.max(answer,arr.size());

            
        }
        
        return answer;
    }
    public static void main(String args[]) throws Exception {
        int[] menu ={5,12,30};
        int[] order ={1,2,0,1};
        int k=10;

        // int[] menu = {5,12,30};
        // int[] order = {2,1,0,0,0,1,0};
        // int k =10;
        // int[] menu = {5};
        // int[] order = {0,0,0,0,0};
        // int k=5;

        System.out.println(solution(menu, order, k));

    }
}
