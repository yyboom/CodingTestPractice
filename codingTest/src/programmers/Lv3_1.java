package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Lv3_1 {
    // 20230615
    // 베스트앨범

    // music class
    static class Music{
        int index;
        String genre;
        int streaming;

        public Music(int index, String genre, int streaming){
            this.index=index;
            this.genre=genre;
            this.streaming=streaming;
        }
    }
    public static int[] solution(String[] genres, int[] plays) {

        // 0. 장르별로 전체 sum
        Map<String, Integer> shash = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            shash.put(genres[i], shash.getOrDefault(genres[i], 0)+plays[i]); // 없는 key값일 때 value를 0으로 하여 hashmap에 넣어주는 것
        }

        // sum값에 따라 내림차순 정렬
        // hashmap value값 기준으로 내림차순 정렬
        // List<Map.Entry<String, Integer>> entryList = new LinkedList<>(shash.entrySet()); // shash의 entry set을 list형태로 저장
        // entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
        //     @Override
        //     public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        //     return o1.getValue() - o2.getValue();
        //     }
        // });
        List<String> key = new ArrayList<>(shash.keySet()); // hashmap정렬은 따로 빼서 해주는게 좋음.
        Collections.sort(key,((o1, o2) -> (shash.get(o2)).compareTo(shash.get(o1))));

        // 1. hash크기 만큼 돌면서 장르별로 각각의 노래 스트리밍 수 생성
        ArrayList<Music> array = new ArrayList<>();
        for(String i : key){
            System.out.println(i);
            System.out.println(shash.get(i));
            ArrayList<Music> imshi = new ArrayList<>(); // 각 장르 안에 music들
            for(int j=0;j<genres.length;j++){
                if(genres[j].equals(i)){
                    imshi.add(new Music(j, genres[j], plays[j]));
                }
            }

            // 2, 각 장르 안에 넣은 음악들을 가지고 내림차순 정렬
            Collections.sort(imshi, (o1,o2)->o2.streaming-o1.streaming); // 람다식으로 streaming횟수 기준 내림차순 정렬
            
            // 3. 정답에 수록
            array.add(imshi.get(0));
            if(imshi.size()>=2) array.add(imshi.get(1));
        }
        int[] answer = new int[array.size()];
        // arraylist배열로 바꿔주기(int는 어쩔 수 없이 for문을 사용해서 넣어줘야 함. primitive type이기 때문)
        // String일 때는 String arr[] = arrList.toArray(new String[arrListSize]);로 가능
        for(int i=0;i<array.size();i++){
            answer[i]=array.get(i).index;
        }
        return answer;
    }
    public static void main(String args[]) throws Exception {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 600};
        int[] answer = solution(genres,plays);
        for(int i:answer){
            System.out.printf(i+" ");
        }
    }
}
