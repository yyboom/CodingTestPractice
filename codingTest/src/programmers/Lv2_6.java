package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lv2_6 {
    // 모의고사
    // 20230603
    public int[] solution(int[] answers) {

        // 1. 규칙 찾기
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];

        for(int i=0;i<answers.length;i++){
            if(answers[i]==p1[i%5]) ++score[0];
            if(answers[i]==p2[i%8]) ++score[1];
            if(answers[i]==p3[i%10]) ++score[2];
        }

        // 2. max찾기
        List<Integer> list = new ArrayList<>();
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        // max랑 값이 같으면 arraylust에 추가함.
        if(max == score[0]) list.add(1);
        if(max == score[1]) list.add(2);
        if(max == score[2]) list.add(3);

        // 3. 배열안에 넣기
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        } 
        return answer;
    }
}
