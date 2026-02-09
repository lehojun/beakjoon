import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++ ) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[n+1];
		
		dp[1] = arr[1];
		if(n>=2) {
			dp[2] = arr[1]+arr[2];
		}
		
		for(int i=3; i<=n; i++) {
			// 2칸전에서 온 경우 vs 1칸 전에서 온 경우. 1칸 전에서 왔을 경우 2칸 전에서 오면 3칸 연속이므로 3칸 전에서 와야함
			//dp[i-1]이 아닌 arr[i-1]인 이유는 dp[i-1]일 경우 최댓값을 찾아오기 때문에 i-2, i-1 값도 포함되어있음.
			dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1])+arr[i];
		}
		
		System.out.print(dp[n]);
	}
}
