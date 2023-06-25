package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Lv3_4 {
    // 20230625
    // 이중우선순위큐
    static ArrayList<Integer> array;
    public static int[] solution(String[] operations) {
        int[] answer = {0,0};
        // 1. method별로 정의
        array = new ArrayList<>();
        for(int i=0;i<operations.length;i++){
            String[] s = operations[i].split(" ");
            if(s[0].equals("I")){
                operI(Integer.parseInt(s[1]));
            }else{
                if(s[1].equals("1")) operD1();
                else operD11();        
            }
        }

        // 3. 연산 후 size가 0이 아닐때만 answer을 최대 최소로 내보냄
        if(array.size()!=0){
            Collections.sort(array); // 오름차순
            answer[0] = array.get(array.size()-1);
            answer[1] = array.get(0);
        }
        return answer;
    }

    public static void operI(int s){
        //System.out.println("s"+s);
        array.add(s);
    }

    // 최대값 삭제
    public static void operD1(){
        Collections.sort(array); // 내림차순 정렬
        //System.out.println("D1"+array.get(array.size()-1));
        if(array.size() !=0)array.remove(array.size()-1);
    }

    // 최소값 삭제
    public static void operD11(){
        Collections.sort(array); // 오름차순 정렬
        //System.out.println("D11"+array.get(0));
        if(array.size() !=0)array.remove(0);
    }

    public static void main(String args[]) throws Exception {
        // String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
         String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] answer = solution(operations);
        for(int i:answer)System.out.printf(i+" ");
    }        
}