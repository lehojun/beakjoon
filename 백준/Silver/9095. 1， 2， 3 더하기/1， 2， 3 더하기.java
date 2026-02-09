import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int cnt;
	public void BFS(int cur, int L) {
		if(cur > L) return;
		if(cur == L) {
			cnt++;
			return;
		} else {
			BFS(cur+1,L);
			BFS(cur+2,L);
			BFS(cur+3,L);
		}
	}

	public static void main(String[] args) throws IOException {
	    Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    
	    for(int i=0; i<n; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int num = Integer.parseInt(st.nextToken());
	    	cnt =0;
	    	T.BFS(0, num);
	    	sb.append(cnt).append("\n");
	    }
	    System.out.print(sb);
	}
	

}
