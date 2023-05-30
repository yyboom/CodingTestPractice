package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Lv2_3 {
    // 124나라의 숫자
    // 20230531
    static HashSet<Integer> hash;
    public static String solution(int n) {
        String answer = "";

        // 1. 받아온 정수를 나눌 수 있는 숫자로 바꾸기(재귀가 들어갈 것)
        String[] numarr = {"1","2","4"};
        String[] outnumarr = new String[numarr.length];

        hash = new HashSet<>();
        for(int i=0;i<numarr.length;i++){
            permutation(hash,numarr,outnumarr,0,i+1);
        }

        // 3. 해당 10진수의 124 수 찾기
        // set에는 순서가 없기 때문에 iterator을 통해서 가져와야함.
        String an = "";
        int c=1;
        ArrayList<Integer> list = new ArrayList<>(hash);
        Collections.sort(list);// 오름차순으로 hash정렬
        for(int key : list){
            an = String.valueOf(key);
            if(c==n){
                answer = an;
                break;
            }else{
                c++;
            }
        }
        
        return answer;
    }

    // 2. 재귀 함수(중복이 가능한 경우임)
    // 중복순열일때는 어디를 들렸다는 표시를 굳이 할 필요가 없기 때문에 visit여부를 체크하지 않음.
    // https://sskl660.tistory.com/49
    public static void permutation(HashSet<Integer> hash, String numarr[], String outnumarr[], int depth, int r){
        String answer="";
        // 최종 돌아야 하는 배열의 길이만큼 다 돌았을 때
        if(depth==r){
            for(int i=0;i<r;i++){
                answer += outnumarr[i];
            }
            String an = Integer.toString(Integer.parseInt(answer)); // 숫자 앞에 0 지워줌
            hash.add(Integer.parseInt(an));
            return;
        }

        // 배열의 길이만큼 도는 거
        for(int i=0;i<numarr.length;i++){
                outnumarr[depth]=numarr[i];
                permutation(hash,numarr, outnumarr, depth+1, r);
            }
    }

    public static void main(String args[]) throws Exception {
        int numbers = 15;

        String answer = solution(numbers);
        System.out.println("answer"+answer);
    }
}
