package programmers;
import java.util.*;
public class Lv1_12 {
    // programmers lv1 신고 결과 받기 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 10분 코드 작성: 134분
    // 20230105 19:26PM~21:50
    // 이제 for문을 적게 쓰려는 노력을 해야겠음. 모든 문자열을 다 for문으로만 받으려하니 시간초과가 너무 많이 걸림
    // goggling결과 hashmap을 이용한 풀이가 나옴. 중복을 바로 찾을 수 있고 신고자, 신고하는 자에 대한 count와
    // srraylist를 한방에 넣을 수 있으므로 시간초과문제를 해결할 수 있었음
    // 자바 뒤쪽에 배웠던거 다시 강의를 들어야겠다. 멀캠에서 뒤쪽은 대충나가서 기억이 사라짐.
    // https://coding-grandpa.tistory.com/106
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];

            // 1. report에서 모양 같은거 다 지움(report에서 한 유저가 같은 유저를 여러번 신고할 수 없기 때문)=>Hashset
            HashSet<String> reporthash = new HashSet<String>();
            for (String i : report) {
                reporthash.add(i);
            }

            // 2. 유저의 신고 당한 횟수=>counthash
            HashMap<String, ArrayList<String>> reporthashmap = new HashMap<String, ArrayList<String>>();
            for (String i : reporthash) {
                String[] new1 = i.split(" ");
                // 신고 당한 사람:key, 신고를 한 사람: arraylist로!
                ArrayList<String> new10list = reporthashmap.getOrDefault(new1[1], null);
                if (new10list == null) {
                    new10list = new ArrayList<>();
                }
                new10list.add(new1[0]);
                reporthashmap.put(new1[1], new10list);

            }

            // 3. 신고당한 횟수가 k번 넘지 않는 report를 지워줌.
            HashMap<String, Integer> new10hash = new HashMap<String, Integer>();
            // arraylist의 길이가 k이상이면 arraylist안에 있는 사람들에게 메일을 발송해주면 되는 것
            for (ArrayList<String> i : reporthashmap.values()) {
                if (i.size() >= k) {
                    for (String j : i) {
                        new10hash.put(j, new10hash.getOrDefault(j, 0) + 1);
                    }
                }
                // 4. 메일 몇번 받는지 최종 return
                for (int h = 0; h < id_list.length; h++) {

                    answer[h] = new10hash.getOrDefault(id_list[h], 0);

                }
            }

            return answer;
        }
    }   
}
