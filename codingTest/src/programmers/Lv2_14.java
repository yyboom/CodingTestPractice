package programmers;
public class Lv2_14 {
    // 20230614
    // 타겟 넘버
    static int answer;

    public static int solution(int[] numbers, int target) {
        answer = 0;
        // DFS사용
        dfs(numbers,target,0,0); // 초기값
        return answer;
    }

    public static void dfs(int[] numbers, int target, int depth, int sum){
        // 전부다 탐색했을 때
        if(depth==numbers.length){
            if(target==sum){ // target값이 같을 때만 answer의 값 올려줌
                answer++;
            }
        }else{
            // dfs로 탐색
            dfs(numbers,target,depth+1,sum+numbers[depth]); // 앞에 sum과 더해주는 경우
            dfs(numbers,target,depth+1,sum-numbers[depth]); // 앞에 sum과 빼주는 경우
    
        }
    }

    public static void main(String args[]) throws Exception {
        int[] numbers = {1,1,1,1,1,};
        int target = 3;
        //int[] numbers = {4,1,2,1};
        //int target = 4;
        int answer = solution(numbers,target);
        System.out.println(answer);
    }
}
