import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<String[]> queue = new LinkedList<>();

        queue.offer(new String[]{begin, "0"});
        
        while(!queue.isEmpty()) {
            String[] cur = queue.poll();
            String word = cur[0];
            int cnt = Integer.parseInt(cur[1]);
            
            if(word.equals(target)) {
                return cnt;
            }
            
            for(int i=0; i<words.length; i++) {
                if(!visited[i] && canChange(word, words[i])) {
                    visited[i] = true;
                    queue.offer(new String[]{words[i],String.valueOf(cnt+1)});
                }
            }
        }
        return 0;
    }
    
    public boolean canChange(String a, String b) {
        int diff = 0;
        
        for(int i =0; i<a.length(); i++) {
            if(a.charAt(i) != b.charAt(i))
                diff++;
            }
        if(diff==1) return true;
        else return false;
    }
}