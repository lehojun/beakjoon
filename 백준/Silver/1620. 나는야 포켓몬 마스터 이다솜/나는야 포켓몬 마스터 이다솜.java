import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder(); 
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    
	    String[] nameArr = new String[n + 1]; 
	    HashMap<String, Integer> nameMap = new HashMap<>(); 
	    
	    for(int i = 1; i <= n; i++) {
	        String name = br.readLine();
	        nameArr[i] = name;
	        nameMap.put(name, i);
	    }
	    
	    for(int i = 0; i < m; i++) {
	        String question = br.readLine();
	        
	        if(Character.isDigit(question.charAt(0))) {
	            int num = Integer.parseInt(question);
	            sb.append(nameArr[num]).append("\n");
	        } else {
	            sb.append(nameMap.get(question)).append("\n");
	        }
	    }
	    System.out.print(sb.toString());
	}
}