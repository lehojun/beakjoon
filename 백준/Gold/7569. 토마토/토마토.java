import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, h, day = 0;
	static int[][][] farm;
	static Queue<Point> q = new LinkedList<>();
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };

	static class Point {
		int x, y, h;

		public Point(int h, int x, int y) {
			this.x = x;
			this.y = y;
			this.h = h;
		}
	}

	public void BFS() {

		while (!q.isEmpty()) {
			int len = q.size();
			for (int i = 0; i < len; i++) {
				Point p = q.poll();
				for (int j = 0; j < 6; j++) {
					int nh = p.h + dh[j];
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (nh >= 0 && nx >= 0 && ny >= 0 && nh < h && nx < n && ny < m && farm[nh][nx][ny] == 0) {
						q.offer(new Point(nh, nx, ny));
						farm[nh][nx][ny] = 1;
					}
				}
			}
			day++;
		}

	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean flag = false;

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		farm = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					farm[i][j][k] = Integer.parseInt(st.nextToken());
					if (farm[i][j][k] == 1) q.offer(new Point(i, j, k));
				}
			}
		}
		
		

		T.BFS();
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if(farm[i][j][k]==0) flag = true;
				}
			}
		}
		if(flag) System.out.println(-1);
		else if (day==0) System.out.println(0);
		else System.out.println(day-1);
	}
}