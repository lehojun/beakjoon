import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		int[] heightArr = new int[257];
		int minHeight = 256, maxHeight = 0;

		for(int i=0; i<n; i++) {
		    st = new StringTokenizer(br.readLine());
		    for(int j=0; j<m; j++) {
		        int h = Integer.parseInt(st.nextToken());
		        arr[i][j] = h;
		        heightArr[h]++;
		        minHeight = Math.min(minHeight, h);
		        maxHeight = Math.max(maxHeight, h);
		    }
		}

		int bestTime = Integer.MAX_VALUE;
		int bestHeight = 0;

		for (int h = minHeight; h <= maxHeight; h++) {
		    int time = 0;
		    int inventory = b;

		    for (int i = 0; i <= 256; i++) {
		        if (heightArr[i] == 0) continue;
		        
		        int diff = i - h; 
		        if (diff > 0) { 
		            time += (diff * 2 * heightArr[i]);
		            inventory += (diff * heightArr[i]);
		        } else if (diff < 0) {
		            time += (Math.abs(diff) * heightArr[i]);
		            inventory -= (Math.abs(diff) * heightArr[i]);
		        }
		    }

		    if (inventory >= 0) {
		        if (time <= bestTime) {
		            bestTime = time;
		            bestHeight = h;
		        }
		    }

		}
		System.out.println(bestTime + " " + bestHeight);


	}
}
