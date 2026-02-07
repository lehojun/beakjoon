import java.util.*;

public class Main {
	static int n, k;
	static ArrayList<ArrayList<Integer>> tree;
	static int[] apple;
	public int BFS() {
		int answer =0;
		Queue<Integer> Q = new LinkedList<>();
		int[] dis = new int[n]; // 거리 배열
		Arrays.fill(dis, -1); // 0번 노드와 구분 짓기 위함, 그리고 탐색을 했는지 안했는지 구분하기 위해 -1로 초기화
		dis[0] = 0; // 0번 노드 방문 처리
		Q.offer(0); 
		
		
		while(!Q.isEmpty()) {
			int cur= Q.poll();
			
			// k 거리 안에 있고, 사과가 있는 노드인경우 answer++
			if(dis[cur]<=k && apple[cur] == 1) answer ++; 
			
			// k 거리 안에 있고, 방문 하지 않은 인접 노드들을 큐에 넣음
			if(dis[cur]<k) {
				for(int next: tree.get(cur)) {
					if(dis[next] == -1) {
						dis[next] = dis[cur] +1;
						Q.offer(next);
					}
				}
			}
		}
		
		
		return answer;
	}

	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		n = kb.nextInt();
		k = kb.nextInt();
		tree = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0; i<n; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<n-1; i++ ) {
			int p= kb.nextInt();
			int c = kb.nextInt();
			tree.get(p).add(c);
		}
		
		apple = new int[n];
		for(int i=0; i<n; i++) apple[i] = kb.nextInt();
		
		System.out.print(T.BFS());
	}

}
