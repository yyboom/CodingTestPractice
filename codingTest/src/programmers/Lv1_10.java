package programmers;

public class Lv1_10 {
    // programmers lv1 옹알이(2) 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 3분 코드 작성: 44분
    // 20221231 21:50PM~22:37
    class Solution {
        //연속된 것을 return하기 위해서는 그자리에서 멈춰서 바로 return해줘야 하기 때문에 따로 함수를 빼주는 것이 좋음.
        private boolean continuity(String babble){
            for (int i = 0; i < babble.length()-1; i++) {
                if (babble.charAt(i) == babble.charAt(i + 1)) {
                    return false;
                }
            }
            return true;
        }

        public int solution(String[] babbling) {
            String[] keyword = {"aya", "ye", "woo", "ma"};
            int answer = 0;
    
            for (String babble : babbling) {
                for (int i = 0; i < keyword.length; i++) {
                    //특정 문자열을 내가 원하는 문자로 바꿔주는 것이 replaceAll임.
                    babble = babble.replaceAll(keyword[i], String.valueOf(i));
                }
    
                if (babble.matches("^[0-9]*$") && continuity(babble)) {
                    answer++;
                }
            }
             return answer;
        }
    }
}
