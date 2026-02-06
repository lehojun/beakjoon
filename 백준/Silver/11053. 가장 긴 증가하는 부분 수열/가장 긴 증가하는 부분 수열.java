import java.util.*;

public class Main {
	static int[] dy;
	public int solution(int[] arr) {
		int answer=0;
		
		dy=new int[arr.length];
		dy[0]=1;
		for(int i=0;i<arr.length; i++) {
			int max=0;
			for(int j=i-1; j>=0; j--) {
				if(arr[j]<arr[i] && dy[j]>max) max=dy[j]; // 내 앞의 숫자가 나보다 작고 max값이 dy[j]보다 작을 때
			}
			dy[i]=max+1;
			answer=Math.max(answer, dy[i]);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for (int i=0; i<n; i++ ) {
			arr[i]=kb.nextInt();
		}
		System.out.print(T.solution(arr));
	}

}
