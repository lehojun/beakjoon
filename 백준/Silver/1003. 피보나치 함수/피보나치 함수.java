import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Integer[][] dp = new Integer[41][2];

	public void solution(int n) {
		for (int i = 2; i <= n; i++) {
			if (dp[i][0] == null) {
				dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
				dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		dp[0][0] = 1;
		dp[0][1] = 0; // 0일 때: 0이 1번, 1이 0번
		dp[1][0] = 0;
		dp[1][1] = 1; // 1일 때: 0이 0번, 1이 1번

		String firstLine = br.readLine();
		int t = Integer.parseInt(firstLine);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			T.solution(n);
			sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
		}
		System.out.print(sb);
	}
}