package programmers;
public class Lv3_6 {
    // 20230707
    // 단어 변환
    static boolean[] visited;
    static int answer=Integer.MAX_VALUE;
    public static int solution(String begin, String target, String[] words) {

        // 1. targer단어가 words에 없다면 변경할 수 없음.
        visited = new boolean[words.length];
        dfs(begin,target,words,0);

        if(answer==Integer.MAX_VALUE) answer=0;

        return answer;
    }

    public static void dfs(String begin, String target, String[] words, int cnt){
        if(begin.equals(target)){
            answer = Math.min(answer, cnt);
            return;
        }

        for(int i=0;i<words.length;i++){
            if(visited[i]) continue;

            // 2. words에 단어가 있다면 변경이 가능
            int s = 0;
            for(int j=0;j<begin.length();j++){
                if(begin.charAt(j)==words[i].charAt(j))s++;
            }

            if(s==begin.length()-1){ // 같은 글자가 하나만 다를 때
                visited[i]=true;
                dfs(words[i], target, words, cnt+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String args[]) throws Exception {
        String begin = "hit";
        String target= "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        // String begin = "hit";
        // String target= "cog";
        // String[] words = {"hot", "dot", "dog", "lot", "log"};

        int answer = solution(begin, target, words);
        System.out.println(answer);
    }
}
