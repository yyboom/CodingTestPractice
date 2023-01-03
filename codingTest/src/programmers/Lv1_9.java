package programmers;

import java.util.Arrays;

public class Lv1_9 {
    // programmers lv1 성격 유형 검사하기 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 5분 코드 작성:33분
    // 20230103 17:22PM~18:00
    class Solution {

        public int checking(String a, int b){
            int count =0;
            if(a.equals("R")||a.equals("C")||a.equals("J")||a.equals("A")){
                if(b>4){
                    count = b-4;
                }else if(b<4){
                    count = -b+4;
                }else{
                    count =0;
                }
            }else{
                if(b>4){
                    count = -(b-4);
                }else if(b<4){
                    count = b-4;
                }else{
                    count =0;
                }
            }
            return count;
        }

        public String solution(String[] survey, int[] choices) {
            String answer = "";

            String[] count1 = new String[survey.length];

            int num1 = 0;
            int num2 = 0;
            int num3 = 0;
            int num4 = 0;

            for (int i = 0; i < survey.length; i++) {
                String[] split1 = survey[i].split("");

                if (choices[i] > 4) {
                    count1[i] = split1[1];
                    int a1 = checking(count1[i], choices[i]);
                    if(count1[i].equals("R")||count1[i].equals("T")){
                        num1 += a1;
                    }
                    if(count1[i].equals("C")||count1[i].equals("F")){
                        num2 += a1;
                    }
                    if(count1[i].equals("J")||count1[i].equals("M")){
                        num3 += a1;
                    }
                    if(count1[i].equals("A")||count1[i].equals("N")){
                        num4 += a1;
                    }
                } else if (choices[i] < 4) {
                    count1[i] = split1[0];
                    int a1 = checking(count1[i], choices[i]);
                    if(count1[i].equals("R")||count1[i].equals("T")){
                        num1 += a1;
                    }
                    if(count1[i].equals("C")||count1[i].equals("F")){
                        num2 += a1;
                    }
                    if(count1[i].equals("J")||count1[i].equals("M")){
                        num3 += a1;
                    }
                    if(count1[i].equals("A")||count1[i].equals("N")){
                        num4 += a1;
                    }
                } else {
                    Arrays.sort(split1);
                    count1[i] = split1[0];
                    int a1 = checking(count1[i], choices[i]);
                    if(count1[i].equals("R")||count1[i].equals("T")){
                        num1 += a1;
                    }
                    if(count1[i].equals("C")||count1[i].equals("F")){
                        num2 += a1;
                    }
                    if(count1[i].equals("J")||count1[i].equals("M")){
                        num3 += a1;
                    }
                    if(count1[i].equals("A")||count1[i].equals("N")){
                        num4 += a1;
                    }
                }
            }

            if(num1>0){
                answer += "R";
            }else if(num1<0){
                answer += "T";
            }else{
                answer += "R";
            }

            if(num2>0){
                answer += "C";
            }else if(num2<0){
                answer += "F";
            }else{
                answer += "C";
            }

            if(num3>0){
                answer += "J";
            }else if(num3<0){
                answer += "M";
            }else{
                answer += "J";
            }

            if(num4>0){
                answer += "A";
            }else if(num4<0){
                answer += "N";
            }else{
                answer += "A";
            }

            return answer;
        }
    }    
}
