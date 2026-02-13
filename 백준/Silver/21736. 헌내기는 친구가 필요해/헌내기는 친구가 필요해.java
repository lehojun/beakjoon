import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m, cnt;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] arr;
	static int[][] ch;
	
	public void DFS(int x, int y) {
		// x 만난경우, o 만난 경우, p 만난경우 3가지 경우의 수 분리
		ch[x][y]=1;
		if(arr[x][y]=='P') cnt++;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<n && ny>=0 && ny<m && ch[nx][ny]==0) {
				if(arr[nx][ny]!='X') {
					DFS(nx,ny);
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		cnt =0;
		arr = new char[n][m];
		ch = new int[n][m];
		for(int i=0; i<n; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 'I') {
					ch[i][j]=1;
					T.DFS(i, j);
				}
			}
		}
		if(cnt==0) System.out.print("TT");
		else System.out.print(cnt);
		
	}

}
