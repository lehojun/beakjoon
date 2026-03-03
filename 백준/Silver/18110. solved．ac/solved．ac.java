import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		double percent =(double) n * 15 / 100;
		int cut = (int) Math.round(percent);
		
		int[] arr = new int[n];
		
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		long sum =0;
		for(int i=cut; i<n-cut; i++) {
			sum += arr[i];
		}
		
		double avg = (double) sum/(n-2*cut);
		
		System.out.println(Math.round(avg));
	}
}


