package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Lv2_13 {
    // 20230613
    // 의상
    public static int solution(String[][] clothes) {
        int answer = 1;
        
        // 1. 같은 종류의 의상 세주기
        HashMap<String,Integer> hash = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            // 이미 보유하고 있는 종류일때
            if(hash.containsKey(clothes[i][1])){
                int c = hash.get(clothes[i][1]);
                hash.put(clothes[i][1], ++c);
            }else{
                hash.put(clothes[i][1], 2); // 아무것도 안들어갔을 경우 포함
            }
        }

        // 2. 오름차순 정렬 후
        ArrayList<Integer> array = new ArrayList<>();
        for(String i:hash.keySet()){
            int c = hash.get(i);
            array.add(c);
        }
        Collections.sort(array);

        // 3. 경우의 수 계산
        for(int i=0;i<array.size();i++){
            answer *= array.get(i);
        }
        answer--;// 전체 다 아무것도 안들어갔을 경우 포함


        return answer;
    }
    public static void main(String args[]) throws Exception {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        //String[][] clothes = {"123","456","789"};
        //String[][] clothes = {"12","123","1235","567","88"};
        int answer = solution(clothes);
        System.out.println(answer);
    }
}
