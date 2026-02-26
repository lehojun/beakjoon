import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] count = new int[10];
		int lt =0, kind = 0, result=0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int rt=0; rt<n; rt++) {
			if(count[arr[rt]]==0) {
				kind++;	
			}
			count[arr[rt]]++;

			
			while(kind>2) {
				count[arr[lt]]--;
				if(count[arr[lt]]==0) kind--;
				lt++;
			}
			
			result = Math.max(result, rt-lt+1);
		}
		
		
		System.out.println(result);

	}

}
