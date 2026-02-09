import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	public void solution(int n) {
		
		for(int i=2; i<=n; i++ ) {
			dp[i] = dp[i-1]+1;
			if(i%2 ==0) dp[i] = Math.min(dp[i], dp[i/2]+1);
			if(i%3 ==0) dp[i] = Math.min(dp[i], dp[i/3]+1); 
			
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		T.solution(n);
		sb.append(dp[n]);
		System.out.print(sb);
	}
}
