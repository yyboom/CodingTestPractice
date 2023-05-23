package programmers;

import programmers.Lv1_12.Solution;

public class Lv1_15 {
    // 가장 가까운 같은 글자
    // 20230523
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        // 1. 알파벳 배열 생성(default -1)
        int[] alphabet = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }

        // 2. 비교 후 넣기
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < alphabet.length; i++) {
                // 알파벳이 같을 때(a부터가 0임 소문자 a:97)
                if((int)s.charAt(j)-97==i){
                    // 앞에 같은 알파벳이 없었을 때
                    if(alphabet[i]==-1){
                        answer[j]=-1;
                        alphabet[i]=j;
                    }else{
                        answer[j]=j-alphabet[i];
                        alphabet[i]=j;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
