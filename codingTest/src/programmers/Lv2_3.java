package programmers;

//https://blog.naver.com/lovesm135/223067269977
public class Lv2_3 {
    // 124나라의 숫자
    // 20230531
    public static String solution(int n) {
        StringBuilder answer = new  StringBuilder();
        
        while(n>0){
            // 끝자리가 1,2,4로 끝나기 때문에
            while(n>0){
                int num = n%3;
                if(num==0){ // 3의 배수 순번일때는 무조건 끝자리가 4로 끝남.
                    answer.insert(0, "4");
                    n = n/3 - 1;
                }else{
                    answer.insert(0, Integer.toString(num)); // 나머지 숫자 넣어주기
                    n = n/3;
                }
            }
        }

        return answer.toString();
    }

    public static void main(String args[]) throws Exception {
        int numbers = 15;

        String answer = solution(numbers);
        System.out.println("answer"+answer);
    }
}
