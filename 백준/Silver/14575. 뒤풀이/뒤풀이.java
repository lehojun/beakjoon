import java.util.*;
public class Main {
	static ArrayList<Person> arr;
	static long sumL=0, sumR=0;
	
	public static class Person{
		int l,r;
		public Person(int l, int r) {
			this.l = l;
			this.r = r;
		}
	}
	
	public boolean check(int mid, int n, int t) {
		long sumMax = 0;
		
		for(Person p: arr) {
			if(p.l > mid) return false;
			
			sumMax += Math.min(p.r, mid);
		}
		return sumMax >= t;
	}
	
	public int solution(int n, int t) {
		int answer =0;
		int lt =1, rt = 1000000000;
		
		while(lt<=rt) {
			int mid = (lt+rt)/2;
			if(check(mid,n,t)) {
				answer = mid;
				rt = mid-1;
			} else {
				lt = mid +1;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int t = kb.nextInt();
		arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int l = kb.nextInt();
			int r = kb.nextInt();
			arr.add(new Person(l,r));
		}
		boolean flag = false;
		for(Person p : arr) {
			sumL += p.l;
			sumR += p.r;
		}
		if(sumL>t || sumR<t) flag = true;
		
		if(flag) System.out.print(-1);
		else System.out.print(T.solution(n, t));
	}

}
