import java.util.*;

public class Main {
	static int n, m;
	static int[][] board;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int day = 0;
	static Queue<Point> Q = new LinkedList<>();
	static class Point{
		public int x,y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
	public void BFS(int x, int y) {
			while(!Q.isEmpty()) {
				int len = Q.size();
				for(int i=0; i<len; i++) {
				Point tmp = Q.poll();
				for(int j=0; j<4; j++) {
					int nx = tmp.x+dx[j];
					int ny = tmp.y+dy[j];
					
					if(nx>=0 && nx<n && ny>=0 && ny<m && board[nx][ny] == 0) {
						board[nx][ny] = board[tmp.x][tmp.y]+1;
						Q.offer(new Point(nx,ny));
					}
				}
			}
				day++;
		}
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		boolean flag = true;
		m = kb.nextInt();
		n = kb.nextInt();
		board = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				board[i][j]=kb.nextInt();
				if(board[i][j]==1) Q.offer(new Point(i,j));
			}
		}
		
		T.BFS(0, 0);

		for (int i = 0; i < n; i++) {
		    for (int j = 0; j < m; j++) {
		        if (board[i][j] == 0) {
		            flag = false;
		        }
		    }
		}

		if (flag) {
		    if (day == 0) System.out.println(0); 
		    else System.out.println(day - 1);
		} else {
		    System.out.println(-1);
		}
	}
}
