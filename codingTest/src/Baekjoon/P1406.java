package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class P1406 {
    // 20230719
    // 1. arraylist로 문장을 받아오고 커서를 0으로 표시해서 해당 자리에 넣어줌.
    public static void main(String args[]) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String N = bf.readLine(); // abcd
        
        // stack을 이용해서 넣어줘야 시간을 확연히 줄일 수 있음
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        for(int i=0;i<N.length();i++){
            left.add(String.valueOf(N.charAt(i)));
        }

        // 2. 해당 명령어를 받으며 수행
        int M = Integer.parseInt(bf.readLine());
        for(int i=0;i<M;i++){
            String str = bf.readLine(); // 명령문장
            String a="";
            String b="";
            if(str.length()>1){
                String[] ars = str.split(" ");
                a=ars[0];
                b=ars[1];
            }else{
                a=str;
            }

            if(a.equals("L")){
                if(left.isEmpty()) continue;
                right.push(left.pop());
            }
            if(a.equals("D")){
                if(right.isEmpty()) continue;
                left.push(right.pop());
            }
            if(a.equals("B")){
                if(left.isEmpty()) continue;
                left.pop();
            }
            if(a.equals("P")){
                left.push(b);
            }

        }

        // 출력
        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()) right.push(left.pop());
        while(!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb);

    }
    
}
