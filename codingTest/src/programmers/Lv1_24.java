package programmers;

import java.util.*;
public class Lv1_24 {
    // 20230617
    // 같은 숫자는 싫어
    public static int[] solution(int []arr) {
        // 1. queue에 지료 넣기
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            queue.offer(arr[i]);
        }
        
        // 2. queue를 돌면서 뒤에 숫자가 같이 나오면 arraylist에 넣지 않음.
        ArrayList<Integer> array = new ArrayList<>();
        int c = queue.poll(); // 첫번째 값 넣어둠
        array.add(c);
        for(int i=1;i<arr.length;i++){
            int im = queue.poll();
            if(im!=c){
                c=im;
                array.add(im);
            }
        }

        // 3. answer안에 넣어주기
        int[] answer = new int[array.size()];
        for(int i=0;i<array.size();i++){
            answer[i]=array.get(i);
        }

        return answer;
    }

    public static void main(String args[]) throws Exception {
        //int[] arr = {1,1,3,3,0,1,1};
        int[] arr = {4,4,4,3,3};
        int[] answer = solution(arr);
        for(int i: answer) System.out.printf(i+" ");
    }
}
