package programmers;
public class Lv0_4 {
    // programmers lv0 겹치는 안전지대 문제 정답
	// 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 9분 코드 작성: 31분
	// 20221220 15:53PM~16:33PM
    class Solution {
        //위험지대까지 포함한 좌표 출력
        public int[][] dangerous(int[][] board){
            //초기화 하는 과정에서 아예 두개씩 더 큰 board(아래 위 왼 오 한개씩 더 큰 줄을 만듦)를 형성함(i-1,k-1이 0보다 커야 하는것때문)
            int[][] bomb = new int[board.length+2][board[0].length+2];
            //초기화
            for(int j=0;j<bomb.length;j++){
                for(int h=0;h<bomb[0].length;h++){
                    bomb[j][h] =0;
                }
            }

            //위험지대까지 판단
            for(int i=0;i<board.length;i++){
                for(int k=0;k<board[0].length;k++){
                    if(board[i][k]==1){
                        bomb[i][k+2]=1;
                        bomb[i+1][k+2]=1;
                        bomb[i+2][k+2]=1;
                        bomb[i][k+1]=1;
                        bomb[i+1][k+1]=1;
                        bomb[i+2][k+1]=1;
                        bomb[i][k]=1;
                        bomb[i+1][k]=1;
                        bomb[i+2][k]=1;
                    }
                }
            }
            return bomb;
        }

        public int solution(int[][] board) {
            int answer = 0;
            int [][] bomb=dangerous(board);

            //0인 지역 개수 세서 return
            for(int i=1;i<bomb.length-1;i++){
                for(int k=1;k<bomb.length-1;k++){
                    if(bomb[i][k]==0){
                        answer=answer+1;
                    }
                }
            }
            return answer;
        }
    }
    
}
