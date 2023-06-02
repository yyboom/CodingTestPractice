package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Lv2_5 {
    // 완점탐색 연습 1
    // 최소직사각형
    // 20230602
    public int solution(int[][] sizes) {
        int answer = 0;

        // 0. [0]에는 작은 값을, [1]에는 큰 값이 들어가도록 바꿔줌
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0]>sizes[i][1]){
                int c = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = c;
            }
        }

        // 1. 가로 세로 중 작은 길이를 hashset에 넣어줌
        HashSet<Integer> wHash = new HashSet<>();
        for(int i=0;i<sizes.length;i++){
            wHash.add(sizes[i][0]);
        }

        // hashset을 arraylist에 넣고 오름차순 정렬
        ArrayList<Integer> w = new ArrayList<>(wHash);
        Collections.sort(w);

        // 작은 길이 중에서의 최대 값
        int wMax = w.get(w.size()-1);

        // 2. 가로 세로 중 큰 길이를 hashset에 넣어줌
        HashSet<Integer> hHash = new HashSet<>();
        for(int i=0;i<sizes.length;i++){
            hHash.add(sizes[i][1]);
        }

        // hashset을 arraylist에 넣고 오름차순 정렬
        ArrayList<Integer> h = new ArrayList<>(hHash);
        Collections.sort(h);

        // 큰 길이 중에서의 최대 세로 값
        int hMax = h.get(h.size()-1);

        // 3. 최대값 두개를 곱해줌
        answer = wMax*hMax;
        
        return answer;
    }
}
