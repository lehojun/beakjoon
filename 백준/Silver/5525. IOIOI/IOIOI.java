import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int cnt =0;
		String s = br.readLine();
		int patternCnt = 0;
		
		for(int i=0; i<m-2; i++) {
			if(s.charAt(i)=='I' && s.charAt(i+1)=='O' && s.charAt(i+2)=='I') {
				patternCnt++;
				
				if(patternCnt==n) {
					cnt++;
					patternCnt--;
				}
				i++;
			} else {
				patternCnt =0;
			}
		}
		System.out.println(cnt);
	}
}
