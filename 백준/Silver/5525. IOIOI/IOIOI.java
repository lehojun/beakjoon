import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int cnt =0;
		String s = br.readLine();
		String p = "";
		
		for(int i=0; i<n; i++) {
			p += "IO";
		}
		p+="I";
		
		String ch="";
		for(int i=0; i<p.length(); i++) {
			ch+=s.charAt(i);
		}

		for(int rt=p.length(); rt<s.length(); rt++) {
			if(ch.equals(p)) {
				cnt++;
			}
			ch = ch.substring(1);
			ch += s.charAt(rt);
		}
		if(ch.equals(p)) {
			cnt++;
		}
		
		System.out.print(cnt);
	}

}