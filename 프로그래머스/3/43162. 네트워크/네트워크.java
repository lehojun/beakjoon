class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(n, computers, visited, i);
                answer++;
            }    
        }
        return answer;
    }
    
    public void dfs(int n, int[][] computers, boolean[] visited, int i) {
        visited[i] = true;
        
        for(int j = 0; j<n; j++) {
            if(computers[i][j] == 1) {
                computers[i][j] = 0;
                dfs(n, computers, visited, j);
            }
        }
    }
}