package programmers;

import java.util.HashMap;

public class Lv2_10 {
    // 모음사전
    // 20230607
    public static int solution(String word) {
        int answer = word.length(); // A만 있었을 때로 가정

        // 1. 각 알파벳에 숫자를 부여
        // A:0, E:1, I:2, O:3, U:4
        String[] words = word.split("");

        HashMap<String,Integer> hash = new HashMap<>();
        hash.put("A", 0);
        hash.put("E", 1);
        hash.put("I", 2);
        hash.put("O", 3);
        hash.put("U", 4);

        // 2. 규칙
        // 5번째 자리수가 바뀌기 위해서(1번째 뒤로)
        // 4번째 자리수가 바뀌기 위해서(6번째 뒤로)
        // 3번째 자리수가 바뀌기 위해서(31번째 뒤로)
        // 2번째 자리수가 바뀌기 위해서(156번재 뒤로)
        // 1번째 자리수가 바뀌기 위해서(781번째 뒤로)
        int[] jalisu = {781,156,31,6,1};
        for(int i=0;i<words.length;i++){
            answer+=hash.get(words[i])*jalisu[i];
        }
        return answer;
    }

    public static void main(String args[]) throws Exception {
        String word="AAAAE";
        //String word="AAAE";
        //String word="I";
        //String word="EIO";

        int answer = solution(word);
        System.out.println("answer"+answer);
    }
}
