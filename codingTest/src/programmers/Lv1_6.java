package programmers;

public class Lv1_6 {
    // programmers lv1 신규 아이디 추천 문제 정답
    // 풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 3분 코드 작성:90분
    // 20221227 15:31PM~20230101 22:31PM
	class Solution {

		// 어떤 문자인지 여부 판단
		public String position(String b) {
			String answer = "";
			String[] id = b.split("");
			for (int i = 0; i < b.length(); i++) {
				char c = id[i].charAt(0);
				if (id[i].contains("-") || id[i].contains(".") || id[i].contains("_")) { // 특수문자 인 경우
					answer += id[i];
				} else { // 특수문자가 아닌 경우
					if ((int) id[i].charAt(0) >= 48 && 57 >= (int) id[i].charAt(0)) { // 숫자인 경우
						answer += id[i];
					} else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
						// 문자인 경우
						answer += id[i].toLowerCase();
					}
				}
			}

			return answer;
		}

		public String solution(String new_id) {
			String answer = "";
			
			// 1단계,2단계
			String[] id = position(new_id).split("");
			System.out.println(position(new_id));

			// 3단계
			String tmp = id[0];

			for (int i = 0; i < id.length; i++) {
				if (tmp.equals(".")) {
					if (tmp.equals(id[i])) {
						tmp = id[i];
					}else {
						tmp=id[i];
						answer+=id[i];
					}
				}else {
					tmp=id[i];
					answer+=id[i];
				}

			}
			
            if(answer.length()==0) {
            	answer="aaa";
            }
			//4단계
			if(answer.indexOf(".")==0) {
				answer=answer.substring(1, answer.length());
			}
			if(answer.indexOf(".")==answer.length()-1) {
				answer=answer.substring(0, answer.length()-1);
			}

            //5단계,6단계, 7단계
            if(answer.length()>0 && answer.length()<3) {
            	String[] a = answer.split("");
            	String some = a[a.length-1];
            	for(int i=a.length; i<3;i++) {
            		answer+=some;
            	}
            }else if(answer.length()>15){
            	answer=answer.substring(0, 15);
            	//한번 더 .제거
            	if(answer.substring(answer.length()-1).equals(".")) {
            		answer=answer.substring(0, answer.length()-1);
            	}
            	
            }else {
            	//한번 더 .제거
            	if(answer.substring(answer.length()-1).equals(".")) {
            		answer=answer.substring(0, answer.length()-1);
            	}
            }
			return answer;
		}
	}
}
