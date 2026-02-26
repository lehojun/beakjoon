import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int result = 0;
	static int[] board;
	public void BFS() {
		Queue<Integer> q = new LinkedList<>();
		int[] dist=new int[101]; 
		Arrays.fill(dist, -1);
		
		q.offer(1);
		dist[1]=0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur == 100) {
				System.out.print(dist[100]);
				return;
			}
			
			for(int i=1; i<=6; i++) {
				int next = cur+i;
				if(next>100) continue;
				
				if(board[next] != 0) {
					next = board[next];
				}
				
				if(dist[next] == -1 ) {
					dist[next] = dist[cur]+1;
					q.offer(next);
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		board = new int[101];
		
		for (int i = 0; i < n + m; i++) {
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			board[x]= y;
		}

		T.BFS();
	}
}


