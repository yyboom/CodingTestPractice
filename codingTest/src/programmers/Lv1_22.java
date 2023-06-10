package programmers;

import java.util.HashSet;

public class Lv1_22 {
    // 20230610
    // 폰켓몬
    public static int solution(int[] nums) {
        int answer = 0;

        // 1. 폰켓몬의 종류 구하기(중복 제거)
        int pick = nums.length/2;
        HashSet<Integer> hash = new HashSet<>();
        for(int i:nums) hash.add(i);

        // 2. 가져갈 수 있는 폰켓몬의 수 비교
        if(pick>=hash.size()) answer = hash.size();
        else answer = pick;
        
        return answer;
    }
}
