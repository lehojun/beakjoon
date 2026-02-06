import java.util.*;
public class Main {
	public static class Person implements Comparable<Person>{
		int w, s, total;
		public Person(int w, int s) {
			this.w=w;
			this.s=s;
			this.total=w+s;
		}
		@Override
		public int compareTo(Person ob) {
			return this.total - ob.total; // 오름차순 정렬해서 가장 윗 사람부터 위험도 검사
		}
	}
	
	
	public int solution(int n, ArrayList<Person> arr) {
		int maxRisk = Integer.MIN_VALUE;
		int curWeight = 0;
		
		for(int i=0; i<n; i++) {
			int curRisk =  curWeight - arr.get(i).s;
			if(maxRisk<curRisk) maxRisk = curRisk; // 위험도 갱신
			
			curWeight+=arr.get(i).w; // 몸무게 누적
		}
		return maxRisk;
	}
	
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		ArrayList<Person> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int w=kb.nextInt();
			int s=kb.nextInt();
			arr.add(new Person(w,s));
		}
		Collections.sort(arr);
		
		System.out.print(T.solution(n, arr));
	}
	
}
