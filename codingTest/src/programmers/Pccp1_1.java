package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Pccp1_1 {
    // 20230709
    // pccp 모의고사 1회 1번
    // 외톨이 알파벳
    public static String solution(String input_string) {
        String answer = "";
        HashSet<String> arr = new HashSet<>();
        int[] narr = new int[123];

        // 1. 해당 소문자가 나오면 뒤에 string이랑 같은지 비교
        narr[input_string.charAt(0)]++;

        for(int i=1;i<input_string.length();i++){
            // 뒤에 단어가 다를 때
            if(input_string.charAt(i-1)!=input_string.charAt(i)){
                if(narr[input_string.charAt(i)]==0) narr[input_string.charAt(i)]++;
                else{
                    arr.add(String.valueOf(input_string.charAt(i)));
                }
            }
        }

        // 2. 오름차순 정렬
        ArrayList<String> arr1 = new ArrayList<>(arr);
        Collections.sort(arr1);

        for(String i:arr1) answer+=i; 

        // 3. 외톨이 알파벳이 없을 때
        if(answer.length()==0) answer="N";

        return answer;
    }
    public static void main(String args[]) throws Exception {
        String input_string = "edeaaabbccd";
        // String input_string = "eeddee";
        // String input_string = "string";
        // String input_string = "zbzbz";

        String answer = solution(input_string);
        System.out.println(answer);
    } 
}
