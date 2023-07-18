package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P3273 {
    // 풀이 날짜: 20230718
            public static void main(String args[]) throws Exception{
			Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int answer = 0;
                
            // 1. arraylist에 넣어 오름차순 정렬
            ArrayList<Integer> arr = new ArrayList<>();
			for (int t=0; t < n; t++) {
                arr.add(sc.nextInt());
            }
            Collections.sort(arr);
            int x = sc.nextInt();
                
            // 2. 첫번재를 뽑고 마지막 arr를 비교
            while(arr.size()>1){
                int a=arr.get(0);
                int b=arr.get(arr.size()-1);
                
                if(a+b==x){
                    answer++;
                    arr.remove(0);
                    arr.remove(arr.size()-1);
                }else if(a+b>x){
                    arr.remove(arr.size()-1);
                }else{
                    arr.remove(0);
                }
            }
            System.out.println(answer);
	    }
}
