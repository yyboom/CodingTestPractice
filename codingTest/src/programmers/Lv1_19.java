package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1_19 {
    // 둘만의 암호
    // 20230528
    public static String solution(String s, String skip, int index) {
        String answer = "";
        String[] al = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
                "s", "t", "u", "v", "w", "x", "y", "z" };
        ArrayList<String> alphabet = new ArrayList<>(Arrays.asList(al));
        String[] skiplist = skip.split("");

        // 1. skip에 없는 알파벳들 넣어주기
            for (int i = 0; i < skiplist.length; i++) {
                for (int j = 0; j < alphabet.size(); j++) {
                if (skiplist[i].equals(alphabet.get(j))) {
                    alphabet.remove(j);
                }
            }
        }

        // 2. 원하는 문자로 만들어주기
        String[] slist = s.split("");
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < alphabet.size(); j++) {
                if (slist[i].equals(alphabet.get(j))) {
                        answer += alphabet.get((j + index) % alphabet.size());
                        break;
                }
            }
        }

        return answer;
    }
}
