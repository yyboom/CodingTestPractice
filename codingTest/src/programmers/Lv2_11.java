package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Lv2_11 {
    // H-Index
    // 20230609
    // 문제 설명 : index가 1부터 시작한다고 가정했을 때 index보다 인용횟수가 커지면 그전index를 반환하라는것
    public static int solution(int[] citations) {
        int answer = citations.length;

        // 1. 논문 인용 횟수를 오름차순으로 정렬
        ArrayList<Integer> arlist = new ArrayList<>();
        for(int t : citations){
            arlist.add(t);
        }
        Collections.sort(arlist);

        // 2. i와 citations[i]가 같을 때 break;
        for(int i=0;i<arlist.size();i++){
            if((i+1)>arlist.get(arlist.size()-1-i)){
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void main(String args[]) throws Exception {
        int[] citations = {100,100,100};
        int answer = solution(citations);
        System.out.println(answer);
    }
}
