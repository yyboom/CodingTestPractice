package programmers;

import java.util.HashMap;
import java.util.Map;

public class LV1_18 {
    // 달리기 경주
    // 20230526
    public String[] solution(String[] players, String[] callings) {
        //String[] answer = new String[players.length];

        // 1. hashmap에 넣어주기
        HashMap<String, Integer> score = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            score.put(players[i], i);
        }

        // 2. hashmap을 이용해서 순서 바꿔줌.
        for (int i = 0; i < callings.length; i++) {
            String name = callings[i]; // 추월한 사람
            int chuwal = score.get(name); // 추월한 사람의 원래 순서
            int dchuwal = chuwal - 1;
            String name1 = getKey(score, dchuwal); // 추월당한 사람

            score.replace(name, dchuwal);
            score.replace(name1, chuwal);

            players[dchuwal]=name;
            players[chuwal]=name1;
        }

        // 3. answer에 넣어주기
        // for (int i = 0; i < players.length; i++) {
        //     String name = getKey(score, i);
        //     answer[i] = name;
        // }
        return players;
    }

    // hashmap에 value 로 key 찾기
    public <K, V> K getKey(Map<K, V> map, V value) {

        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }
}
