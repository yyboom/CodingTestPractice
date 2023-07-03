package programmers;
public class Lv3_7 {
    // 20230703
    // N으로 표현
    // https://easybrother0103.tistory.com/132 참고
    static int min = Integer.MAX_VALUE;
    public static int solution(int N, int number) {
        int answer = -1;
        // 1. dfs로 N의 값을 얼마나 적게 썼는지 찾음
        dfs(0,N,number,0);

        if(min!=Integer.MAX_VALUE) answer=min;

        return answer;
    }
    public static void dfs(int depth, int N, int number, int curnum){
        // depth이 8보다 크면 -1
        if(depth>8) return;

        // 같은 숫자가 되었을 때 최솟값만 반환
        if(number==curnum){
            min=Math.min(min, depth);
            return;
        }

        int temp = 0; // for문이 돌아가는 횟수에 따라서 원래 숫자에 더해줘야 하는 애들이 달라짐.
        for(int i=0;i<8;i++){
            if(depth+i<8){ // 최종 depth가 8이 아닐때만 수행
                temp = temp*10+N;
                dfs(depth+i+1, N, number, curnum+temp);
                dfs(depth+i+1, N, number, curnum-temp);
                dfs(depth+i+1, N, number, curnum*temp);
                dfs(depth+i+1, N, number, curnum/temp);
            }
        }

    }
    public static void main(String args[]) throws Exception {

        int N = 5;
        int number = 12;

        // int N=2;
        // int number=11;

        int answer = solution(N,number);
        System.out.println(answer);

    }
}
