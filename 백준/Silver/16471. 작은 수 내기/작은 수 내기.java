
import java.util.*;

public class Main {
	
	public String solution(int n, int[] j_arr, int[] b_arr) {
		String answer = "";
		int cnt=0, j_idx=0, b_idx=0;
		
		Arrays.sort(j_arr);
		Arrays.sort(b_arr);

		while(j_idx<n && b_idx<n) {
			if(j_arr[j_idx]<b_arr[b_idx]) {
				cnt++;
				j_idx++;
				b_idx++;
			}
			else if(j_arr[j_idx]>=b_arr[b_idx]) {
				b_idx++;
			}
		}
		
		if(cnt >= (n+1)/2) answer="YES";
		else answer="NO";
		
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] j_arr = new int[n];
		int[] b_arr = new int[n];
		
		for(int i=0; i<n; i++ ) {
			j_arr[i] = kb.nextInt();
		}
		for(int i=0; i<n; i++ ) {
			b_arr[i] = kb.nextInt();
		}
		
		
		System.out.print(T.solution(n,j_arr,b_arr));
	}

}
