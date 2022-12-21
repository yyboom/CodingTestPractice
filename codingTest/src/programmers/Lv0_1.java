package programmers;

public class Lv0_1 {
	
	class Solution {
		//commit내용 변경
		//programmers lv0 옹알이(1) 문제 정답
		//풀이 총 걸린 시간: 문제 파악&문제 풀이 방향: 10분 코드 작성: 8분 
		// 20221216 3:00AM~3:18AM
		
	    public int solution(String[] babbling) {
	        int answer = 0;
	        
	        String[] cantalk = {"aya","ye","woo","ma"};
	        
	        //babbling안에 단어 한개씩 뽑기
	        for(int i=0;i<babbling.length;i=i+1) {
	        	//cantalk안에 단어 한개씩 뽑기
	        	for(int a=0;a<cantalk.length;a=a+1) {
		        	//1개 조합
		        	if(babbling[i].equals(cantalk[a])) {
		        		answer = answer+1;
		        	}else {
		        		//2개 조합
			        	for(int b=0;b<cantalk.length;b=b+1) {
			        		if(babbling[i].equals(cantalk[a]+cantalk[b])){
			        			answer = answer+1;
			        		}else {
			        			//3개 조합
			        			for(int c=0;c<cantalk.length;c=c+1) {
			        				if(babbling[i].equals(cantalk[a]+cantalk[b]+cantalk[c])) {
			        					answer = answer+1;
			        				}else {
			        					//4개 조합
			        					for(int d=0;d<cantalk.length;d=d+1) {
					        				if(babbling[i].equals(cantalk[a]+cantalk[b]+cantalk[c]+cantalk[d])) {
					        					answer = answer+1;
			        				}
			        			}
			        		}
			        	}
		        	}
	        	}
	        	
	        }
	    }
	        }
	        return answer;
	    }
	}
}
