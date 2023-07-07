package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Lv3_10 {
    // 20230707
    // 여행경로
    static ArrayList<String> arr;
    static boolean[] bool;
    public static String[] solution(String[][] tickets) {
        arr = new ArrayList<>();
        bool = new boolean[tickets.length];

        // 시작지점이 ICN
        int cnt = 0;
        dfs("ICN","ICN",tickets,cnt);

        // 오른차순 정렬
        Collections.sort(arr);

        String[] answer = arr.get(0).split(" ");
        return answer;

    }
    
    // 모든 tickets를 다 돌아야하기에 dfs를 반드시 써줘야함.
    public static void dfs(String start, String t, String[][] tickets, int cnt){
        if(cnt==tickets.length){
            arr.add(t);
            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(start.equals(tickets[i][0])&&!bool[i]){ // 시작점이 같을때
                String c=t+" "+tickets[i][1];
                bool[i]=true;
                dfs(tickets[i][1], c, tickets, cnt+1);
                bool[i]=false;
            }
        }
    }

    public static void main(String args[]) throws Exception {
        //String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        String[] answer = solution(tickets);
        for(String i:answer) System.out.printf(i+" ");
    }
}
