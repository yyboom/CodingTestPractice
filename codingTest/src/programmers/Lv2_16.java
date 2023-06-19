package programmers;

public class Lv2_16 {
    // 20230619
    // 올바른 괄호
    public static boolean solution(String s) {
        boolean answer = true;

        // 1. c와 d의 값으로 설정하여 (과 )를 하나씩 빼주면서 수를 더해감 이때 같아지면 다시 0으로 바꿈.
        int c = 0; // (
        int d = 0; // )
        for(int i=0;i<s.length();i++){
            char j = s.charAt(i); // char로 풀어여 시간 줄어듬!(시간 효율성 해결)
            if(j == '(')c++;
            if(j==')')d++;

            // d>c가 될 시 false로 반환
            if(d>c){
                answer=false;
                break;
            }
        }
        // 2. 끝까지 for문을 다 돌았을 때 개수가 같으면true 아니면 false
        if(c!=d) answer=false;
        return answer;
    }

    public static void main(String args[]) throws Exception {
        String s="()()";
        // String s="(())()";
        // String s=")()(";
        // String s ="(()(";

        boolean answer = solution(s);
        System.out.println(answer);
    }
}
