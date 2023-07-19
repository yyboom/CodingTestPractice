package Baekjoon;

import java.util.Scanner;

public class P11328 {
    // 20230720
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        // 1. 26개 배열 형성
        int N = Integer.parseInt(sc.nextLine());

        // 2. 첫번째 문자열을 -97해서 배열의 숫자게 ++해줌
        for(int i=0;i<N;i++){
            int[] al = new int[26];
            String answer = "Possible";
            String[] str = sc.nextLine().split(" ");
            String a = str[0];
            String b = str[1];

            for(int j=0;j<a.length();j++){
                int num = (int)a.charAt(j)-97;
                al[num]++;
            }

            // 3. 두번째 문자열에 -97한 다음 배열 숫자에서 --해줌.
            for(int j=0;j<b.length();j++){
                int num = (int)b.charAt(j)-97;
                al[num]--;
            }

            // 4. 출력
            for(int j=0;j<26;j++){
                if(al[j]<0||al[j]>0){
                    answer="Impossible";
                    break;
                }
            }

            System.out.println(answer);

        }
    }


}
