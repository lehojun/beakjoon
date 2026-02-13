import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m, cnt;
	static ArrayList<ArrayList<Integer>> arr;
	static int[] result;
	
	public void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		int[] dis = new int[n+1];
		Arrays.fill(dis, -1);
		dis[v]=0;
		q.offer(v);
		while(!q.isEmpty()) {
			int p = q.poll();
			
			for(int nv : arr.get(p)) {
				if(dis[nv]==-1) {
					q.offer(nv);
					dis[nv]=dis[p]+1;
					result[v] += dis[nv];
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr= new ArrayList<ArrayList<Integer>>();
		result = new int[n+1];
		int minSum = Integer.MAX_VALUE;
		int answer =0;
		
		for(int i=0; i<=n; i++ ) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			arr.get(v1).add(v2);
			arr.get(v2).add(v1);
		}
		
		for(int i=1; i<=n; i++) {
			T.BFS(i);
		}
		
		for(int i=1; i<=n; i++) {
			if(result[i]<minSum) {
				minSum=result[i];
				answer=i;
			}
		}
		System.out.print(answer);
	}

}