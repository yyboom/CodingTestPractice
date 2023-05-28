package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Lv1_19 {
    // 둘만의 암호
    // 20230528
    public static String solution(String s, String skip, int index) {
        String answer = "";
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayList<String> al = new ArrayList<>();
        String[] skiplist = skip.split("");

        // 1. skip에 없는 알파벳들 넣어주기
        for (int j = 0; j < alphabet.length; j++) {
            for (int i = 0; i < skip.length(); i++) {
                if (skiplist[i].equals(alphabet[j])) {
                    break;
                }else{
                    al.add(alphabet[j]);
                    break;
                }
            }
        }

        // 2. 원하는 문자로 만들어주기
        String[] slist = s.split("");
        for (int i = 0; i < s.length(); i++) {
            for(int j=0;j<al.size();j++){
                if(slist[i].equals(al.get(j))){
                    if((j+index)>=al.size()){
                        answer+= al.get(j+index-al.size());
                        break;
                    }else{
                        answer+= al.get(j+index);
                        break;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String args[]) throws Exception {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        String result = solution(s, skip, index);

        System.out.println("result"+result);
    }
}
