package programmers;

public class Lv1_3 {
    // programmers lv1 크레인 인형뽑기 게임 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 7분 코드 작성: 28분
    // 20221224 21:00PM~21:35PM
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            int d =0;

            // 인형 넣어둘 곳
            int[] doll = new int[moves.length];

            //인형 넣기
            for (int k = 0; k < moves.length; k++) {
                int a = moves[k]-1;
                for (int i = 0; i < board.length; i++) {
                    if (board[i][a] != 0) {
                        if(d>0 && doll[d-1]==board[i][a]){
                            answer=answer+2;
                            doll[d-1]=0;
                            d=d-1;
                        }else{
                            doll[d]=board[i][a];
                            d=d+1;
                        }
                        board[i][a]=0;
                        //다시 k로 돌아가야 함!더이상 i에 대한 for문을 돌릴 이유가 없음.
                        //다써놓고 여기서 15분을 씀...다시 돌릴때는 k=k+1말고 break를 쓰자
                        break;
                    }
                }
            }
            return answer;
        }
    }
}
