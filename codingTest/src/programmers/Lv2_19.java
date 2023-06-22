package programmers;
public class Lv2_19 {
    // 20230623
    // 주식 가격
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // 주식이 하락하기 전까지 answer의 값 하나씩 증가
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                answer[i]++;
                if(prices[i]>prices[j]) break; // 가격이 하락했다는 의미
            }
        }
        return answer;
    }

    public static void main(String args[]) throws Exception {
        int[] prices = {1,2,3,2,3};

        int[] answer = solution(prices);
        for(int i:answer) System.out.printf(i+" ");
    }
}
