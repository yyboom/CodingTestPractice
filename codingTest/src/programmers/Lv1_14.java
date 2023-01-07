package programmers;
import java.util.*;
public class Lv1_14 {
    // programmers lv1 개인정보 수집 유효기간 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 12분 코드 작성: 52분
    // 20230107 17:26PM~18:30
    // String으로 바꾼 다음에 spilt할때 조심하기..그냥 arraylist쓰는게 좋을듯..
    class Solution {
        // 10미만일때 앞에 0붙여주는 함수
        public String zerochange(int a) {
            if (a < 10) {
                return "0" + String.valueOf(a);
            }
            return String.valueOf(a);
        }

        // 날짜를 바꿔주는 함수
        public String daychange(String today) {
            // 0. today날짜 split
            String[] today1 = today.split("[.]");
            String todaystring = today1[0] + today1[1] + today1[2];
            return todaystring;
        }

        // 날짜 계산해주는 함수
        public String daycal(String new1, String[] new3) {
            String newday = "";
            // 계약 년
            int a = Integer.parseInt(new3[0]);
            int b = Integer.parseInt(new3[1]);
            int c = Integer.parseInt(new3[2]);
            int d = Integer.parseInt(new1);

            a += d / 12;
            b += d % 12;

            if (b > 12) {
                a++;
                b = b % 12;
            }

            newday = zerochange(a) + zerochange(b) + zerochange(c);
            return newday;
        }

        public int[] solution(String today, String[] terms, String[] privacies) {

            // 0. today날짜 string으로
            String todaystring = daychange(today);

            // 1. 필요 정보만 저장(해지 날짜 계산까지 같이!)
            HashMap<Integer, String> privacieshashmap = new HashMap<Integer, String>();
            for (int i = 0; i < privacies.length; i++) {
                for (int k = 0; k < terms.length; k++) {

                    String[] new1 = terms[k].split(" ");
                    String[] new2 = privacies[i].split(" ");

                    if (!(new1[0].equals(new2[1]))) {
                        continue;
                    }
                    // 해지 날짜 계산
                    String[] new3 = new2[0].split("[.]");

                    String newday = daycal(new1[1], new3);

                    privacieshashmap.put(i, newday);
                }
            }

            // 3. today와 비교 후 answer에 넣음
            ArrayList<Integer> putin = new ArrayList<Integer>();
            for (int i = 0; i < privacieshashmap.size(); i++) {
                String p1 = privacieshashmap.get(i);
                if (Integer.parseInt(todaystring) >= Integer.parseInt(p1)) {
                    putin.add(i + 1);
                    continue;
                }

            }
            int[] answer = new int[putin.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] += putin.get(i);
            }

            return answer;
        }
    } 
}
