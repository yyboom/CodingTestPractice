package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Lv1_17 {
    // 바탕화면 정리
    // 20230525
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        // 1. y축에서 제일 작은 거, 제일 큰 거 찾기
        ArrayList<Integer> y = new ArrayList<>();
        for(int i=0;i<wallpaper.length;i++){
            String sen = wallpaper[i];
            for(int j=0;j<sen.length();j++){
                if(sen.charAt(j)=='#'){
                    y.add(i);
                }
            }
        }

        int miny = Collections.min(y);
        int maxy = Collections.max(y);

        answer[0]=miny;
        answer[2]=maxy+1;
        
        // 2. x축에서 제일 작은 거, 제일 큰 거 찾기
        ArrayList<Integer> x = new ArrayList<>();
        for(int i=0;i<wallpaper.length;i++){
            String sen = wallpaper[i];
            for(int j=0;j<sen.length();j++){
                if(sen.charAt(j)=='#'){
                    x.add(j);
                }
            }
        }

        int minx = Collections.min(x);
        int maxx = Collections.max(x);

        answer[1]=minx;
        answer[3]=maxx+1;

        return answer;
    }
}
