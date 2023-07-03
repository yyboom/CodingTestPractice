package programmers;
public class Lv2_21 {
    // 20230703
    // 조이스틱
    // https://born2bedeveloper.tistory.com/26
    public static int solution(String name) {
        int answer = 0;
        int move = name.length()-1; // 오른쪽으로 쭉 간거
        // 1. 각각 알파벳이 몇번 변해야 하는지 저장해둠
        for(int i=0;i<name.length();i++){
            // 알파벳 변경
            answer += Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
            
            if(i<name.length()-1 &&  name.charAt(i+1)=='A'){
                // 커서 변경
                int index = i+1;
                // A가 끝나는 지점부터 길이 계산해서 다시 바꿔줌
                while(index<name.length() && name.charAt(index)=='A') index++;

                move = Math.min(move, i+i+name.length()-index); // 오른쪽으로 갔다가 왼쪽으로 틀기
                move = Math.min(move, i+2*(name.length()-index)); // 왼쪽으로 갔다가 오른쪽으로 틀기
            }
        }
        
        return answer+move;
    }
    
    public static void main(String args[]) throws Exception {
        String name = "JEROEN";
        // String name = "JAN";

        int answer=solution(name);
        System.out.println("answer"+answer);
    }
}
