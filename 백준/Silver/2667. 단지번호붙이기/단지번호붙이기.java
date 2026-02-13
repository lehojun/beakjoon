import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] arr;
	static ArrayList<Integer> houseCnt;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	static public class Point{
		int x,y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public int BFS(int x,int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x,y));
		arr[x][y]='0';
		int cnt = 1;
		while(!q.isEmpty()) {
			Point p = q.poll();
			for(int i=0; i<4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]=='1') {
					q.offer(new Point(nx,ny));
					arr[nx][ny]='0';
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new char[n][n];
		houseCnt = new ArrayList<>();
		for(int i=0; i<n; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j]=='1') {
					houseCnt.add(T.BFS(i,j));
				}
			}
		}
		
		Collections.sort(houseCnt);

		System.out.println(houseCnt.size());
		for(int x: houseCnt) {
			System.out.println(x);
		}
	}

}
