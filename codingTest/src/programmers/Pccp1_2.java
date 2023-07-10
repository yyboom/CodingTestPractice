package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Pccp1_2 {
    // 20230710
    // Pccp 모의고사 1회 2번
    // 체육대회

    static boolean[] bool;
    static int answer;
    public static int solution(int[][] ability) {
        answer = 0;
        bool=new boolean[ability.length];
        dfs(ability,0,0);
        return answer;
    }
    public static void dfs(int[][] ability,int type,int total){
        if(type==ability[0].length){
            answer=Math.max(answer,total);
            return;
        }
            for(int j=0;j<ability.length;j++){
                if(!bool[j]){
                    bool[j]=true;
                    dfs(ability, type+1, total+ability[j][type]);
                    bool[j]=false;
                }
            }
        
    }

    public static void main(String args[]) throws Exception {
        int[][] ability = {{40,10,10},{20,5,0},{30,30,30},{70,0,70},{100,100,100}};
        //int[][] ability = {{20,30},{30,20},{20,30}};
        System.out.println(solution(ability));
    } 
}
