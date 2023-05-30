package programmers;

import java.util.HashSet;

public class Lv2_2 {
    // 소수 찾기
    // 20230530
    static HashSet<String> hash;
    public static int solution(String numbers) {
        int answer = 0;
        // 1.중복을 써서 순열 조합을 만들어줌
        String[] numarr = numbers.split("");
        String[] outnumarr = new String[numarr.length];
        boolean[] visited = new boolean[numarr.length];

        hash = new HashSet<>();
        for(int i=0;i<numarr.length;i++){
            permutation(hash,numarr,outnumarr,visited,0,i+1);
        }

        // 3. 소수찾기
        for(String key:hash){
            System.out.println("3");
            System.out.println(key);
            int oneorzero = isPrime(Integer.parseInt(key));
            if(oneorzero==1){ // 소수라는 의미
                answer++;
            }
        }

        return answer;
    }

    // 2. 재귀 함수
    // https://gyuwon95.tistory.com/136
    public static void permutation(HashSet<String> hash, String numarr[], String outnumarr[], boolean[] visited, int depth, int r){
        String answer="";
        // 최종 돌아야 하는 배열의 길이만큼 다 돌았을 때
        if(depth==r){
            for(int i=0;i<r;i++){
                if(i==0&&Integer.parseInt(outnumarr[i])==0 && r>1) continue;
                else{answer+=outnumarr[i];}
            }
            hash.add(answer);
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

    // 3. 소수 판별
    public static int isPrime(int n){
        System.out.println("3/1");
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return 0;
        }
        return 1;
    }

    
    public static void main(String args[]) throws Exception {
        String numbers = "011";

        int answer = solution(numbers);
        System.out.println("answer"+answer);
    }
}
