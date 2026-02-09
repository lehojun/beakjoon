
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public int solution(int n, int k, Integer[] arr) {
		int answer = 0;
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(Integer x : arr) {
			if(k-x>=0) {
				answer += k/x;
				k %= x;
			}
		}
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer arr[] = new Integer[n];
		for(int i=0; i<n; i++) {
			while(!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sb.append(T.solution(n, k, arr));
		System.out.print(sb);
	}

}
