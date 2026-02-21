import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int result =0;
	
	public int BFS(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[100001];
		q.offer(n);
		visited[n]=1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now==k) return visited[now]-1;
			
			int[] nextPos = {now+1, now-1, now*2};
			for(int pos : nextPos) {
				if(pos>=0 && pos<=100000 && visited[pos] == 0) {
					q.offer(pos);
					visited[pos]=visited[now]+1;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		System.out.println(T.BFS(n, k));
	}

}