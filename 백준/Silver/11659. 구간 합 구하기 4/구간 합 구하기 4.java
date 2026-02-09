import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder(); 
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    int[] arr = new int[n+1];
	    int[] dp = new int[n+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i = 1; i<=n; i++) {
	    	arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i=1; i<=n; i++) {
	    	dp[i] = dp[i-1]+arr[i];
	    }
	    
	    for(int i=0; i<m; i++) {
	    	st= new StringTokenizer(br.readLine());
	    	int lt = Integer.parseInt(st.nextToken());
	    	int rt = Integer.parseInt(st.nextToken());
	    	sb.append(dp[rt]-dp[lt-1]).append("\n");
	    }
	    System.out.print(sb);

	}

}
