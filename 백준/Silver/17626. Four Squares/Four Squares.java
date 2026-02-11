import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];
		
		dp[1]=1;
		for(int i=2; i<=n; i++) {
			int minVal=Integer.MAX_VALUE;
			
			for(int j=1; j*j<=i; j++) {
				int temp = dp[i-j*j];
				minVal = Math.min(minVal, temp);
			}
			dp[i] = minVal+1;
		}
		System.out.println(dp[n]);
	}

}
