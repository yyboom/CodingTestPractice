package programmers;
import java.util.ArrayList;
import java.util.Collections;
public class Lv2_4 {

    // 큰 수 만들기
    // 20230704

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(); // 시간을 줄이기 위함

        // 1. 받아온 number값을 나눠서 배열에 넣어줌.

        int index = 0;
        // 3. 최종 answer의 길이와 같고 거기서 제일 큰 수 를 골라서 뒤를 return 제일 max인 값을 골라서 그뒤를 전부 return
        for(int i=0;i<number.length()-k;i++){
            int max = 0;
            for(int j=index;j<i+k+1;j++){
                if(max<number.charAt(j)-'0'){
                    max=number.charAt(j)-'0';
                    index = j+1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
    public static void main(String args[]) throws Exception {
        String numbers = "1924";
        int k = 2;

        String answer = solution(numbers,k);
        System.out.println("answer"+answer);
    }
}
