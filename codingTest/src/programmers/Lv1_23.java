package programmers;

import java.util.HashMap;

public class Lv1_23 {
    // 완주하지 못한 선수
    // 20230611
    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        // 1. hashmap에 저장
        HashMap<String,Integer> hash = new HashMap<>(); // 이름, 동명이인수
        for(int i=0;i<participant.length;i++){
            if(hash.containsKey(participant[i])){
                int c = hash.get(participant[i]);
                hash.put(participant[i], ++c);
            }else{
                hash.put(participant[i], 1);
            }
        }

        // 2. completion된 선수들을 지워줌
        for(int i=0;i<completion.length;i++){
            int c = hash.get(completion[i]);
            hash.replace(completion[i], --c);
        }

        // 3. 완주하지 못한 선수 return
        for(String i : participant){
            System.out.println(hash.get(i));
            if(hash.get(i)!=0) answer = i;
        }
        
        return answer;
    }

    public static void main(String args[]) throws Exception {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion ={"josipa", "filipa", "marina", "nikola"};

        String answer = solution(participant, completion);
        System.out.println(answer);
    }
}