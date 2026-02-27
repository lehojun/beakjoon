import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n, r, c, ans;
	
	public static void solve(int size, int r, int c) {
		if(size==1) return;
		
		int half = size/2;
		int area = half * half;
		
		if(r< half && c<half) {
			solve(half,r,c);
		} else if(r<half && c>=half) {
			ans += area;
			solve(half,r,c-half);
		} else if(r>=half && c<half) {
			ans += area*2;
			solve(half,r-half,c);
		} else {
			ans += area*3;
			solve(half,r-half,c-half);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, n);
		solve(size, r, c);
		System.out.println(ans);
	}
}