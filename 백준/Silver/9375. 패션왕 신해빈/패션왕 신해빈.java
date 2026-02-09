import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		Main T = new Main();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder(); 

	    int n = Integer.parseInt(br.readLine());
	    for(int i=0; i<n; i++) {
	    	int m = Integer.parseInt(br.readLine());
	    	HashMap<String, Integer> map = new HashMap<>();
	    	for(int j=0; j<m; j++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		String clothes = st.nextToken();
	    		String category = st.nextToken();
	    		map.put(category, map.getOrDefault(category, 0)+1);
	    	}
	    	int answer = 1;
	    	for(int count : map.values()) { //맵 돌며 values만 확인
	    		answer *= (count+1);
	    	}
	    	sb.append(answer-1).append("\n");
	    }
	    System.out.print(sb);
	}

}
