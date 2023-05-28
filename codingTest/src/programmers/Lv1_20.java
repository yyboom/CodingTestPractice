package programmers;

import java.util.HashMap;

public class Lv1_20 {
    // 대충 만든 자판
    // 20230529
    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<String, Integer> hash = new HashMap<>();

        // 1. 각 문자열이 나오기 위해 눌러야 하는 버튼의 횟수중 작은거로 저장
        for (int i = 0; i < keymap.length; i++) {
            String[] key = keymap[i].split("");
            for (int j = 0; j < key.length; j++) {
                if(hash.containsKey(key[j])){// 해당 키를 이미 보유하고 있다면
                        hash.put(key[j], Math.min(hash.get(key[j]), j+1));
                    
                }else{
                    hash.put(key[j], j+1);         
                }
            }
        }
        // 2. target이 나오기 위한 버튼 횟수 세기
        for(int i=0;i<targets.length;i++){
            String[] target = targets[i].split("");
            int num = 0;

            for(int j=0;j<target.length;j++){
                if(hash.containsKey(target[j])){
                    num+=hash.get(target[j]);
                }else{
                    num=-1;
                    break;
                }
            }

            answer[i]=num;

        }
        return answer;
    }

    public static void main(String args[]) throws Exception {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};

        int[] result = solution(keymap, targets);

        System.out.println(result[0]+","+result[1]);
    }
}
