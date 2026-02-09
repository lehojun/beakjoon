import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n=Integer.parseInt(st.nextToken());
	    long[] dp = new long[101];
	    dp[1]=1;
	    dp[2]=1;
	    dp[3]=1;
	    dp[4]=2;
	    dp[5]=2;
	    dp[6]=3;
	    dp[7]=4;
	    dp[8]=5;
	    dp[9]=7;
	    dp[10]=9;
	    for(int i=10; i<=100; i++) 
	    	dp[i] = dp[i-1]+dp[i-5];
	    
	    for(int i=0; i<n; i++) {
	    	long t = Long.parseLong(br.readLine());
	    	sb.append(dp[(int) t]).append("\n");
	    }
	    System.out.print(sb);
	}

}
