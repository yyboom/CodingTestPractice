package programmers;
public class Lv1_2 {
    // programmers lv1 키패드 누르기 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 8분 코드 작성: 22분
    // 20221223 15:25PM~15:55PM
    class Solution {
        public int[][] position(int[] numbers){
            int[][] new1 = new int[numbers.length][2];
            for(int i =0;i<numbers.length;i++){
                if(numbers[i]==1){
                    new1[i][0]=0;
                    new1[i][1]=3;
                }
                if(numbers[i]==2){
                    new1[i][0]=1;
                    new1[i][1]=3;
                }
                if(numbers[i]==3){
                    new1[i][0]=2;
                    new1[i][1]=3;
                }
                if(numbers[i]==4){
                    new1[i][0]=0;
                    new1[i][1]=2;
                }
                if(numbers[i]==5){
                    new1[i][0]=1;
                    new1[i][1]=2;
                }
                if(numbers[i]==6){
                    new1[i][0]=2;
                    new1[i][1]=2;
                }
                if(numbers[i]==7){
                    new1[i][0]=0;
                    new1[i][1]=1;
                }
                if(numbers[i]==8){
                    new1[i][0]=1;
                    new1[i][1]=1;
                }
                if(numbers[i]==9){
                    new1[i][0]=2;
                    new1[i][1]=1;
                }
                if(numbers[i]==0){
                    new1[i][0]=1;
                    new1[i][1]=0;
                }
            }
            return new1;
        }

        public String solution(int[] numbers, String hand) {
            String answer = "";

            //시작지점
            int[][] lefthand = {{0,0}};
            int[][] righthand = {{2,0}};

            //초기화 후 값을 계속 바꾸고 싶으면 반드시 for문 밖으로 빼줘야함!!
            int a2= lefthand[0][0];
            int b2= lefthand[0][1];
            int a3= righthand[0][0];
            int b3= righthand[0][1];

            int [][] new1 = position(numbers);

            for(int i=0;i<numbers.length;i++){
                int a1= new1[i][0];
                int b1= new1[i][1];

                if(new1[i][0]==2){
                    a3= new1[i][0];
                    b3= new1[i][1];
                    answer=answer+"R";
                }
                if(new1[i][0]==0){
                    a2= new1[i][0];
                    b2= new1[i][1]; 
                    answer=answer+"L";
                }
                if(new1[i][0]==1){
                    if(Math.abs(a1-a2)+Math.abs(b1-b2)<Math.abs(a1-a3)+Math.abs(b1-b3)){
                        a2= new1[i][0];
                        b2= new1[i][1];
                        answer=answer+"L";
                    }if(Math.abs(a1-a2)+Math.abs(b1-b2)>Math.abs(a1-a3)+Math.abs(b1-b3)){
                        a3= new1[i][0];
                        b3= new1[i][1];
                        answer=answer+"R";
                    }if(Math.abs(a1-a2)+Math.abs(b1-b2)==Math.abs(a1-a3)+Math.abs(b1-b3)){
                        if(hand.equals("right")){
                            a3= new1[i][0];
                            b3= new1[i][1];
                            answer=answer+"R";
                        }
                        if(hand.equals("left")){
                            a2= new1[i][0];
                            b2= new1[i][1];
                            answer=answer+"L";
                        }
                    }
                }
            }
            return answer;
        }
    }
    
}
