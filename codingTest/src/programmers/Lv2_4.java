package programmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
public class Lv2_4 {

    // 큰 수 만들기
    // 20230601
    static HashSet<Integer> hash;
    public static String solution(String number, int k) {
        String answer = "";

        // 1. 재귀함수
        String[] numarr = number.split("");
        String[] outnumarr = new String[numarr.length-k];
        boolean[] visited = new boolean[numarr.length];

        // 2. hash에 넣고
        hash = new HashSet<>();
        permutation(hash,numarr,outnumarr,visited,0,numarr.length-k);

        // 3. collection으로 오름차순 정렬
        // arraylist로 변환하여 정렬
        ArrayList<Integer> al = new ArrayList<>(hash);
        Collections.sort(al);

        // 4. 맨 뒤의 숫자 뽑기
        answer = Integer.toString(al.get(al.size()));

        return answer;
    }

    // 재귀함수
    public static void permutation(HashSet<Integer> hash, String numarr[], String outnumarr[], boolean[] visited, int depth, int r){
        String answer="";
        // 최종 돌아야 하는 배열의 길이만큼 다 돌았을 때
        if(depth==r){
            int c =0;
            for(int i=0;i<r;i++){
                answer += outnumarr[i];
            }
            int an = Integer.parseInt(answer); // 숫자 앞에 0 지워줌
            System.out.println("an"+an);
            hash.add(an);
            return;
        }

        // 배열의 길이만큼 도는 거
        for(int i=0;i<numarr.length;i++){
            if(!visited[i]){
                visited[i] = true;
                outnumarr[depth]=numarr[i];
                permutation(hash,numarr, outnumarr, visited, depth+1, r);
                visited[i]=false;
            }
        }
    }

    public static void main(String args[]) throws Exception {
        String numbers = "1924";
        int k = 2;

        String answer = solution(numbers,k);
        System.out.println("answer"+answer);
    }
}
