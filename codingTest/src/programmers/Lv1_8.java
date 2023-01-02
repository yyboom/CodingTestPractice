package programmers;

public class Lv1_8 {
    // programmers lv1 문자열 나누기 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 5분 코드 작성:24분
    // 20230102 23:13PM~23:42
    class Solution {
        public int solution(String s) {
            int answer = 0;

            int count1 = 1;
            int count2 = 0;

            String[] sp = s.split("");
            //String을 쓰는거보다 char를 쓰는것이 더 편한것 같음!
            char al = s.charAt(0);
    
            for (int i = 1; i < sp.length; i++) {
                if (al == ' ') {
                    //초기화 후 다시 문자를 넣어주어야 함
                    al = sp[i].charAt(0);
                    //넣고 난 다음 i를 향해 가야하기에 continue를 써줘야함. 이거때문에 시간 약간 버림..
                    continue;
                }

                //처음 받은 문자랑 같을때랑 아닐때
                if (al == sp[i].charAt(0)) {
                    count1++;
                }else{
                    count2++;
                }

                //다 끝났을 때 다시 초기화해야함.
                if (count1 == count2) {
                    answer++;
                    count1 = 1;
                    count2 = 0;
                    al = ' ';
                }
            }

            //문자가 더 남아있을 때
            if (al != ' ') {
                answer++;
            }
    
            return answer;
        }
    }    
}
