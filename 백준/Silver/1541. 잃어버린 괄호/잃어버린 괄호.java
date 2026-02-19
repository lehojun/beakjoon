import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split("-");
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			int tempSum = 0;
			
			String[] numbers = arr[i].split("\\+");
			
			for (String num : numbers) {
				tempSum += Integer.parseInt(num);
			}
			
			if(result == Integer.MAX_VALUE) {
				result = tempSum;
			} else {
				result -= tempSum;
			}
		}
		System.out.println(result);
	}

}

