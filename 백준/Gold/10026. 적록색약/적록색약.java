import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void BFS(int x, int y, char s, char[][] arr) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x,y));
		arr[x][y] = 'N';

		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx=p.x+dx[i];
				int ny=p.y+dy[i];
			
				if(nx>=0 && ny>=0 && nx<n && ny<n && arr[nx][ny] == s) {
					arr[nx][ny]='N';
					q.offer(new Point(nx,ny));
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[][] arr1 = new char[n][n];
		char[][] arr2 = new char[n][n];
		int result1 = 0, result2 = 0;

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				arr1[i][j] = line.charAt(j);
				if (line.charAt(j) == 'R') arr2[i][j] = 'G';
				else arr2[i][j] = line.charAt(j); 
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr1[i][j] != 'N') {
					result1++;
					T.BFS(i, j, arr1[i][j], arr1);
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr2[i][j] != 'N') {
					result2++;
					T.BFS(i, j, arr2[i][j], arr2);
				}
			}
		}	
		System.out.print(result1+" "+result2);
	}
}
