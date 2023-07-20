package Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class P1475 {
    // 20230721
    public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
        // 1. 필요한 숫자 개수를 넣어서 세줌
        int[] num = new int[10];
        String s = sc.nextLine();
        for(int i=0;i<s.length();i++){
            int n = (int)s.charAt(i)-48;
            num[n]++;
        }

        // 2. 6,9는 둘의 개수를 더해준 다음 몫을 넣어줌
        int temp = num[6]+num[9];
        if(temp%2==1){
            num[6]=num[9]=temp/2+1;
        }else{
            num[6]=num[9]=temp/2;
        }
        
        // 3. 오름차순 정렬 후 max찾기(array이기에 편하게 하기 위해서 오름차순으로 정렬해줌.)
        Arrays.sort(num);
        System.out.println(num[9]);
    }
}
