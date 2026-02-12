import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void BFS(int y, int x, int n, int m, int[][] farm) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        farm[y][x] = 0; 
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                //경계선 체크
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (farm[ny][nx] == 1) {
                        farm[ny][nx] = 0; 
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken()); 
            int k = Integer.parseInt(st.nextToken());

            int[][] farm = new int[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }

            int cnt = 0;
            for (int r = 0; r < n; r++) { 
                for (int c = 0; c < m; c++) { 
                    if (farm[r][c] == 1) {
                        cnt++; 
                        T.BFS(r, c, n, m, farm);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}