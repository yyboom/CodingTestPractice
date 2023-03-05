package chofolder.Baekjoon;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 풀이 날짜: 20230305
// 풀이 시간: 13:00~13:07
public class P2587 {
    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("/vsworkspace/team3CotePrac/choCodingTest/src/chofolder/input/p2587.txt"));
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            arr.add(sc.nextInt());
        }
        Collections.sort(arr);

        int all = 0;
        for(int i=0;i<arr.size();i++){
            all += arr.get(i);
        }
        System.out.println(all/arr.size());
        System.out.println(arr.get(arr.size()/2));
    }
}
