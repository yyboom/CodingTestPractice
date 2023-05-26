package programmers;

import java.util.HashMap;
import java.util.Map;

public class LV1_18 {
    // 달리기 경주
    // 20230526
    public String[] solution(String[] players, String[] callings) {

        // 1. hashmap에 넣어주기
        HashMap<String, Integer> score = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            score.put(players[i], i);
        }

        // 2. hashmap을 이용해서 순서 바꿔줌.
        for (int i = 0; i < callings.length; i++) {
            String name = callings[i]; // 추월한 사람
            int chuwal = score.get(name); // 추월한 사람의 원래 순서
            int dchuwal = chuwal - 1; // 추월당한 사람의 원래 순서
            String name1 = players[dchuwal]; // 추월당한 사람(player에서 찾아도 됨)

            score.replace(name, dchuwal);
            score.replace(name1, chuwal);

            players[dchuwal]=name;
            players[chuwal]=name1;
        }
        return players;
    }
}
