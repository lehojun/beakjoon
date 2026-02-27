import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void BFS(int a, int b) {
		Queue<Integer> q = new LinkedList<>();
		arr = new String[10000];
		visited = new boolean[10000];
		
		q.offer(a);
		visited[a]=true;
		arr[a]="";
		
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n==b) {
				sb.append(arr[b]).append("\n");
				return;
			}
			int d, s, l, r;
			
			d = (2*n) % 10000;
			if(!visited[d]) {
				visited[d]=true;
				arr[d]=arr[n]+"D";
				q.offer(d);
			}
			
			if(n==0) s = 9999;
			else s = n-1;
			if(!visited[s]) {
				visited[s]=true;
				arr[s]=arr[n]+"S";
				q.offer(s);
			}
			
			l = (n%1000)*10 + n/1000;
			if(!visited[l]) {
				visited[l]=true;
				arr[l]=arr[n]+"L";
				q.offer(l);
			}
			
			r = (n%10)*1000 + n/10;
			if(!visited[r]) {
				visited[r]=true;
				arr[r]=arr[n]+"R";
				q.offer(r);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			BFS(a,b);
		}
		System.out.print(sb);
	}
}