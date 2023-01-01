package programmers;

public class Lv1_4 {
    // programmers lv1 숫자 짝꿍 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 6분 코드 작성:
    // 20221225 17:04PM~20210101 17:00PM
    // 시간초과가 계속 났었음. 기존의 코드는 X,Y를 직접 비교하는 것이기에 big o 가 매우 커졌음.
    // 따라서 둘중에 큰길이의 수를 for문으로 한번만 돌려서 넣어주면 시간을 줄이는데 효과적임.
    // 여기서 더 나아가서 X,Y가 아닌 숫자는 0~9까지이기에 여기서 숫자를 세서 각각의 index에 넣어주는것도 좋을듯함.
    // 또한 시간을 더 줄이기 위해서 String answer +=로 쓰면 새로 객체를 생성하는 개념이라 시간이 오래 걸림. 따라서 StringBuffer을 쓰는 것이 좋음
    class Solution {    
        public String solution(String X, String Y) {

            int[][] arr = new int[2][10];
            //String answer +=로 쓰면 새로 객체를 생성하는 개념이라 시간이 오래 걸림. 따라서 StringBuffer을 쓰는 것이 좋음
            StringBuffer answer = new StringBuffer();

            String[] x1 = X.split("");
            String[] y1 = Y.split("");
    
            for(int i=0; i<Math.max(X.length(), Y.length()); i++) {
                if(i < X.length()){
                    arr[0][Integer.parseInt(x1[i])]++;
                }
                if(i < Y.length()){
                    arr[1][Integer.parseInt(y1[i])]++;
                }
            }
            
            //큰숫자부터 담음.
            for(int i=9; i>=0; i--) {
                for(int j=0; j<Math.min(arr[0][i], arr[1][i]); j++) {
                    answer.append(i);
                }
            }
    
            if(answer.length() == 0){
                return "-1";
            }
            else if(answer.charAt(0) == '0'){
                return "0";
            }
            return answer.toString();
        }
    } 
}
