package programmers;
public class Pccp2_1 {
    // 20230711
    // Pccp 모의고사 2회 1번
    public static int[] solution(String command) {
        int[] answer = {0,0};
        // 1. 방향 변수를 정해줌
        int a = 0;
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)==82){ // 오른쪽으로 돌아갈 때
                a++;
                if(a>=0)a=a%4;
                else{
                    a=a+4;
                    a=a%4;
                }
            }else if(command.charAt(i)==76){ // 왼쪽으로 돌아갈 때
                a--;
                if(a>=0)a=a%4;
                else{
                    a=a+4;
                    a=a%4;
                }
            }else{ // 옮겨줌
                if(a==0){ // 북
                    if(command.charAt(i)==66){ // back
                        answer[1]--; // y축 한칸 아래로
                    }
                    if(command.charAt(i)==71){ // go
                        answer[1]++; // y축 한칸 위로
                    }
                }
                if(a==1){ //동
                    if(command.charAt(i)==66){
                        answer[0]--; // x축 한칸 뒤로
                    }
                    if(command.charAt(i)==71){
                        answer[0]++; // x축 한칸 앞으로
                    }
                }
                if(a==2){ // 남
                   if(command.charAt(i)==66){
                        answer[1]++;
                    }
                    if(command.charAt(i)==71){
                        answer[1]--;
                    }
                }
                if(a==3){ // 서
                    if(command.charAt(i)==66){
                        answer[0]++;
                    }
                    if(command.charAt(i)==71){
                        answer[0]--;
                    }                    
                }
            }
            
        }
        return answer;
    }

}
