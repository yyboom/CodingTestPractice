package programmers;
public class Lv0_3 {
        // programmers lv0 겹치는 선분의 길이 문제 정답
	// 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 6분 코드 작성: 54분
	// 20221219 23:43PM~00:43PM 
    class Solution {
        //큰수 찾기
        public int big(int[] aline, int[] bline){
            if(aline[0]<bline[0]){
                return bline[0];
            }else{
                return aline[0];
            }
        }

        //작은수 찾기
        public int small(int[] aline, int[] bline){
            if(aline[1]<bline[1]){
                return aline[1];
            }else{
                return bline[1];
            }
        }

        //겹치는 유무 찾기
        public boolean samepart(int[] aline, int[] bline){
            boolean a = false;
            if(aline[0]<bline[0] && aline[1]<bline[1]){
                if(aline[1]<bline[0]){
                    a=true;
                }
            }
            if(aline[0]>bline[0] && aline[1]>bline[1]){
                if(aline[0]>bline[1]){
                    a=true;
                }
            }

            return a;
        }

        public int solution(int[][] lines) {
            int answer = 0;

            //1,2,3인풋값 설정
            int[] line1 = lines[0];
            int[] line2 = lines[1];
            int[] line3 = lines[2];

            //새로 겹치는 애들
            int[] newline1 = new int[lines[0].length];
            int[] newline2 = new int[lines[0].length];
            int[] newline3 = new int[lines[0].length];

            //3개가 다 겹치는 애들
            int[] allnewline1 = new int[lines[0].length];

            //1,2비교
            if(samepart(line1, line2)==false){
                newline1[1]=small(line1,line2);
                newline1[0]=big(line1,line2);
                answer=answer+newline1[1]-newline1[0];

            }

            //1,3비교
            if(samepart(line1, line3)==false){
                newline2[1]=small(line1,line3);
                newline2[0]=big(line1,line3);
                answer=answer+newline2[1]-newline2[0];
            }

            //2,3비교
            if(samepart(line2, line3)==false){
                newline3[1]=small(line2,line3);
                newline3[0]=big(line2,line3);
                answer=answer+newline3[1]-newline3[0];
            }

            //1,2,3비교
            if(samepart(newline1, newline2)==false){
                allnewline1[1]=small(newline1, newline2);
                allnewline1[0]=big(newline1, newline2);
                answer=answer-(allnewline1[1]-allnewline1[0]);
                if(samepart(allnewline1, newline3)==false){
                    int a=small(allnewline1, newline3);
                    int b=big(allnewline1, newline3);
                    answer=answer-(a-b);
                }
            }

            return answer;
        }
    }
    
}
