
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> arr;
	static int n, m, v;
	static int[] ch;
	static StringBuilder sb;

	public void DFS(int v) {
		sb.append(v).append(" ");
		ch[v]=1;
		for(int nv : arr.get(v)) {
			if(ch[nv]==0) {
				ch[nv]=1;
				DFS(nv);
			}
		}
	}
	
	public void BFS(int v) {
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(v);
		ch[v]=1;
		
		while(!Q.isEmpty()) {
			int cur = Q.poll();
			sb.append(cur).append(" ");
			
			for(int nv : arr.get(cur)) {
				if(ch[nv]==0) {
					ch[nv]=1;
					Q.offer(nv);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
    	Main T = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	sb = new StringBuilder();
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	v = Integer.parseInt(st.nextToken());
    	arr= new ArrayList<ArrayList<Integer>>();
    	
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
    	
    	for (int i=1; i<=n; i++) {
    		Collections.sort(arr.get(i));
    	}
    	
    	
    	ch = new int[n+1];
    	T.DFS(v);
    	System.out.println(sb);
    	
    	sb = new StringBuilder();
    	ch = new int[n+1];
    	T.BFS(v);
    	System.out.println(sb);
	}

}
