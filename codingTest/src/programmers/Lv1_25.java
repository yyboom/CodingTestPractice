package programmers;
public class Lv1_25 {
    // 20230702
    // 체육복
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 1. 전체 옷에서 여분 옷 빼줌
        int[] people = new int[n+2]; // 전체 학생 수
        people[0]=-2;
        people[n+1]=-2;
        for(int i=0;i<lost.length;i++){
            --people[lost[i]];
        }
        for(int i=0;i<reserve.length;i++){
            ++people[reserve[i]];
        }

        // 2. 빌려줄 때 앞을 먼저 보고 있으면 뒤로 빌려줌
        for(int i=1;i<people.length-1;i++){
            if(people[i-1]!=-2 && people[i]==1){ // 여분 옷이 있는 사람일때
                if(people[i-1]==-1){
                    people[i-1]++;
                    people[i]--;
                }
            }

            if(people[i+1]!=-2 && people[i]==1){ // 여분 옷이 있는 사람일때
                if(people[i+1]==-1){
                    people[i+1]++;
                    people[i]--;
                }
            }
        }

        // 3. 0이상인 사람 숫자 세기
        for(int i:people){
            if(i>-1) answer++;
        }
        return answer;
    }
    public static void main(String args[]) throws Exception {
        // int n = 5;
        // int[] lost ={2,4};
        // int[] reverse = {1,3,5};

        int n = 5;
        int[] lost ={2,4};
        int[] reverse = {3};

        // int n = 3;
        // int[] lost ={3};
        // int[] reverse = {1};

        int answer = solution(n, lost, reverse);
        System.out.println(answer);

    }
}
