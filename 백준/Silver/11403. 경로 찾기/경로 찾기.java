import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph, result;
	static int n;
	public void DFS(int start, int now, boolean[] visited) {
		for(int next =0; next<n; next++) {
			if(graph[now][next] == 1 && visited[next]==false) {
				visited[next] = true;
				result[start][next]=1;
				DFS(start,next,visited);
			}
		}
	}

	public static void main(String[] args) throws IOException{
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		result = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			boolean[] visited = new boolean[n];
			T.DFS(i,i,visited);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
		//플로이드-워셜 방식 중간지점인 k 루프가 가장 위에 있어야 한다.
//		for(int k=0; k<n; k++) {
//			for(int i=0; i<n; i++) {
//				for(int j=0;j<n;j++) {
//					if(graph[i][k]==1 && graph[k][j]==1) {
//						graph[i][j]= 1;
//					}
//				}
//			}
//		}
	}
}