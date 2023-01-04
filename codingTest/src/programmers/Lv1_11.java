package programmers;
import java.util.*;
public class Lv1_11 {
    // programmers lv1 헴버거 만들기 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 3분 코드 작성: 56분
    // 20230104 17:31PM~18:30
    // 이문제는 문자열로는 제약사항까지 문제를 해결할 수 없음. arraylist로 문자열을 분리해서 넣어보려 했지만 시간이 초과되었었음.
    // 따라서 stack으로 넣어줘야함!
    // https://survive20.tistory.com/17 참고
    class Solution {
        public int solution(int[] ingredient) {
            int answer = 0;
            Stack dulogam = new Stack();
            for (int i : ingredient) {
                if (i == 1 && dulogam.size() >= 3 && dulogam.lastIndexOf(3) == dulogam.size() - 1
                        && dulogam.lastIndexOf(2) == dulogam.size() - 2 && dulogam.lastIndexOf(1) == dulogam.size() - 3) {
                    answer++;
                    dulogam.pop();
                    dulogam.pop();
                    dulogam.pop();
                } else {
                    dulogam.add(i);
                }
            }
            return answer; 
        }
    }  
}
