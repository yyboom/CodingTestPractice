package programmers;
public class Lv2_1 {
    // programmers lv2 가장 큰 수 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 30분 코드 작성: 16분
    // 20230112 16:14PM~17:00
    // 기본 정렬 알고리즘 종류 https://hyo-ue4study.tistory.com/68
    // array sort이용 
    class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            String[] number = new String[numbers.length];
            for(int i=0;i<numbers.length;i++){
                number[i] = String.valueOf(numbers[i]);
            }

           	// 정렬
            // array sort안에 수 2개를 더하여 비고해서 넣어주면 됨
		    Arrays.sort(number, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return ((o2 + o1).compareTo(o1 + o2));
			}
		    });

            // 전부다 0일때 반례
            if(number[0].equals("0")){
                return "0";
            }

            for(String a:number){
                answer += a;
            }
            return answer;
        }
    }
}
