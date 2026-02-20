import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long finalResult = 0;
		long[] arr = new long[k];
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		long lt = 1, result;
		long rt = Arrays.stream(arr).max().getAsLong();
		while(lt<=rt) {
			long mid = (lt+rt)/2;
			result = 0;
			for(int i=0; i<k; i++) {
				result += arr[i]/mid;
			}
			if(result>=n) {
				finalResult = mid;
				lt= mid+1;
			} else {
				rt=mid-1;
			}
		}
		
		System.out.print(finalResult);
	}
}
