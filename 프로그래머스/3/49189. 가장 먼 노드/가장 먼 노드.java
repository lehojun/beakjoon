import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        int[] dist = bfs(graph,n);
        
        int max = 0;
        for(int i=1; i<=n; i++) {
            max = Math.max(max,dist[i]);
        }
        
        for(int i=1; i<=n; i++) {
            if(dist[i] == max) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public int[] bfs(List<List<Integer>> graph, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;
        
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            
            for(int next : graph.get(cur)){
                if(dist[next] == -1) {
                    dist[next] = dist[cur] +1;
                    queue.offer(next);
                }
            }
        }
        
        return dist;
        
    }
}