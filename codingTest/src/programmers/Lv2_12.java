package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lv2_12 {
    // 전화번호 목록
    // 20230612
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        // 1. 문자열 정렬
        ArrayList<String> phone = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(phone); // 오름차순 정렬

        // 2. 바로 뒤에 있는 문자열과 비교
        for(int i=0;i<phone.size()-1;i++){
            String str = phone.get(i);
            String str1 = phone.get(i+1);
            if(str1.length()>str.length()){
                if(str1.substring(0, str.length()).equals(str)){ // 접두어가 같아야 함.
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String args[]) throws Exception {
        String[] phone_book = {"119", "97674223", "1195524421"};
        //String[] phone_book = {"123","456","789"};
        //String[] phone_book = {"12","123","1235","567","88"};
        boolean answer = solution(phone_book);
        System.out.println(answer);
    }
}
