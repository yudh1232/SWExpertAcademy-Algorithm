import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			String data = in.readLine();
			char[] ch = data.toCharArray();
			
			int count = 0;
			if (ch[0] == '1')
				count++;
			
			for (int i = 1; i < ch.length; i++) {
				if (ch[i - 1] != ch[i])
					count++;
			}
			
			System.out.println("#" + tc + " " + count);
		}
	}
	
}
