import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++ ) {
			String name = kb.next();
			map.put(name, map.getOrDefault(name, 0)+1);
		} 
		
		for(int i=0; i<m; i++) {
			String name = kb.next();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		
		List<String> result = new ArrayList<>();
		
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() >= 2) {
				result.add(entry.getKey());
			}
		}
		Collections.sort(result);
		System.out.println(result.size());
		for(String name: result) {
			System.out.println(name);
		}
	}
	

}
