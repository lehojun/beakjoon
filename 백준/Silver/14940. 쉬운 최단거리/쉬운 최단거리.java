import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] map, dist, visited;
	static Point target;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	
	static class Point{
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x,y));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0; i<4; i++ ) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m && dist[nx][ny]==-1) {
					dist[nx][ny]=dist[p.x][p.y]+1;
					q.offer(new Point(nx,ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		visited= new int[n][m];
		
		for(int i=0; i<n; i++) {
			Arrays.fill(dist[i], -1);
		}
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) {
					target = new Point(i,j);
					dist[i][j]=0;
				}
				if(map[i][j]==0) dist[i][j]=0;
			}
		}
		
		T.BFS(target.x, target.y);
		
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
