package programmers;

import java.util.Arrays;
import java.util.Collections;

public class Lv2_22 {
    // 20230704
    // 구명보트
    public static int solution(int[] people, int limit) {
        int answer = 0;
        // arraylist로 푼건 효율성이 안맞음.

        // // 0. arraylist에 넣어주기
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(int i:people) arr.add(i);

        // // 1. 내림차순 정렬
        // Collections.sort(arr,Collections.reverseOrder());

        // // 2. 몸집 제일 큰애랑 제일 작은애를 비교함. 데려갈 수 있으면 데려가고 없으면 큰애먼저 태워서 보냄.
        // while(arr.size()!=0){
        //     if(arr.size()!=1){
        //         if(arr.get(0)+arr.get(arr.size()-1)<=limit){
        //             arr.remove(arr.size()-1);
        //         }
        //     }
        //     answer++;
        //     arr.remove(0);
        // }

        // 배열로 들어온거 그대로 할 때
        // 1. 오름차순 정렬
        Arrays.sort(people);

        // 2. 비교
        int total=0;
        int i=0;
        int j=people.length-1;
        while(people.length!=total){
            if(people.length-total>1){
                if(people[i]+people[j]<=limit){
                    total++;
                    i++;
                }
            }
            answer++;
            total++;
            j--;
        }
        return answer;
    } 
    
    public static void main(String args[]) throws Exception {
        int[] people = {70,50,80,50};
        int limit = 100;

        // int[] people={70,80,50};
        // int limit = 100;

        int answer = solution(people, limit);
        System.out.println("answer"+answer);
    }
}
