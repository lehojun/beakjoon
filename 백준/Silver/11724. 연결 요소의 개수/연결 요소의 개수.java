import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> arr;
	static int[] ch;
	public void BFS(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		ch[v]=1;
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int nv : arr.get(p)) {
				if(ch[nv]==0) {
					ch[nv]=1;
					BFS(nv);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new ArrayList<ArrayList<Integer>>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ch = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			arr.get(v1).add(v2);
			arr.get(v2).add(v1);
		}
		
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(ch[i]==0) {
				cnt++;
				T.BFS(i);
			}
		}
		System.out.print(cnt);
	}

}
